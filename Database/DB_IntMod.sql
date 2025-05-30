SET foreign_key_checks = 0;
DROP DATABASE IF EXISTS ProyectoIntMod;
SET foreign_key_checks = 1;

CREATE DATABASE ProyectoIntMod;
USE ProyectoIntMod;

-- [1] Tabla EMPLEADO 
CREATE TABLE empleado(
    cod_empleado INT AUTO_INCREMENT,
    dni VARCHAR(32) UNIQUE KEY,
    telefono CHAR(9),
    f_Nacimiento DATE,
    nombre VARCHAR(64),
    CONSTRAINT PK_EMPLEADO PRIMARY KEY (cod_empleado)
);

-- [2] Tabla CLIENTE
CREATE TABLE cliente(
    cod_cliente INT AUTO_INCREMENT,
    dni VARCHAR(64),
    nombre VARCHAR(64),
    CONSTRAINT PK_CLIENTE PRIMARY KEY (cod_cliente)
);

-- [3] Tabla ATENDER [N:M]
CREATE TABLE atender(
    cod_empleado INT,
    cod_cliente INT,
    CONSTRAINT PK_ATENDER PRIMARY KEY (cod_empleado, cod_cliente),
    CONSTRAINT FK_ATENDER_EMPLEADO FOREIGN KEY (cod_empleado) REFERENCES empleado(cod_empleado) ON DELETE NO ACTION ON UPDATE CASCADE,
    CONSTRAINT FK_ATENDER_CLIENTE FOREIGN KEY (cod_cliente) REFERENCES cliente(cod_cliente) ON DELETE NO ACTION ON UPDATE CASCADE
);

-- [4] Tabla SALA
CREATE TABLE sala(
    n_sala INT,
    tamanyo INT,
    CONSTRAINT PK_SALA PRIMARY KEY (n_sala)
);

-- [5] Tabla PARTIDA
CREATE TABLE partida(
    cod_partida INT AUTO_INCREMENT,
    inicio TIME,
    fin TIME,
    n_sala INT,
    CONSTRAINT PK_PARTIDA PRIMARY KEY (cod_partida),
    CONSTRAINT FK_PARTIDA_SALA FOREIGN KEY (n_sala) REFERENCES sala(n_sala) ON DELETE NO ACTION ON UPDATE CASCADE
);

-- [6] Tabla JUGAR [N:M]
CREATE TABLE jugar(
    cod_partida INT,
    cod_cliente INT,
    ganador VARCHAR(32),
    CONSTRAINT PK_JUGAR PRIMARY KEY (cod_partida, cod_cliente),
    CONSTRAINT FK_JUGAR_PARTIDA FOREIGN KEY (cod_partida) REFERENCES partida(cod_partida) ON DELETE NO ACTION ON UPDATE CASCADE,
    CONSTRAINT FK_JUGAR_CLIENTE FOREIGN KEY (cod_cliente) REFERENCES cliente(cod_cliente) ON DELETE NO ACTION ON UPDATE CASCADE
);

-- [7] Tabla PRODUCTO
CREATE TABLE producto(
    cod_producto INT AUTO_INCREMENT,
    precio DECIMAL(6,2),
    unidades INT,
    nombre VARCHAR(64),
    CONSTRAINT PK_PRODUCTO PRIMARY KEY (cod_producto)
);

-- [8] Tabla CONSOLA
CREATE TABLE consola(
    cod_producto INT,
    CONSTRAINT PK_CONSOLA PRIMARY KEY (cod_producto),
    CONSTRAINT FK_CONSOLA FOREIGN KEY (cod_producto) REFERENCES producto(cod_producto) ON UPDATE NO ACTION ON DELETE CASCADE
);

