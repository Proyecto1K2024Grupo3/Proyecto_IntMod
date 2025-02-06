-- 5 Subconsultas (Emilio Putero)



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

-- Planes de ejecucion antes y despues de los indices (Pablo)

