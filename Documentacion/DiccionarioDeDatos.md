# Diccionario de Datos

- [Indice Principal](/README.md)

## Tablas

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


## Claves Primarias

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


## Claves Ajenas

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