-- [9] Tabla SUSTIUR [N:M]
CREATE TABLE sustituir(
    cod_producto1 INT,
    cod_producto2 INT,
    CONSTRAINT PK_SUSTITUIR PRIMARY KEY (cod_producto1, cod_producto2),
    CONSTRAINT FK_PRODUCTO1 FOREIGN KEY (cod_producto1) REFERENCES producto(cod_producto) ON DELETE NO ACTION ON UPDATE CASCADE,
    CONSTRAINT FK_PRODUCTO2 FOREIGN KEY (cod_producto2) REFERENCES producto(cod_producto) ON DELETE NO ACTION ON UPDATE CASCADE
);

-- [10] Tabla VIDEOJUEGO
CREATE TABLE videojuego(
    cod_producto INT,
    tipo VARCHAR(32),
    tamaño INT,
    CONSTRAINT PK_VIDEOJUEGO PRIMARY KEY (cod_producto),
    CONSTRAINT FK_VIDEOJUEGO FOREIGN KEY (cod_producto) REFERENCES producto(cod_producto) ON UPDATE NO ACTION ON DELETE CASCADE
);

-- [11] Tabla MERCHANDISING
CREATE TABLE merchandising(
    cod_producto INT,
    tipo VARCHAR(64),
    tamanyo INT,
    CONSTRAINT PK_MERCHANDISING PRIMARY KEY (cod_producto),
    CONSTRAINT FK_MERCHANDISING FOREIGN KEY (cod_producto) REFERENCES producto(cod_producto) ON UPDATE NO ACTION ON DELETE CASCADE
);

-- [12] Tabla COMPRAR [N:M]
CREATE TABLE comprar(
    cod_cliente INT,
    cod_producto INT,
    promocion VARCHAR(32),
    fecha DATE,
    CONSTRAINT PK_COMPRAR PRIMARY KEY (cod_cliente, cod_producto),
    CONSTRAINT FK_COMPRAR_CLIENTE FOREIGN KEY (cod_cliente) REFERENCES cliente(cod_cliente) ON UPDATE NO ACTION ON DELETE CASCADE,
    CONSTRAINT FK_COMPRAR_PRODUCTO FOREIGN KEY (cod_producto) REFERENCES producto(cod_producto) ON UPDATE NO ACTION ON DELETE CASCADE
);

-- [13] Tabla COLABORADOR
CREATE TABLE colaborador(
    n_usuario VARCHAR(64),
    nombre VARCHAR(64),
    CONSTRAINT PK_COLABORADOR PRIMARY KEY (n_usuario)
);

-- [14] Tabla PROMOCIONAR [N:M]
CREATE TABLE promocionar (
    cod_producto INT,
    usuario_colaborador VARCHAR(64),
    CONSTRAINT PK_PROMOCIONAR PRIMARY KEY (cod_producto, usuario_colaborador),
    CONSTRAINT FK_PROMOCOINAR_PRODUCTO FOREIGN KEY (cod_producto) REFERENCES producto(cod_producto) ON UPDATE NO ACTION ON DELETE CASCADE,
    CONSTRAINT FK_PROMOCIONAR_COLABORADOR FOREIGN KEY (usuario_colaborador) REFERENCES colaborador(n_usuario) ON UPDATE NO ACTION ON DELETE CASCADE
);

-- [15] Tabla PROVEEDOR
CREATE TABLE proveedor(
    nif VARCHAR(32),
    nombre VARCHAR(64),
    direccion VARCHAR(64),
    CONSTRAINT PK_PROVEEDOR PRIMARY KEY (nif)
);

-- [16] Tabla PROVEER [N:M]
CREATE TABLE proveer(
    cod_producto INT,
    nif_Proveedor VARCHAR(32),
    CONSTRAINT PK_PROVEER PRIMARY KEY (cod_producto, nif_Proveedor),
    CONSTRAINT FK_PROVEER_PRODUCTO FOREIGN KEY (cod_Producto) REFERENCES producto(cod_producto) ON DELETE NO ACTION ON UPDATE CASCADE,
    CONSTRAINT FK_PROVEER_PROVEEDOR FOREIGN KEY (nif_Proveedor) REFERENCES proveedor(nif) ON DELETE NO ACTION ON UPDATE CASCADE
);
