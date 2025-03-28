# Proyecto_IntMod

Autores:

- [Pablo Morillas Esteve](https://github.com/pablomorillas)
- [Emilio García Muñoz](https://github.com/Emilsito)
- [Sergio Llorente Gonzalez](https://github.com/CaulShiverss)

## Índice

1. [Sistema de información](/Documentacion/SistemaInformacion.md)
2. [Modelo entidad relación](/Documentacion/ModeloEntidadRelacion.md)
3. [Modelo Relacional](/Documentacion/ModeloRelacional.md)
4. [Diccionario de Datos](/Documentacion/DiccionarioDeDatos.md)

5. [Creacion de la Base de Datos](/Documentacion/CreacionBaseDatos.md)
6. [Consultas Simples](/Documentacion/ConsultasSimples.md)
6. [Consultas Agregadas](/Documentacion/ConsultasAgregadas.md)
9. [PY813](#PY813)

## PY813

### 1. Subconsultas (Emilio)

#### Obtener el nombre de los empleados nacidos antes del 90.

```sql
SELECT nombre 
FROM EMPLEADO 
WHERE cod_empleado in (select cod_empleado from EMPLEADO where year(f_nacimiento) < 1990);
```

#### Obtener el nombre y teléfono del cliente que ha jugado más partidas.

```sql
SELECT nombre, telefono
FROM CLIENTE
WHERE cod_cliente = (
    SELECT cod_cliente 
    FROM JUGAR 
    GROUP BY cod_cliente 
    ORDER BY COUNT(*) DESC 
    LIMIT 1
);
```

#### Listar los productos que tienen un precio mayor que el precio medio de todos los productos.

```sql
SELECT nombre, precio
FROM PRODUCTO
WHERE precio > (SELECT AVG(precio) FROM PRODUCTO);
```

#### Obtener el número de partidas jugadas por cada cliente.

```sql
SELECT c.nombre, p.total_partidas
FROM CLIENTE c
JOIN (
    SELECT cod_cliente, COUNT(*) AS total_partidas
    FROM JUGAR
    GROUP BY cod_cliente
) p ON c.cod_cliente = p.cod_cliente;
```

#### Mostrar los empleados que han atendido al menos a un cliente.

```sql
SELECT nombre
FROM EMPLEADO e
WHERE EXISTS (
    SELECT 1 
    FROM ATENDER a 
    WHERE a.cod_empleado = e.cod_empleado
);
```

### 2. Consultas con CTEs (Sergio)

#### Seleccionar los productos que cuesten más de 200 euros con más de 50 unidades y que hayan sido comprados por un cliente con un numero de telefono que empiece por 620

```sql
with productos50unidades100euros as (
    select cod_producto from PRODUCTO
    where precio > 200 and unidades > 50
)

select p.* from PRODUCTO p
    join productos50unidades100euros pp on pp.cod_producto = p.cod_producto
    join COMPRAR c on c.cod_producto = p.cod_producto
    join CLIENTE cli on cli.cod_cliente = c.cod_cliente
where cli.telefono like "620%";
```

#### Seleccionar el nombre de los clientes que hayan sido atendidos por empleados con más de 2 clientes atendidos.

```sql
with empleados2clientes (
    select e.cod_empleado from EMPLEADO e
    join ATENDER a on e.cod_empleado = a.cod_empleado
    group by e.cod_empleado
    having (count(cod_cliente) >= 2);
)

select c.nombre from CLIENTE c
    join ATENDER a on a.cod_cliente = c.cod_cliente
where c.cod_empleado in (select * from empleados2clientes);
```

### 3. Creacion de tabla con consulta (Sergio)

#### Tabla con los productos que no se han comprado y cuestan más que la media


```sql
create table productosSinCompra100 as
select p.* from PRODUCTO p
    left join COMPRAR c on c.cod_producto = p.cod_producto
where c.cod_producto is null and p.precio > (select avg(precio) from PRODUCTO);
```

### 4. Indices que optimicen las consultas (Pablo)

```sql
CREATE INDEX empleadoFeNac ON EMPLEADO(f_Nacimiento);
```

```sql
CREATE INDEX precioProducto ON PRODUCTO(precio);
```

### 5. Planes de ejecucion antes y después (Pablo)

#### Demostracion 1

##### Consulta

```sql
SELECT nombre, precio
FROM PRODUCTO
WHERE precio > (SELECT AVG(precio) FROM PRODUCTO);
```

##### Indice

```sql
CREATE INDEX precioProducto ON PRODUCTO(precio);
```

##### Antes

```
+------+-------------+----------+------+---------------+------+---------+------+------+-------------+
| id   | select_type | table    | type | possible_keys | key  | key_len | ref  | rows | Extra       |
+------+-------------+----------+------+---------------+------+---------+------+------+-------------+
|    1 | PRIMARY     | PRODUCTO | ALL  | NULL          | NULL | NULL    | NULL | 60   | Using where |
|    2 | SUBQUERY    | PRODUCTO | ALL  | NULL          | NULL | NULL    | NULL | 60   |             |
+------+-------------+----------+------+---------------+------+---------+------+------+-------------+
2 rows in set (0.001 sec)
```


##### Después

```
+------+-------------+----------+-------+----------------+----------------+---------+------+------+-------------+
| id   | select_type | table    | type  | possible_keys  | key            | key_len | ref  | rows | Extra       |
+------+-------------+----------+-------+----------------+----------------+---------+------+------+-------------+
|    1 | PRIMARY     | PRODUCTO | ALL   | precioProducto | NULL           | NULL    | NULL | 60   | Using where |
|    2 | SUBQUERY    | PRODUCTO | index | NULL           | precioProducto | 4       | NULL | 60   | Using index |
+------+-------------+----------+-------+----------------+----------------+---------+------+------+-------------+
2 rows in set (0.001 sec)
```

#### Demostracion 2

##### Consulta

```sql
SELECT nombre 
FROM EMPLEADO 
WHERE cod_empleado in (select cod_empleado from EMPLEADO where year(f_nacimiento) < 1990);
```

##### Indice

```sql
CREATE INDEX empleadoFeNac ON EMPLEADO(f_Nacimiento);
```

##### Antes

```
+------+-------------+----------+--------+---------------+---------+---------+---------------------------------------+------+-------------+
| id   | select_type | table    | type   | possible_keys | key     | key_len | ref                                   | rows | Extra       |
+------+-------------+----------+--------+---------------+---------+---------+---------------------------------------+------+-------------+
|    1 | PRIMARY     | EMPLEADO | ALL    | PRIMARY       | NULL    | NULL    | NULL                                  | 40   |             |
|    1 | PRIMARY     | EMPLEADO | eq_ref | PRIMARY       | PRIMARY | 4       | ProyectoIntMod2.EMPLEADO.cod_empleado | 1    | Using where |
+------+-------------+----------+--------+---------------+---------+---------+---------------------------------------+------+-------------+
2 rows in set (0.001 sec)
```


##### Después

```
+------+-------------+----------+--------+-----------------------+---------------+---------+---------------------------------------+------+--------------------------+
| id   | select_type | table    | type   | possible_keys         | key           | key_len | ref                                   | rows | Extra                    |
+------+-------------+----------+--------+-----------------------+---------------+---------+---------------------------------------+------+--------------------------+
|    1 | PRIMARY     | EMPLEADO | range  | PRIMARY,empleadoFeNac | empleadoFeNac | 4       | NULL                                  | 20   | Using where; Using index |
|    1 | PRIMARY     | EMPLEADO | eq_ref | PRIMARY               | PRIMARY       | 4       | ProyectoIntMod2.EMPLEADO.cod_empleado | 1    |                          |
+------+-------------+----------+--------+-----------------------+---------------+---------+---------------------------------------+------+--------------------------+
2 rows in set (0.001 sec)
```














