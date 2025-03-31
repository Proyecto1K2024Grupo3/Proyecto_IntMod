# PL/SQL Avanzado

## Definición de 2 eventos que automaticen tareas con diferente periodicidad

### Evento 1 (Sergio Llorente)

- Teniendo la tabla:

```sql 
create or replace table logTotalProductos(
    id int auto_increment primary key,
    fechaHora TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    totalProductos int
);
```

- Creamos un evento que registre el total de cantidad de productos que tiene la tienda diariamente:

```sql 
delimiter //
create or replace event daily_log_products 
on schedule every 1 day
do
begin
    declare totalProductos int;
    select sum(unidades) into totalProductos from PRODUCTO;
    insert into logTotalProductos(totalProductos) values(totalProductos);
end ; //
delimiter ;
```

Resultado:

``` 
MariaDB [ProyectoIntMod2]> select * from logTotalProductos;
+----+---------------------+----------------+
| id | fechaHora           | totalProductos |
+----+---------------------+----------------+
|  1 | 2025-03-31 06:41:31 |           8311 |
+----+---------------------+----------------+
1 row in set (0.000 sec)
```

### Evento 2 (Pablo)

Teniendo la tabla:

```sql 
CREATE TABLE ProductosMasVendidos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cod_producto INT,
    nombre_producto VARCHAR(64),
    cantidad_vendida INT,
    fecha_actualizacion DATE,
    FOREIGN KEY (cod_producto) REFERENCES PRODUCTO(cod_producto) ON DELETE CASCADE ON UPDATE CASCADE
);
```

Vamos a almacenar los 5 productos más vendidos cada semana usando un evento que llame a un procedimiento almacenado.

Procedimiento:
```sql 
DELIMITER //
CREATE PROCEDURE ObtenerProductosMasVendidos()
BEGIN
    DECLARE fecha_actual DATE;
    SET fecha_actual = CURDATE();
    
    DELETE FROM ProductosMasVendidos;
    
    INSERT INTO ProductosMasVendidos (cod_producto, nombre_producto, cantidad_vendida, fecha_actualizacion)
    SELECT p.cod_producto, p.nombre, COUNT(*) AS cantidad_vendida, fecha_actual
    FROM COMPRAR c
    JOIN PRODUCTO p ON c.cod_producto = p.cod_producto
    WHERE c.fecha >= DATE_SUB(fecha_actual, INTERVAL 7 DAY)
    GROUP BY p.cod_producto, p.nombre
    ORDER BY cantidad_vendida DESC
    LIMIT 5;
END //
DELIMITER ;
```

Evento:
```sql 
DELIMITER //
CREATE EVENT ActualizarProductosMasVendidos
ON SCHEDULE EVERY 1 WEEK
STARTS TIMESTAMP(CURDATE(), '00:00:00')
DO
BEGIN
    CALL ObtenerProductosMasVendidos();
END //
DELIMITER ;
```

Resultado:

``` 
MariaDB [ProyectoIntMod2]> select * from ProductosMasVendidos;
+----+--------------+------------------------------------+------------------+---------------------+
| id | cod_producto | nombre_producto                    | cantidad_vendida | fecha_actualizacion |
+----+--------------+------------------------------------+------------------+---------------------+
|  1 |            3 | Xbox Series X                      |                1 | 2025-03-31          |
|  2 |           58 | Figura coleccionista Resident Evil |                1 | 2025-03-31          |
|  3 |           59 | Póster Red Dead Redemption 2       |                1 | 2025-03-31          |
|  4 |           60 | Lámpara Pac-Man                    |                1 | 2025-03-31          |
+----+--------------+------------------------------------+------------------+---------------------+
4 rows in set (0.001 sec)
```

## Definición de 2 disparadores sobre operaciones asociadas al modelo de datos.

### Trigger 1 (Sergio Llorente)

- Trigger que comprueba después de la inserción de un producto si las unidades y el precio son numeros positivos, en caso de no serlo los pone a 0

```sql 
delimiter //
create or replace trigger trg_before_insert_precio
before insert on PRODUCTO for each row
begin

    if new.precio < 0 then
        set new.precio = 0;
    end if;
    
    if new.unidades <0 then
        set new.unidades = 0;
    end if;

end ; //
delimiter ;
```

Resultado: 

``` 
insert into PRODUCTO values(61, -13, -5, "Ejemplo");
```

``` 
|           56 |  35.00 |       90 | Bolsa de tela de Elden Ring               |
|           57 |  20.00 |      250 | Gorra Cyberpunk 2077                      |
|           58 |  60.00 |       50 | Figura coleccionista Resident Evil        |
|           59 |  40.00 |      110 | Póster Red Dead Redemption 2              |
|           60 |  55.00 |       75 | Lámpara Pac-Man                           |
|           61 |   0.00 |        0 | Ejemplo                                   |
+--------------+--------+----------+-------------------------------------------+
```

### Trigger 2 (Pablo)

