-- Seleccionar el nombre y el nif de los proovedores junto a el total de productos que provee.

select p.nombre, p.nif, count(pp.cod_producto) as "Productos Promocionados"
from PROVEEDOR p 
    join PROVEER pp on p.nif = pp.nif_Proveedor
group by pp.nif_Proveedor;

-- Seleccionar el nombre de cada cliente junto a las partidas que han jugado, si no han jugado poner un 0

select c.nombre, count(j.cod_partida) as "Partidas Jugadas"
from CLIENTE c
    left join JUGAR j on c.cod_cliente = j.cod_cliente
group by j.cod_cliente;

-- Mostrar por cada empleado a cuantos clientes ha atendido

-- Mostrar el precio total de los productos promocionados por cada proovedor junto al nombre de este

-- Mostrar cuantas partidas se hanjugado en cada sala




