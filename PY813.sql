-- 5 Subconsultas (Emilio)
--Obtener el nombre del empleado más joven.
SELECT nombre 
FROM EMPLEADO 
WHERE f_Nacimiento = (SELECT MAX(f_Nacimiento) FROM EMPLEADO);

--Obtener el nombre y teléfono del cliente que ha jugado más partidas.
SELECT nombre, telefono
FROM CLIENTE
WHERE cod_cliente = (
    SELECT cod_cliente 
    FROM JUGAR 
    GROUP BY cod_cliente 
    ORDER BY COUNT(*) DESC 
    LIMIT 1
);

--Listar los productos que tienen un precio mayor que el precio medio de todos los productos.

SELECT nombre, precio
FROM PRODUCTO
WHERE precio > (SELECT AVG(precio) FROM PRODUCTO);

--Obtener el número de partidas jugadas por cada cliente.

SELECT c.nombre, p.total_partidas
FROM CLIENTE c
JOIN (
    SELECT cod_cliente, COUNT(*) AS total_partidas
    FROM JUGAR
    GROUP BY cod_cliente
) p ON c.cod_cliente = p.cod_cliente;

--Mostrar los empleados que han atendido al menos a un cliente.

SELECT nombre
FROM EMPLEADO e
WHERE EXISTS (
    SELECT 1 
    FROM ATENDER a 
    WHERE a.cod_empleado = e.cod_empleado
);


-- 2 Consultas con CTE (Sergio)

-- Seleccionar los productos que cuesten más de 200 euros con más de 50 unidades y que hayan sido comprados por un cliente con un numero de telefono que empiece por 692

with productos50unidades100euros as (
    select cod_producto from producto
    where precio > 200 and unidades > 50;
)

select p.* from PRODUCTO p
join productos50unidades100euros pp on pp.cod_producto = p.cod_producto
join COMPRAR c on c.cod_producto = p.cod_producto
join CLIENTE cli on cli.cod_cliente = c.cod_cliente

-- Creación de Tabla Mediante Consulta Compleja (Sergio)

-- 2 Indices que optimicen las consultas definidas (Pablo)

CREATE INDEX empleadoFeNac ON `EMPLEADO`(f_Nacimiento);

CREATE INDEX precioProducto ON `PRODUCTO`(precio);

-- Planes de ejecucion antes y despues de los indices (Pablo)

-- Obtener el nombre del empleado más joven:
-- Antes de la optimización: 2ms
-- Después de la optimización: 1ms

EXPLAIN SELECT nombre 
FROM EMPLEADO 
WHERE f_Nacimiento = (SELECT MAX(f_Nacimiento) FROM EMPLEADO);

-- Listar los productos que tienen un precio mayor que el precio medio de todos los productos:
-- Antes de la optimización: 1ms
-- Después de la optimización: 1ms

EXPLAIN SELECT nombre, precio
FROM PRODUCTO
WHERE precio > (SELECT AVG(precio) FROM PRODUCTO);
