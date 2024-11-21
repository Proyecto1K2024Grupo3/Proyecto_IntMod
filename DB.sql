CREATE DATABASE VIDEOJUEGOS;

CREATE TABLE EMPLEADO(
    cod_empleado INT AUTO_INCREMENT,
    dni VARCHAR(32) UNIQUE KEY,
    telefono INT,
    f_Nacimiento DATE,
    nombre VARCHAR(64),
    PRIMARY KEY (cod_empleado));
    
CREATE TABLE CLIENTE(
    cod_cliente INT AUTO_INCREMENT,
    nombre VARCHAR(64),
    telefono INT,
    PRIMARY KEY (cod_cliente));    

CREATE TABLE PARTIDA(
    cod_partida INT AUTO_INCREMENT,
    inicio TIME,
    fin TIME,
    n_sala INT,
    PRIMARY KEY (cod_empleado),
    CONSTRAINT FK_SALA FOREING KEY (n_sala) REFERENCES SALA); -- Probablemente esta mal



CREATE TABLE SALA(
    n_sala INT,
    tamanyo INT,
    PRIMARY KEY (n_sala));

CREATE TABLE PRODUCTO(
    cod_producto INT,
    precio INT,
    unidades INT,
    nombre VARCHAR(64),
    PRIMARY KEY (cod_producto));


CREATE TABLE PROVEEDOR(
    nif VARCHAR(32),
    nombre VARCHAR(64),
    direccion VARCHAR(64),
    PRIMARY KEY (nif)
););

