
-- Registros EMPLEADO
INSERT INTO EMPLEADO (dni, telefono, f_Nacimiento, nombre) VALUES
('12345678A', '600123456', '1990-01-01', 'Juan Pérez'),
('23456789B', '600234567', '1985-05-15', 'Ana López'),
('34567890C', '600345678', '1992-09-10', 'Carlos García'),
('45678901D', '600456789', '1980-03-25', 'María Fernández'),
('56789012E', '600567890', '1995-07-12', 'Pedro Sánchez'),
('67890123F', '600678901', '1988-11-05', 'Mariano Rajoy'),
('78901234G', '600789012', '1982-02-20', 'El Pepe'),
('89012345H', '600890123', '1993-06-18', 'Marta Ruiz'),
('90123456I', '600901234', '1991-12-08', 'Patrick Bateman'),
('01234567J', '600012345', '1987-08-30', 'Clara Moreno'),
('11223344K', '601123456', '1994-04-10', 'Santiago Giménez'),
('22334455L', '601234567', '1986-07-22', 'Lucía Torres'),
('33445566M', '601345678', '1990-12-05', 'Fernando Alonso'),
('44556677N', '601456789', '1997-02-14', 'Isabel Jiménez'),
('55667788O', '601567890', '1983-09-30', 'Rodrigo Díaz'),
('66778899P', '601678901', '1989-06-07', 'Sofía Martínez'),
('77889900Q', '601789012', '1992-11-21', 'Álvaro Bautista'),
('88990011R', '601890123', '1981-01-03', 'Verónica Castro'),
('99001122S', '601901234', '1996-05-28', 'Javier Hernández'),
('00112233T', '601012345', '1985-10-15', 'Beatriz Gutiérrez'),
('11223344U', '602123456', '1993-07-19', 'Ricardo Montoya'),
('22334455V', '602234567', '1980-12-22', 'Natalia Pérez'),
('33445566W', '602345678', '1998-03-11', 'Esteban Trueba'),
('44556677X', '602456789', '1987-09-05', 'Paula Fernández'),
('55667788Y', '602567890', '1991-06-25', 'Gonzalo Herrera'),
('66778899Z', '602678901', '1984-04-17', 'Daniela Ríos'),
('77889900A', '602789012', '1999-08-30', 'Joaquín Sabina'),
('88990011B', '602890123', '1982-02-13', 'Andrea Mena'),
('99001122C', '602901234', '1995-11-09', 'Fabián Suárez'),
('00112233D', '602012345', '1986-05-31', 'Monserrat Ortega'),
('11223344E', '603123456', '1994-10-02', 'Gabriel Márquez'),
('22334455F', '603234567', '1983-07-26', 'Nicolás Medina'),
('33445566G', '603345678', '1997-01-14', 'Silvia Domínguez'),
('44556677H', '603456789', '1989-09-27', 'Hugo Chávez'),
('55667788I', '603567890', '1981-06-06', 'Julia Serrano'),
('66778899J', '603678901', '1990-12-18', 'Oscar Wilde'),
('77889900K', '603789012', '1992-03-29', 'Emma Watson'),
('88990011L', '603890123', '1984-08-07', 'Cristina Aguilera'),
('99001122M', '603901234', '1996-04-23', 'Vicente Fernández'),
('00112233N', '603012345', '1987-11-12', 'Carolina Herrera');

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

-- Registros PRODUCTO (Contiene los registros de sus 3 hijos)
INSERT INTO PRODUCTO (precio, unidades, nombre) VALUES
-- Consolas (10 registros)
(500.00, 20, 'PlayStation 5'),
(300.00, 15, 'Xbox Series S'),
(550.00, 10, 'Xbox Series X'),
(400.00, 25, 'Nintendo Switch OLED'),
(350.00, 30, 'Nintendo Switch Lite'),
(450.00, 20, 'Steam Deck'),
(200.00, 50, 'PlayStation 4 Slim'),
(250.00, 40, 'Xbox One X'),
(100.00, 60, 'Nintendo 2DS XL'),
(150.00, 35, 'PlayStation 3 Super Slim'),

-- Videojuegos (10 registros)
(70.00, 100, 'The Legend of Zelda: Tears of the Kingdom'),
(60.00, 200, 'Elden Ring'),
(50.00, 150, 'FIFA 24'),
(60.00, 120, 'Call of Duty: Modern Warfare III'),
(40.00, 300, 'Minecraft'),
(50.00, 250, 'Hogwarts Legacy'),
(30.00, 500, 'Among Us'),
(20.00, 600, 'Stardew Valley'),
(60.00, 100, 'Final Fantasy XVI'),
(50.00, 150, 'Super Mario Odyssey'),

-- Merchandising (10 registros)
(25.00, 100, 'Figura Funko Pop Mario'),
(20.00, 150, 'Camiseta Zelda'),
(30.00, 120, 'Taza PlayStation'),
(15.00, 200, 'Poster Elden Ring'),
(50.00, 80, 'Estatua de Link'),
(10.00, 300, 'Llaveros de videojuegos'),
(35.00, 90, 'Mochila Call of Duty'),
(20.00, 250, 'Gorra Minecraft'),
(60.00, 50, 'Edición coleccionista Amiibo'),
(40.00, 110, 'Póster Final Fantasy'),

(600.00, 25, 'PlayStation 5 Edición Digital'),
(320.00, 20, 'Xbox Series S Carbon Black'),
(500.00, 15, 'Nintendo Switch Mario Edition'),
(550.00, 18, 'Asus ROG Ally'),
(400.00, 30, 'Steam Deck OLED'),
(300.00, 50, 'Nintendo Switch Classic'),
(250.00, 40, 'PlayStation 4 Pro'),
(200.00, 55, 'Xbox One S'),
(180.00, 70, 'PS Vita'),
(120.00, 80, 'Nintendo 3DS'),

