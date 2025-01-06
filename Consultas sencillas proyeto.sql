-- Queremos saber el número de empleados de la tienda

select count(*) from empleado;

-- Queremos saber las direcciones de nuestros proveedores y cantidad de proveedores en esa dirección

select direccion, count(*) as proveedores from PROVEEDOR group by direccion;

-- Queremos saber nuestros 10 productos más caros al público

select nombre, precio from PRODUCTO order by precio desc limit 10;

-- Queremos saber cuantos productos ha comprado Carlos López

SELECT c.nombre AS Cliente, p.nombre AS Producto, COUNT(*) AS UnidadesCompradas 
FROM COMPRAR cp JOIN CLIENTE c ON cp.cod_cliente = c.cod_cliente 
JOIN PRODUCTO p ON cp.cod_producto = p.cod_producto 
WHERE c.nombre = 'Carlos López' GROUP BY c.nombre, p.nombre;

-- Queremos saber qué clientes han comprado la Nintendo Switch Lite y cuantas veces la han comprado

SELECT p.nombre AS producto, c.nombre as cliente, count(*) as vecesComprado
FROM COMPRAR cp JOIN CLIENTE c ON cp.cod_cliente = c.cod_cliente
JOIN PRODUCTO p ON cp.cod_producto = p.cod_producto
WHERE p.nombre = 'Nintendo Switch Lite' GROUP BY p.nombre, c.nombre;

-- Queremos saber qué productos son suministrados por qué proveedores.

SELECT pr.nombre AS Proveedor, p.nombre AS Producto 
FROM PROVEER pv JOIN PROVEEDOR pr ON pv.nif_Proveedor = pr.nif 
JOIN PRODUCTO p ON pv.cod_producto = p.cod_producto;

-- Queremos ver cuantos clientes ha atendido cada empleado.

SELECT e.nombre, COUNT(DISTINCT a.cod_cliente) AS clientesAtendidos
FROM EMPLEADO e LEFT JOIN ATENDER a ON e.cod_empleado = a.cod_empleado
LEFT JOIN CLIENTE c ON a.cod_cliente = c.cod_cliente
GROUP BY e.cod_empleado, e.nombre;

-- Muestra el nombre de los empleados que han atendido a clientes que han comprado el Elden Ring

select e.nombre 
from EMPLEADO e
    join ATENDER a on e.cod_empleado = a.cod_empleado
    join CLIENTE c on a.cod_cliente = c.cod_cliente
    join COMPRAR co on co.cod_cliente = c.cod_cliente
    join PRODUCTO p on co.cod_producto = p.cod_producto
where p.nombre = "Elden Ring";

-- Muestra el nombre de los colaboradores que hayan promocionado productos de más de 200 euros

select distinct(c.nombre)
from COLABORADOR c 
    join PROMOCIONAR pr on c.n_usuario = pr.usuarioColaborador
    join PRODUCTO p on pr.cod_producto = p.cod_producto
where p.precio > 200;

-- Muestra el numero de sala y la duracion de las partida que hayan jugado los clientes cuyos nombres empiezan por L

select s.n_sala, case when fin < inicio then TIMEDIFF(ADDTIME(fin, '24:00:00'), inicio) else TIMEDIFF(fin, inicio) end as duracion
from SALA s 
    join PARTIDA p on p.n_sala = s.n_sala
    join JUGAR j on p.cod_partida = j.cod_partida
    join CLIENTE c on j.cod_cliente = c.cod_cliente
where c.nombre like "L%";
