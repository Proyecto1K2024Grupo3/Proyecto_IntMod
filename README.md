# Proyecto_IntMod

Autores:

- [Pablo Morillas Esteve](https://github.com/pablomorillas)
- [Emilio García Muñoz](https://github.com/Emilsito)
- [Sergio Llorente Gonzalez](https://github.com/CaulShiverss)

## Índice

1. [Sistema de información](#sistema-de-información)
2. [Modelo entidad relación](#modelo-entidad-relación)
3. [Decisiones](#decisiones)
4. [Modelo Relacional](#modelo-relacional)
5. [Diccionario de Datos](#diccionario-de-datos)
6. [Tablas Modelo Físico](#tablas-modelo-fisico)
7. [Registros Modelo Fisico](#registros-modelo-fisico)
8. [Consultas Agregadas](#consultas-agregadas)
9. [PY813](#PY813)


## Sistema de información

Una tienda de videojuegos vende merchandising, consolas y videojuegos. De estos productos se debe almacenar el precio, número de existencias y nombre. De los videojuegos se quiere saber la fecha de lanzamiento y de el merchandising el tipo y el tamaño. Hay que almacenar tambíen que consolas han sustituido a otras consolas.

De los clientes que compran en la tienda se requiere conocer el nombre, el teléfono de contacto y el codigo de cliente. De cada compra se debe registrar la fecha y si se ha usado alguna promoción.  Un cliente puede comprar más de un productos y un producto puede ser comprado por varios clientes.

Los clientes pueden participar en partidas de videojuegos que se organizan en salas de la tienda. Cada partida se identifica por un numero correlativo y hay que registrar en que sala se juega. Una partida tiene que ser jugada por dos clientes. De cada partida debe almacenarse el ganador y la duracion de esta.

Los empleados se encargan de atender a los clientes y manejar el inventario de los productos. Del empleado interesa registrar el DNI, la fecha de nacimiento, el teléfono de contacto y el codigo de empleado. Un empleado puede atender a varios clientes y un cliente puede ser atendido por varios empleados. 

Existe un inventario de productos el cual es llevado por empleados. Varios empleados se encargan de manejar el inventario de productos, y estos productos pueden ser manejados por más de un empleado.

Los productos los suministran diferentes proveedores, un producto solo puede ser suministrado por un proveedor y un proveedor puede suministrar diferentes productos, de cada proveedor se desea conocer el NIF, nombre y direccion.

La tienda colabora con influencers para promocionar sus productos, interesa registrar el nombre del influencer para identificarlo, su usuario en redes sociales y la tarifa por la colaboración con la tienda. Cada influencer puede promocionar varios productos y los producto pueden ser promocionados por varios influencers.

## Modelo entidad relación

![imatge](https://github.com/user-attachments/assets/20042a02-c22e-424e-83f2-1b9a4b39cb27)


## Decisiones

En la tienda hay varias salas en las que se juegan partidas entre dos clientes. Queremos recoger estos datos para en caso de alguna incidencia poder identificar que dos clientes se encontraban en la sala. Y almacenamos el ganador de cada partida porque el que mas partidas gane al mes se lleva un premio.

Queremos controlar el inventario de la tienda, por lo tanto almacenamos que empleados han organizado cada producto. Hemos decidido hacerlo de esta manera porque cada empleado se encargará de la integridad de sus productos. Un empleado se encargá de el merchandising, otro de las consolas... etc.

Hemos decidido recoger la tarifa de cada promoción en el atributo porque es un precio que depende de la repercusion del colaborador. A Ibai no le pagariamos lo mismo que a Aitor Medrano.

## Modelo Relacional 

EMPLEADO (**cod_empleado**, dni, telefono, f_Nacimiento, nombre)
- PK: cod_empleado
- UK: dni

CLIENTE (**cod_cliente**, nombre, telefono)
- PK: cod_cliente

ATENDER (**cod_empleado** *, **cod_cliente** *)
- PK: cod_empleado, cod_cliente
- FK: cod_empleado → EMPLEADO
- FK: cod_cliente → CLIENTE

PARTIDA (**cod_partida**, inicio, fin, n_sala *)
- PK: cod_partida
- FK: n_sala → SALA
- VNN: n_sala
- UK: n_sala

JUGAR (**cod_partida** *, **cod_cliente** *, ganador)
- PK: cod_partida, cod_cliente
- FK: cod_partida → PARTIDA
- FK: cod_cliente → CLIENTE

SALA (**n_sala**, tamaño)
- PK: n_sala

PRODUCTO (**cod_Producto**, precio, unidades, nombre)
- PK: cod_Producto

CONSOLA (**cod_Producto** *)
- PK: cod_Producto

SUSTITUIR (**cod_Producto1** *, **cod_Producto2** *)
- PK: cod_Producto1, cod_Producto2
- FK: cod_Producto1, cod_Producto2 → CONSOLA

VIDEOJUEGO (**cod_Producto** *, f_lanzamiento)
- PK: cod_Producto

MERCHANDISING (**cod_Producto** *, tipo, tamaño)
- PK: cod_Producto

COMPRAR (**cod_cliente** *, **cod_Producto** *, promoción, fecha)
- PK: cod_cliente, cod_Producto
- FK: cod_cliente → CLIENTE
- FK: cod_Producto → PRODUCTO

ORGANIZAR (**cod_Empleado** *, **cod_Producto** *)
- PK: cod_Empleado, cod_Producto
- FK: cod_Empleado → EMPLEADO
- FK: cod_Producto → PRODUCTO

COLABORADOR (**n_usuario**, nombre)
- PK: n_usuario

PROMOCIONAR (**cod_Producto** *, **n_usuario** *, tarifa)
- PK: cod_Producto, n_usuario
- FK: cod_Producto → PRODUCTO
- FK: n_usuario → COLABORADOR

PROVEEDOR (**nif**, nombre, dirección)
- PK: nif

PROVEER (**cod_Producto** *, **nif** *)
- PK: cod_Producto, nif
- FK: cod_Producto → PRODUCTO
- FK: nif → PROVEEDOR

## Diccionario de Datos

### Tablas 

Tabla EMPLEADO

| Columna        | Tipo de Datos | Descripción                            |
|----------------|---------------|----------------------------------------|
| `cod_empleado` | INT           | Clave primaria del empleado.           |
| `dni`          | VARCHAR(32)   | Dni del empleado.                      |
| `telefono`     | INT           | Número de teléfono del empleado.       |
| `f_Nacimiento` | DATE          | Fecha de nacimiento del empleado.      |
| `nombre`       | VARCHAR(64)   | Nombre del empleado.                   |

Tabla CLIENTE

| Columna        | Tipo de Datos | Descripción                            |
|----------------|---------------|----------------------------------------|
| `cod_cliente`  | INT           | Clave primaria del cliente.            |
| `nombre`       | VARCHAR(64)   | Nombre del cliente.                    |
| `telefono`     | INT           | Teléfono del cliente.                  |

Tabla ATENDER

| Columna        | Tipo de Datos | Descripción                            |
|----------------|---------------|----------------------------------------|
| `cod_empleado` | INT           | Clave primaria del empleado.           |
| `cod_cliente`  | INT           | Clave primaria del cliente.            |

Tabla PARTIDA

| Columna        | Tipo de Datos | Descripción                            |
|----------------|---------------|----------------------------------------|
| `cod_partida`  | INT           | Clave primaria de la partida.          |
| `inicio`       | TIME          | Inicio de la partida.                  |
| `fin`          | TIME          | Final de la partida.                   |
| `n_sala`       | INT           | Clave ajena que apunta a `SALA`, número de la sala donde se juega la partida. |

Tabla JUGAR

| Columna        | Tipo de Datos | Descripción                            |
|----------------|---------------|----------------------------------------|
| `cod_partida`  | INT           | Clave primaria de la partida.          |
| `cod_cliente`  | INT           | Código único del cliente.              |
| `ganador`      | VARCHAR(32)   | Ganador de la partida.                 |

Tabla SALA

| Columna        | Tipo de Datos | Descripción                            |
|----------------|---------------|----------------------------------------|
| `n_sala`       | INT           | Clave primaria de la sala.             |
| `tamaño`       | INT           | Tamaño de la sala.                     |

Tabla PRODUCTO

| Columna        | Tipo de Datos | Descripción                            |
|----------------|---------------|----------------------------------------|
| `cod_producto` | INT           | Clave primaria del producto.           |
| `precio`       | INT           | Precio del producto.                   |
| `unidades`     | INT           | Unidades que tiene el producto.        |
| `nombre`       | VARCHAR(64)   | Nombre del producto.                   |

Tabla CONSOLA

| Columna        | Tipo de Datos | Descripción                            |
|----------------|---------------|----------------------------------------|
| `cod_Producto` | INT           | Clave primaria del producto, clave ajena que apunta a `PRODUCTO`. |

Tabla SUSTITUIR

| Columna        | Tipo de Datos | Descripción                            |
|----------------|---------------|----------------------------------------|
| `cod_Producto1`| INT           | Clave primaria del producto, clave ajena que apunta a `PRODUCTO`. |
| `cod_Producto2`| INT           | Clave primaria de la consola, clave ajena que apunta a `CONSOLA`. |

Tabla VIDEOJUEGO

| Columna        | Tipo de Datos | Descripción                            |
|----------------|---------------|----------------------------------------|
| `cod_Producto` | INT           | Clave primaria del producto, clave ajena que apunta a `PRODUCTO`. |
| `f_lanzamiento`| DATE          | Fecha de lanzamiento del videojuego.   |

Tabla MERCHANDISING

| Columna        | Tipo de Datos | Descripción                            |
|----------------|---------------|----------------------------------------|
| `cod_Producto` | INT           | Clave primaria del producto, clave ajena que apunta a `PRODUCTO`. |
| `tipo`         | VARCHAR(32)   | Tipo de merchandising.                 |
| `tamaño`       | INT           | Tamaño del merchandising.              |

Tabla COMPRAR

| Columna        | Tipo de Datos | Descripción                            |
|----------------|---------------|----------------------------------------|
| `cod_Cliente`  | INT           | Clave primaria del cliente.            |
| `cod_Producto` | INT           | Clave ajena que apunta a `PRODUCTO`.   |
| `promocion`    | VARCHAR(32)   | Promoción en la compra del producto.   |
| `fecha`        | DATE          | Fecha en la que el cliente compra el producto. |

Tabla ORGANIZAR

| Columna        | Tipo de Datos | Descripción                            |
|----------------|---------------|----------------------------------------|
| `cod_Empleado` | INT           | Clave primaria del empleado, clave ajena que apunta a `EMPLEADO`. |
| `cod_Producto` | INT           | Clave primaria del producto, clave ajena que apunta a `PRODUCTO`. |

Tabla COLABORADOR

| Columna        | Tipo de Datos | Descripción                            |
|----------------|---------------|----------------------------------------|
| `n_usuario`    | VARCHAR(64)   | Clave primaria del colaborador.        |
| `nombre`       | VARCHAR(64)   | Nombre del colaborador.                |

Tabla PROMOCIONAR

| Columna        | Tipo de Datos | Descripción                            |
|----------------|---------------|----------------------------------------|
| `cod_Producto` | INT           | Clave primaria del producto, clave ajena que apunta a `PRODUCTO`. |
| `usuarioColaborador` | VARCHAR(64)   | Clave primaria del colaborador, clave ajena que apunta a `COLABORADOR`. |

Tabla PROVEEDOR

| Columna        | Tipo de Datos | Descripción                            |
|----------------|---------------|----------------------------------------|
| `nif`          | VARCHAR(32)   | Clave primaria del proveedor.          |
| `nombre`       | VARCHAR(64)   | Nombre del proveedor.                  |
| `direccion`    | VARCHAR(64)   | Dirección del proveedor.               |

Tabla PROVEER

| Columna        | Tipo de Datos | Descripción                            |
|----------------|---------------|----------------------------------------|
| `cod_Producto` | INT           | Clave primaria del producto, clave ajena que apunta a `PRODUCTO`. |
| `nif_Proovedor`| VARCHAR(32)   | Clave primaria del proveedor, clave ajena que apunta a `PROVEEDOR`. |


### Claves Primarias

Clave primaria en `EMPLEADO`: `cod_empleado`

Clave primaria en `CLIENTE`: `cod_cliente`

Clave primaria en `PARTIDA`: `cod_partida`

Clave primaria en `SALA`: `n_sala`

Clave primaria en `PRODUCTO`: `cod_Producto`

Clave primaria en `CONSOLA`: `cod_Producto`

Clave primaria en `VIDEOJUEGO`: `cod_Producto`

Clave primaria en `MERCHANDISING`: `cod_Producto`

Clave primaria en `COLABORADOR`: `n_usuario`

Clave primaria en `PROVEEDOR`: `nif`

Clave primaria en `ATENDER`: (`cod_empleado`, `cod_cliente`)

Clave primaria en `JUGAR`: (`cod_partida`, `cod_cliente`)

Clave primaria en `SUSTITUIR`: (`cod_Producto1`, `cod_Producto2`)

Clave primaria en `COMPRAR`: (`cod_cliente`, `cod_Producto`)

Clave primaria en `ORGANIZAR`: (`cod_Empleado`, `cod_Producto`)

Clave primaria en `PROMOCIONAR`: (`cod_Producto`, `n_usuario`)

Clave primaria en `PROVEER`: (`cod_Producto`, `nif_proveedor`)


### Claves Ajenas

Clave ajena en `ATENDER`: `cod_empleado` referencia a `cod_empleado` en la tabla `EMPLEADO`, indicando la relación entre un empleado y los clientes que atiende.  
Restricción de borrado: rechazar.  
Restricción de modificación: propagar.

Clave ajena en `ATENDER`: `cod_cliente` referencia a `cod_cliente` en la tabla `CLIENTE`, indicando la relación entre un cliente y los empleados que lo atienden.  
Restricción de borrado: rechazar.  
Restricción de modificación: propagar.

Clave ajena en `PARTIDA`: `n_sala` referencia a `n_sala` en la tabla `SALA`, indicando la relación entre una partida y la sala en la que se juega.  
Restricción de borrado: rechazar.  
Restricción de modificación: propagar.

Clave ajena en `JUGAR`: `cod_partida` referencia a `cod_partida` en la tabla `PARTIDA`, indicando la relación entre un cliente y la partida en la que juega.  
Restricción de borrado: rechazar.  
Restricción de modificación: propagar.

Clave ajena en `JUGAR`: `cod_cliente` referencia a `cod_cliente` en la tabla `CLIENTE`, indicando la relación entre un cliente y las partidas en las que participa.  
Restricción de borrado: rechazar.  
Restricción de modificación: propagar.

Clave ajena en `SUSTITUIR`: `cod_Producto1` y `cod_Producto2` referencian a `cod_Producto` en la tabla `CONSOLA`, indicando la relación entre dos consolas que se pueden sustituir.  
Restricción de borrado: rechazar.  
Restricción de modificación: propagar.

Clave ajena en `COMPRAR`: `cod_cliente` referencia a `cod_cliente` en la tabla `CLIENTE`, indicando la relación entre un cliente y los productos que compra.  
Restricción de borrado: rechazar.  
Restricción de modificación: propagar.

Clave ajena en `COMPRAR`: `cod_Producto` referencia a `cod_Producto` en la tabla `PRODUCTO`, indicando la relación entre un producto y los clientes que lo compran.  
Restricción de borrado: rechazar.  
Restricción de modificación: propagar.

Clave ajena en `ORGANIZAR`: `cod_Empleado` referencia a `cod_empleado` en la tabla `EMPLEADO`, indicando la relación entre un empleado y los productos que organiza.  
Restricción de borrado: rechazar.  
Restricción de modificación: propagar.

Clave ajena en `ORGANIZAR`: `cod_Producto` referencia a `cod_Producto` en la tabla `PRODUCTO`, indicando la relación entre un producto y los empleados que lo organizan.  
Restricción de borrado: rechazar.  
Restricción de modificación: propagar.

Clave ajena en `PROMOCIONAR`: `cod_Producto` referencia a `cod_Producto` en la tabla `PRODUCTO`, indicando la relación entre un producto y los colaboradores que lo promocionan.  
Restricción de borrado: rechazar.  
Restricción de modificación: propagar.

Clave ajena en `PROMOCIONAR`: `n_usuario` referencia a `n_usuario` en la tabla `COLABORADOR`, indicando la relación entre un colaborador y los productos que promociona.  
Restricción de borrado: rechazar.  
Restricción de modificación: propagar.

Clave ajena en `PROVEER`: `cod_Producto` referencia a `cod_Producto` en la tabla `PRODUCTO`, indicando la relación entre un producto y los proveedores que lo proveen.  
Restricción de borrado: rechazar.  
Restricción de modificación: propagar.

Clave ajena en `PROVEER`: `nif` referencia a `nif` en la tabla `PROVEEDOR`, indicando la relación entre un proveedor y los productos que provee.  
Restricción de borrado: rechazar.  
Restricción de modificación: propagar.


## Imagen del modelo relacional:

![image](https://github.com/user-attachments/assets/4bf9a296-515a-46fb-9a74-6e2e6ebbc34f)

## Tablas Modelo Fisico

[Script para crear tablas](https://github.com/Proyecto1K2024Grupo3/Proyecto_IntMod/blob/main/DB_IntMod.sql)

## Registros Modelo Fisico

[Script para crear registros](https://github.com/Proyecto1K2024Grupo3/Proyecto_IntMod/blob/main/Registros_IntMod.sql)

**Hemos usado el plugin colaborativo de Visual Studio Code que nos permite trabajar a todos a la vez.**

**Emilio se ha centrado en crear las tablas DDL y ayudar a corregir errores de las tablas, ademas de ayudar con el DML, errores minimos corregidos al instante.**

**Pablo ha realizado las tablas DDL, tambien ha ayudado con el DML, pero la tabla proveer tuvo errores _graves_.**

**Sergio ha realizado las tablas DDL, ha colaborado con el DML (el que mas), algunos fallos en DDL arreglados al momento.**

## Consultas Agregadas

[Archivo SQL](https://github.com/Proyecto1K2024Grupo3/Proyecto_IntMod/blob/main/consultasAgregadas.sql)

### Consulta 1 (Sergio)

```sql
-- Seleccionar el nombre y el nif de los proovedores junto a el total de productos que provee.

select p.nombre, p.nif, count(pp.cod_producto) as "Productos Promocionados"
from PROVEEDOR p 
    join PROVEER pp on p.nif = pp.nif_Proveedor
group by pp.nif_Proveedor;
```

### Consulta 2 (Sergio)

```sql
-- Seleccionar el nombre de cada cliente junto a las partidas que han jugado, si no han jugado poner un 0

select c.nombre, count(j.cod_partida) as "Partidas Jugadas"
from CLIENTE c
    left join JUGAR j on c.cod_cliente = j.cod_cliente
group by j.cod_cliente;
```

### Consulta 3 (Emilio)

```sql
-- Mostrar por cada empleado a cuantos clientes ha atendido

select e.cod_empleado, e.nombre as Empleado, count(a.cod_cliente) as ClientesAtendidos
from EMPLEADO e
    left join ATENDER a on e.cod_empleado = a.cod_empleado
group by e.cod_empleado, e.nombre;

```

### Consulta 4 (Emilio)

```sql
-- Mostrar el precio total de los productos promocionados por cada proovedor junto al nombre de este

select pr.nombre as Proveedor, sum(p.precio) as PrecioTotal
from PROVEEDOR p
    join PROVEER pv on pr.nif = pv.nif_Proveedor
    join PRODUCTO p on pv.cod_producto = p.cod_producto
    join PROMOCIONAR pro on p.cod_producto = pro.cod_producto
group by pr.nombre;

```

### Consulta 5 (Emilio)

```sql
-- Mostrar cuantas partidas se han jugado en cada sala

select s.n_sala as Sala, count(p.cod_partida) as PartidasJugadas
from SALA s
    left join PARTIDA p on s.n_sala = p.n_sala
group by s.n_sala;

```

### Consulta 6 (Pablo)

```sql
-- Mostrar los clientes que  hayan comprado productos con promociones.

SELECT c.nombre AS cliente, COUNT(co.cod_producto) AS total_compras, co.promocion
FROM CLIENTE c
JOIN COMPRAR co ON c.cod_cliente = co.cod_cliente
WHERE co.promocion IS NOT NULL
GROUP BY c.nombre, co.promocion
ORDER BY COUNT(co.cod_producto) DESC;

```

### Consulta 7 (Pablo)

```sql
-- Mostrar los proveedores que suministren las consolas más caras.

SELECT pr.nombre AS proveedor, MAX(p.precio) AS precio_mas_alto
FROM PROVEEDOR pr
JOIN PROVEER pv ON pr.nif = pv.nif_proveedor
JOIN CONSOLA c ON pv.cod_producto = c.cod_producto
JOIN PRODUCTO p ON c.cod_producto = p.cod_producto
GROUP BY pr.nombre
ORDER BY MAX(p.precio) DESC;

```

### Vista 1 (Sergio)

```sql
-- Vista llamada productosPocoStock que muestre los productos con 20 o menos unidades

create view productosPocoStock as
select * from PRODUCTO
where unidades <= 20;
```

### Vista 2 (Sergio)

```sql
-- Vista llamada comprasConPromocion en la que se muestren las compras que se han realizado con promociones

create view comprasConPromocion as
select * from COMPRAR
where promocion is null;

```

### Ventana 1 (Sergio)

```sql
-- Mostrar el nombre del cliente, sus compras totales y el ranking de clientes por cantidad de compras.

SELECT c.nombre AS nombre_cliente,
    COUNT(co.cod_producto) AS total_compras,
    RANK() OVER (ORDER BY COUNT(co.cod_producto) DESC) AS ranking
FROM CLIENTE c
    JOIN COMPRAR co ON c.cod_cliente = co.cod_cliente
GROUP BY c.cod_cliente;

```
------

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














