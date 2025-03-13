# Modelo Relacional

- [Indice Principal](/README.md)

## Imagen

![Imagen](/Diagramas/ModeloRelacional.png)

---

## Notacion

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
