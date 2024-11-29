-- Registros EMPLEADO
INSERT INTO EMPLEADO (dni, telefono, f_Nacimiento, nombre) VALUES
('12345678A', '600123456', '1990-01-01', 'Juan Pérez'),
('23456789B', '600234567', '1985-05-15', 'Ana López'),
('34567890C', '600345678', '1992-09-10', 'Carlos García'),
('45678901D', '600456789', '1980-03-25', 'María Fernández'),
('56789012E', '600567890', '1995-07-12', 'Pedro Sánchez'),
('67890123F', '600678901', '1988-11-05', 'Laura Martínez'),
('78901234G', '600789012', '1982-02-20', 'Luis Gómez'),
('89012345H', '600890123', '1993-06-18', 'Marta Ruiz'),
('90123456I', '600901234', '1991-12-08', 'Javier Torres'),
('01234567J', '600012345', '1987-08-30', 'Clara Moreno');

-- Registros CLIENTE
INSERT INTO CLIENTE (cod_cliente, nombre, telefono) VALUES
(1, 'Carlos López', '600123456'),
(2, 'María García', '610987654'),
(3, 'Juan Pérez', '620345678'),
(4, 'Ana Martínez', '630876543'),
(5, 'Luis Fernández', '640456789'),
(6, 'Laura Sánchez', '650789123'),
(7, 'Pedro Gómez', '660234567'),
(8, 'Elena Torres', '670987321'),
(9, 'Jorge Ruiz', '680654321'),
(10, 'Lucía Morales', '690123789');

-- Registros ATENDER
INSERT INTO ATENDER (cod_empleado, cod_cliente) VALUES
(1, 1), (1, 2), (2, 3), (2, 4), (3, 5),
(4, 6), (4, 7), (5, 8), (6, 9), (6, 10);

-- Registros SALA
INSERT INTO SALA (n_sala, tamanyo) VALUES
(1, 20), (2, 15), (3, 25), (4, 30), (5, 18),
(6, 22), (7, 28), (8, 35), (9, 12), (10, 40);

-- Registros PARTIDA
INSERT INTO PARTIDA (inicio, fin, n_sala) VALUES
('10:00:00', '11:00:00', 1), ('11:30:00', '12:30:00', 2), 
('13:00:00', '14:00:00', 3), ('14:30:00', '15:30:00', 4), 
('16:00:00', '17:00:00', 5), ('17:30:00', '18:30:00', 6), 
('19:00:00', '20:00:00', 7), ('20:30:00', '21:30:00', 8), 
('22:00:00', '23:00:00', 9), ('23:30:00', '00:30:00', 10);

-- Registros JUGAR
INSERT INTO JUGAR (cod_partida, cod_cliente, ganador) VALUES
(1, 1, 'Juan'), (1, 2, 'Ana'), (2, 3, 'Carlos'), 
(2, 4, 'María'), (3, 5, 'Pedro'), (4, 6, 'Laura'), 
(5, 7, 'Luis'), (6, 8, 'Marta'), (7, 9, 'Javier'), (8, 10, 'Clara');

-- Registros PRODUCTO
INSERT INTO PRODUCTO (cod_producto, precio, unidades, nombre) VALUES
(1, 299, 10, 'PlayStation 5'),
(2, 199, 15, 'Nintendo Switch Lite'),
(3, 49, 50, 'The Legend of Zelda: Tears of the Kingdom'),
(4, 39, 20, 'Minecraft'),
(5, 59, 30, 'Elden Ring'),
(6, 499, 5, 'Xbox Series X'),
(7, 59, 25, 'Call of Duty: Modern Warfare II'),
(8, 29, 40, 'Among Us Plush'),
(9, 19, 60, 'Fortnite V-Bucks Pack'),
(10, 79, 35, 'Razer Kraken Headset');

-- Registros CONSOLA
INSERT INTO CONSOLA (cod_producto) VALUES
(1), (2), (3), (4), (5), (6), (7), (8), (9), (10);

-- Registros SUSTITUIR
INSERT INTO SUSTITUIR (cod_producto1, cod_producto2) VALUES
(1, 6), -- PlayStation 5 sustituida por Xbox Series X
(2, 4), -- Nintendo Switch Lite sustituida por Minecraft
(3, 5), -- The Legend of Zelda sustituida por Elden Ring
(8, 9), -- Among Us Plush sustituida por Fortnite V-Bucks Pack
(10, 7), -- Razer Kraken Headset sustituida por Call of Duty
(6, 1), -- Xbox Series X sustituida por PlayStation 5
(4, 2), -- Minecraft sustituida por Nintendo Switch Lite
(5, 3), -- Elden Ring sustituida por The Legend of Zelda
(9, 8), -- Fortnite V-Bucks Pack sustituida por Among Us Plush
(7, 10); -- Call of Duty sustituida por Razer Kraken Headset