(70.00, 90, 'Cyberpunk 2077'),
(50.00, 150, 'Resident Evil 4 Remake'),
(55.00, 200, 'God of War: Ragnarok'),
(60.00, 120, 'Red Dead Redemption 2'),
(45.00, 250, 'Hollow Knight'),
(35.00, 300, 'Celeste'),
(40.00, 400, 'The Witcher 3: Wild Hunt'),
(20.00, 500, 'Cuphead'),
(65.00, 150, 'Persona 5 Royal'),
(50.00, 200, 'Splatoon 3'),

(25.00, 100, 'Figura Funko Pop Zelda'),
(30.00, 150, 'Sudadera The Witcher'),
(20.00, 120, 'Taza God of War'),
(50.00, 80, 'Réplica Espada de Link'),
(10.00, 300, 'Llavero PlayStation'),
(35.00, 90, 'Bolsa de tela de Elden Ring'),
(20.00, 250, 'Gorra Cyberpunk 2077'),
(60.00, 50, 'Figura coleccionista Resident Evil'),
(40.00, 110, 'Póster Red Dead Redemption 2'),
(55.00, 75, 'Lámpara Pac-Man');


-- Registros CONSOLA
INSERT INTO CONSOLA (cod_producto) VALUES
(1), (2), (3), (4), (5), (6), (7), (8), (9), (10),
(31), (32), (33), (34), (35), (36), (37), (38), (39), (40);

-- Registros SUSTITUIR
INSERT INTO SUSTITUIR (cod_producto1, cod_producto2) VALUES
(1, 10), (7, 4), (1, 5), (4, 6), (9, 3), (8, 4),
(7, 3), (7, 2), (1, 7), (4, 5), (31, 10), (32, 4), 
(33, 5), (34, 6), (35, 3), (36, 4),(37, 3), (38, 2), (39, 7), (40, 5);

-- Registros VIDEOJUEGO
INSERT INTO VIDEOJUEGO (cod_producto, tipo, tamaño) VALUES
(11, 'Acción', 5000), (12, 'Aventura', 4000), (13, 'Estrategia', 3000),
(14, 'RPG', 6000), (15, 'Simulación', 4500), (16, 'Shooter', 5500),
(17, 'Deportes', 3200), (18, 'Carreras', 4800), (19, 'Puzzle', 2000),
(20, 'Terror', 3600), (41, 'Acción', 7000), (42, 'Terror', 6500), (43, 'RPG', 8000),
(44, 'Western', 7500), (45, 'Plataformas', 5000), (46, 'Indie', 3000),
(47, 'RPG', 8500), (48, 'Shoot em up', 4500), (49, 'JRPG', 7800),
(50, 'Multijugador', 6200);

-- Registros MERCHANDISING
INSERT INTO MERCHANDISING (cod_producto, f_lanzamiento) VALUES
(21, '2022-01-01'), (22, '2022-02-01'), (23, '2022-03-01'),
(24, '2022-04-01'), (25, '2022-05-01'), (26, '2022-06-01'),
(27, '2022-07-01'), (28, '2022-08-01'), (29, '2022-09-01'),
(30, '2022-10-01'), (51, '2023-01-10'), (52, '2023-02-15'), (53, '2023-03-20'),
(54, '2023-04-25'), (55, '2023-05-30'), (56, '2023-06-05'),
(57, '2023-07-12'), (58, '2023-08-19'), (59, '2023-09-23'),
(60, '2023-10-31');

-- Registros COMPRAR
INSERT INTO COMPRAR (cod_cliente, cod_producto, promocion, fecha) VALUES
(1, 12, null, '2023-01-01'), (2, 2, null, '2023-02-01'),
(3, 20, '20% OFF', '2023-03-01'), (4, 11, '25% OFF', '2023-04-01'),
(5, 5, '30% OFF', '2023-05-01'), (6, 6, '35% OFF', '2023-06-01'),
(7, 23, null, '2023-07-01'), (8, 8, null, '2023-08-01'),
(9, 9, '50% OFF', '2023-09-01'), (10, 18, '55% OFF', '2023-10-01'), (11, 41, null, '2023-11-01'), (12, 42, '10% OFF', '2023-12-01'),
(13, 43, '15% OFF', '2024-01-05'), (14, 44, null, '2024-02-10'),
(15, 45, '5% OFF', '2024-03-15'), (16, 46, '20% OFF', '2024-04-20'),
(17, 47, '25% OFF', '2024-05-25'), (18, 48, null, '2024-06-30'),
(19, 49, '30% OFF', '2024-07-05'), (20, 50, '40% OFF', '2024-08-10'),
(21, 51, null, '2024-09-15'), (22, 52, '10% OFF', '2024-10-20'),
(23, 53, '15% OFF', '2024-11-25'), (24, 54, '5% OFF', '2024-12-01'),
(25, 55, '35% OFF', '2025-01-05'), (26, 56, '20% OFF', '2025-02-10'),
(27, 57, '45% OFF', '2025-03-15'), (28, 58, null, '2025-04-20'),
(29, 59, '50% OFF', '2025-05-25'), (30, 60, '55% OFF', '2025-06-30');

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
(3, 'luciagarcia'),
(3, 'davidgutierrez'),
(6, 'sofia_lopez'),
(7, 'sofia_lopez'),
(8, 'martasanchez'),
(7, 'andres_perez'),
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
(1, '123A'),
(2, '234B'),
(3, '234B'),
(12, '456D'),
(5, '345C'),
(22, '345C'),
(7, '901I'),
(18, '789G'),
(9, '678F'),
(10, '789G'),
(1, '789G');
