# Consultas Agregadas, Vistas y Ventanas

- [Indice Principal](/README.md)

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