-- Registros VIDEOJUEGO
INSERT INTO VIDEOJUEGO (cod_producto, tipo, tamaño) VALUES
(1, 'Acción', 5000), (2, 'Aventura', 4000), (3, 'Estrategia', 3000),
(4, 'RPG', 6000), (5, 'Simulación', 4500), (6, 'Shooter', 5500),
(7, 'Deportes', 3200), (8, 'Carreras', 4800), (9, 'Puzzle', 2000),
(10, 'Terror', 3600);

-- Registros MERCHANDISING
INSERT INTO MERCHANDISING (cod_producto, f_lanzamiento) VALUES
(1, '2022-01-01'), (2, '2022-02-01'), (3, '2022-03-01'),
(4, '2022-04-01'), (5, '2022-05-01'), (6, '2022-06-01'),
(7, '2022-07-01'), (8, '2022-08-01'), (9, '2022-09-01'),
(10, '2022-10-01');

-- Registros COMPRAR
INSERT INTO COMPRAR (cod_cliente, cod_producto, promocion, fecha) VALUES
(1, 1, '10% OFF', '2023-01-01'), (2, 2, '15% OFF', '2023-02-01'),
(3, 3, '20% OFF', '2023-03-01'), (4, 4, '25% OFF', '2023-04-01'),
(5, 5, '30% OFF', '2023-05-01'), (6, 6, '35% OFF', '2023-06-01'),
(7, 7, '40% OFF', '2023-07-01'), (8, 8, '45% OFF', '2023-08-01'),
(9, 9, '50% OFF', '2023-09-01'), (10, 10, '55% OFF', '2023-10-01');

-- Registros COLABORADOR
INSERT INTO COLABORADOR (n_usuario, nombre) VALUES
('carlohernandez', 'Carlos Hernández'),
('anamartinez', 'Ana Martínez'),
('pedro_torres', 'Pedro Torres'),
('luciagarcia', 'Lucía García'),
('davidgutierrez', 'David Gutiérrez'),
('sofia_lopez', 'Sofía López'),
('javierjimenez', 'Javier Jiménez'),
('martasanchez', 'Marta Sánchez'),
('andres_perez', 'Andrés Pérez'),
('laurafdez', 'Laura Fernández');

-- Registros PROMOCIONAR
INSERT INTO PROMOCIONAR (cod_producto, usuarioColaborador) VALUES
(1, 'carlohernandez'),
(2, 'anamartinez'),
(3, 'pedro_torres'),
(4, 'luciagarcia'),
(5, 'davidgutierrez'),
(6, 'sofia_lopez'),
(7, 'javierjimenez'),
(8, 'martasanchez'),
(9, 'andres_perez'),
(10, 'laurafdez');

-- Registros PROVEEDOR
INSERT INTO PROVEEDOR (nif, nombre, direccion) VALUES
('123A', 'Sony Electronics', 'Tokyo, Japón'),
('234B', 'Nintendo Co.', 'Kyoto, Japón'),
('345C', 'Microsoft Corporation', 'Redmond, EE.UU.'),
('456D', 'Bandai Namco', 'Tokio, Japón'),
('567E', 'Valve Corporation', 'Bellevue, EE.UU.'),
('678F', 'Epic Games', 'Cary, EE.UU.'),
('789G', 'Razer Inc.', 'San Francisco, EE.UU.'),
('890H', 'Ubisoft', 'Montreal, Canadá'),
('901I', 'Bethesda Softworks', 'Rockville, EE.UU.'),
('012J', 'Rockstar Games', 'Nueva York, EE.UU.');

-- Registros PROVEER
INSERT INTO PROVEER (cod_producto, nif_proveedor) VALUES
(1, '123A'), -- PlayStation 5 por Sony
(2, '234B'), -- Nintendo Switch Lite por Nintendo
(3, '234B'), -- Zelda también por Nintendo
(4, '456D'), -- Minecraft por Bandai Namco
(5, '345C'), -- Elden Ring por Microsoft
(6, '345C'), -- Xbox Series X por Microsoft
(7, '901I'), -- Call of Duty por Bethesda Softworks
(8, '789G'), -- Among Us Plush por Razer
(9, '678F'), -- Fortnite V-Bucks Pack por Epic Games
(10, '789G'); -- Razer Kraken Headset por Razer
