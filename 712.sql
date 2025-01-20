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

select e.cod_empleado, e.nombre as Empleado, count(a.cod_cliente) as ClientesAtendidos
from EMPLEADO e
    left join ATENDER a on e.cod_empleado = a.cod_empleado
group by e.cod_empleado, e.nombre;

-- Mostrar el precio total de los productos promocionados por cada proovedor junto al nombre de este

select pr.nombre as Proveedor, sum(p.precio) as PrecioTotal
from PROVEEDOR p
    join PROVEER pv on pr.nif = pv.nif_Proveedor
    join PRODUCTO p on pv.cod_producto = p.cod_producto
    join PROMOCIONAR pro on p.cod_producto = pro.cod_producto
group by pr.nombre;

-- Mostrar cuantas partidas se han jugado en cada sala

select s.n_sala as Sala, count(p.cod_partida) as PartidasJugadas
from SALA s
    left join PARTIDA p on s.n_sala = p.n_sala
group by s.n_sala;