Trigger que después de la insercion de una partida se encarga de comprobar que la sala existe.

```sql 
DELIMITER // 
CREATE OR REPLACE TRIGGER comprobarSalaCorrecta 
BEFORE INSERT ON PARTIDA FOR EACH ROW 
BEGIN 
    DECLARE sala_existe INT; 
    SELECT COUNT(*) INTO sala_existe FROM SALA WHERE n_sala = NEW.n_sala; 

    if sala_existe = 0 THEN 
        SET NEW.n_sala = 0; 
    END IF; 
END;  
// 
DELIMITER ; 
```

## Definición de 2 procedimientos almacenados que realicen más de una operación dentro de una transacción, haciendo una gestión adecuada de los errores, ya sea mediante señales o excepciones, y sus consiguientes manejadores.

### Procedimiento 1 (Sergio Llorente)

```sql 
delimiter //
create or replace procedure realizarCompra(in _codProducto int, in _codCliente int)
begin 
    declare totalProducto int;

    declare exit handler for sqlstate '45000'
    begin
        get diagnostics condition 1
            @mensaje = message_text;
        select @mensaje;
    end;

    declare exit handler for sqlexception
    begin
        select "[!] Algo fallo" as mensaje;
        rollback;
    end;

    select unidades into totalProducto from PRODUCTO where cod_producto = _codProducto;
    if totalProducto > 0 then
        start transaction;
            insert into COMPRAR values (_codCliente, _codProducto, null, CURDATE());
            update PRODUCTO set unidades = unidades-1 where cod_producto = _codProducto;
        commit;
    else 
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = "[!] No queda Stock";
    end if;
end ; //
delimiter ;
```

Compra exitosa:

```sql 
call realizarCompra(30, 7);
```

Tabla COMPRAR:
```
|           6 |            6 | 35% OFF   | 2023-06-01 |
|           6 |           46 | 20% OFF   | 2024-04-20 |
|           6 |           56 | 20% OFF   | 2025-02-10 |
|           7 |            7 | NULL      | 2006-06-06 |
|           7 |           23 | NULL      | 2023-07-01 |
***|           7 |           30 | NULL      | 2025-03-31 |***
|           7 |           47 | 25% OFF   | 2024-05-25 |
|           7 |           57 | 45% OFF   | 2025-03-15 |
|           8 |            8 | NULL      | 2023-08-01 |
|           8 |           48 | NULL      | 2024-06-30 |

```

Compra fallida (Compraré el producto con 0 de stock creado antes):

```sql 
call realizarCompra(61, 7);
```

``` 
+--------------------+
| @mensaje           |
+--------------------+
| [!] No queda Stock |
+--------------------+
1 row in set (0.000 sec)

Query OK, 1 row affected (0.001 sec)
```

### Procedimiento 2 (Emilio)

Procedimiento que inserta, o en caso que exista, actualiza un Colaborador

```sql 
DELIMITER //
CREATE OR REPLACE PROCEDURE insertarColaborador(IN _nombreUsuarioColaborador VARCHAR(64), IN _nombreColaborador VARCHAR(64))
BEGIN
    DECLARE EXIT HANDLER FOR 1062
    BEGIN
        UPDATE COLABORADOR SET nombre = _nombreColaborador WHERE n_usuario = _nombreUsuarioColaborador;
        SELECT 'Ya habia un usuario colaborador con ese nombre, se le ha actualizado al que has introducido' as mensaje;
    END;

    DECLARE EXIT HANDLER FOR SQLEXCEPTION
        SELECT 'Ha ocurrido un error' as mensaje;

    INSERT INTO COLABORADOR VALUES(_nombreUsuarioColaborador, _nombreColaborador);
    SELECT 'Colaborador insertado correctamente' as mensaje;
END;
//
DELIMITER ;   
```

Uso:

```sql 
call insertarColaborador("auronplay", "Raul Morillas");
```

``` 
MariaDB [ProyectoIntMod2]> select * from COLABORADOR;
+----------------+-------------------+
| n_usuario      | nombre            |
+----------------+-------------------+
| anamartinez    | Ana Martínez      |
| andres_perez   | Andrés Pérez      |
| auronplay      | Raul Morillas     |
| carlohernandez | Carlos Hernández  |

```

Le modifico el nombre:

``` 
MariaDB [ProyectoIntMod2]> call insertarColaborador("auronplay", "Raul Garcia");
+---------------------------------------------------------------------------------------------+
| mensaje                                                                                     |
+---------------------------------------------------------------------------------------------+
| Ya habia un usuario colaborador con ese nombre, se le ha actualizado al que has introducido |
+---------------------------------------------------------------------------------------------+
1 row in set (0.005 sec)

Query OK, 1 row affected (0.005 sec)
```

``` 
MariaDB [ProyectoIntMod2]> select * from COLABORADOR;
+----------------+-------------------+
| n_usuario      | nombre            |
+----------------+-------------------+
| anamartinez    | Ana Martínez      |
| andres_perez   | Andrés Pérez      |
| auronplay      | Raul Garcia       |
| carlohernandez | Carlos Hernández  |
```


## Definición de 2 procedimientos almacenados que utilicen cursores que recorran cierta cantidad de datos, realizando operaciones sobre una o más tablas, haciendo una gestión adecuada de los errores, ya sea mediante señales o excepciones, y sus consiguientes manejadores.

### Procedimiento con Cursor 1 (Emilio)

Procedimiento que usando un cursor, modifica el telefono de todos los empleados aádiendo el prefijo +34

```sql 
DELIMITER //
CREATE OR REPLACE PROCEDURE ActualizarTelefonosEmpleados()
BEGIN
    DECLARE done INT DEFAULT FALSE;
    DECLARE _codigo_empleado INT;
    DECLARE _telefono_nuevo CHAR(9);
    DECLARE cur CURSOR FOR SELECT cod_empleado, telefono FROM EMPLEADO;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
    
    OPEN cur;
    WHILE done = FALSE DO
        FETCH cur INTO _codigo_empleado, _telefono_nuevo;
        
        UPDATE EMPLEADO SET telefono = CONCAT('+34', _telefono_nuevo) WHERE cod_empleado = _codigo_empleado;
    END WHILE;
    
    CLOSE cur;
END;
//
DELIMITER ;
```

```sql 
call ActualizarTelefonosEmpleados();
```

``` 
MariaDB [ProyectoIntMod2]> select * from EMPLEADO;
+--------------+-----------+--------------+--------------+--------------------+
| cod_empleado | dni       | telefono     | f_Nacimiento | nombre             |
+--------------+-----------+--------------+--------------+--------------------+
|            1 | 12345678A | +34600123456 | 1990-01-01   | Juan Pérez         |
|            2 | 23456789B | +34600234567 | 1985-05-15   | Ana López          |
|            3 | 34567890C | +34600345678 | 1992-09-10   | Carlos García      |
|            4 | 45678901D | +34600456789 | 1980-03-25   | María Fernández    |
|            5 | 56789012E | +34600567890 | 1995-07-12   | Pedro Sánchez      |
|            6 | 67890123F | +34600678901 | 1988-11-05   | Mariano Rajoy      |
|            7 | 78901234G | +34600789012 | 1982-02-20   | El Pepe            |
|            8 | 89012345H | +34600890123 | 1993-06-18   | Marta Ruiz         |
|            9 | 90123456I | +34600901234 | 1991-12-08   | Patrick Bateman    |
|           10 | 01234567J | +34600012345 | 1987-08-30   | Clara Moreno       |
|           11 | 11223344K | +34601123456 | 1994-04-10   | Santiago Giménez   |
|           12 | 22334455L | +34601234567 | 1986-07-22   | Lucía Torres       |
|           13 | 33445566M | +34601345678 | 1990-12-05   | Fernando Alonso    |
|           14 | 44556677N | +34601456789 | 1997-02-14   | Isabel Jiménez     |
|           15 | 55667788O | +34601567890 | 1983-09-30   | 
```


### Procedimiento con Cursor 2 (Emilio)

Procedimiento que, usando un cursor, modifica los nombres de los clientes poniendolos en mayusculas

```sql 
DELIMITER //
CREATE PROCEDURE ActualizarNombresClientes()
BEGIN
    DECLARE done INT DEFAULT FALSE;
    DECLARE rowCliente ROW TYPE OF CLIENTE;
    DECLARE cur CURSOR FOR SELECT * FROM CLIENTE;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
    
    OPEN cur;
    WHILE done = FALSE DO
        FETCH cur INTO rowCliente;
        
        IF done = false THEN 
               
        UPDATE CLIENTE SET nombre = UPPER(rowCliente.nombre) WHERE cod_cliente = rowCliente.cod_cliente;
        
        END IF;
        
    END WHILE;
    
    CLOSE cur;
END;
//
DELIMITER ;
```

```sql 
call ActualizarNombresClientes();
```

``` 
MariaDB [ProyectoIntMod2]> select * from CLIENTE;
+-------------+-----------------+-----------+
| cod_cliente | nombre          | telefono  |
+-------------+-----------------+-----------+
|           1 | CARLOS LÓPEZ    | 600123456 |
|           2 | MARÍA GARCÍA    | 610987654 |
|           3 | JUAN PÉREZ      | 620345678 |
|           4 | ANA MARTÍNEZ    | 630876543 |
|           5 | LUIS FERNÁNDEZ  | 640456789 |
|           6 | LAURA SÁNCHEZ   | 650789123 |
|           7 | PEDRO GÓMEZ     | 660234567 |
|           8 | ELENA TORRES    | 670987321 |
|           9 | JORGE RUIZ      | 680654321 |
|          10 | LUCÍA MORALES   | 690123789 |
+-------------+-----------------+-----------+
10 rows in set (0.001 sec)

```