INSERT INTO regiones (id, nombre) VALUES (1, 'Norteamérica');
INSERT INTO regiones (id, nombre) VALUES (2, 'Centroamérica');
INSERT INTO regiones (id, nombre) VALUES (3, 'Sudamérica');
INSERT INTO regiones (id, nombre) VALUES (4, 'Europa');
INSERT INTO regiones (id, nombre) VALUES (5, 'Asia');
INSERT INTO regiones (id, nombre) VALUES (6, 'Africa');
INSERT INTO regiones (id, nombre) VALUES (7, 'Oceanía');
INSERT INTO regiones (id, nombre) VALUES (8, 'Antártida');

INSERT INTO `clientes` (id, region_id, nombre, apellido, correo, fecha) VALUES (1, 1, 'Dennis', 'Ritchie','dritchie@gmail.com', '2023-03-01');
INSERT INTO `clientes` (id, region_id, nombre, apellido, correo, fecha) VALUES (2, 1, 'Bjarne', 'Stroustrup', 'bstroustrup@gmail.com', '2023-03-01');
INSERT INTO `clientes` (id, region_id, nombre, apellido, correo, fecha) VALUES (3, 1, 'James', 'Gosling', 'jgosling@gmail.com', '2023-03-01');
INSERT INTO `clientes` (id, region_id, nombre, apellido, correo, fecha) VALUES (4, 1, 'Anders', 'Hejlsberg', 'ahejlsberg@gmail.com', '2023-03-01');
INSERT INTO `clientes` (id, region_id, nombre, apellido, correo, fecha) VALUES (5, 4, 'Guido', 'Van Rossum', 'gvrossum@gmail.com', '2023-03-01');
INSERT INTO `clientes` (id, region_id, nombre, apellido, correo, fecha) VALUES (6, 4, 'Rasmus', 'Lerdof', 'rlerdorf@gmail.com', '2023-03-01');
INSERT INTO `clientes` (id, region_id, nombre, apellido, correo, fecha) VALUES (7, 1, 'Brendan', 'Eich', 'beich@gmail.com', '2023-03-01');
INSERT INTO `clientes` (id, region_id, nombre, apellido, correo, fecha) VALUES (8, 5, 'Yukihiro', 'Matsumoto', 'ymatsumoto@gmail.com', '2023-03-01');
INSERT INTO `clientes` (id, region_id, nombre, apellido, correo, fecha) VALUES (9, 4, 'Linus', 'Torvals', 'ltorvals@gmail.com', '2023-03-01');
INSERT INTO `clientes` (id, region_id, nombre, apellido, correo, fecha) VALUES (10, 1, 'Frederik', 'Kottler', 'fdxdesarrollos@gmail.com', '2023-03-01');
INSERT INTO `clientes` (id, region_id, nombre, apellido, correo, fecha) VALUES (11, 7, 'John', 'Doe', 'john.doe@gmail.com', '2023-03-05');
INSERT INTO `clientes` (id, region_id, nombre, apellido, correo, fecha) VALUES (12, 3, 'Andrés José', 'Guzmán', 'ajguzman@gmail.com', '2023-03-05');

INSERT INTO usuarios (id, username, password, enabled, nombre, apellido, email) VALUES (1,'andres','$2a$10$.kQg8enDOl4wPKnm8lr6U.u.UZHdJ01Czx.CFM6yn9S6sBAtkL7P6',1, 'XXXXXXXX', 'WWWWWWWW', 'xxx.www@gmail.com');
INSERT INTO usuarios (id, username, password, enabled, nombre, apellido, email) VALUES (2,'admin','$2a$10$shru64A1oDPr38bZ04snbOBB7AjXlh6gOxhxXxwVkl99N.Ycj6jga',1, 'AAAAAAAAAA', 'BBBBBBBBBB', 'aaa.bbb@gmail.com');
INSERT INTO usuarios (id, username, password, enabled, nombre, apellido, email) VALUES (3,'gabriel','$2a$10$2zPCj95xiguFGrMT/cKaROCAcGcViXuxZDbDGtR19KGZWFHK0E1sW',1, 'GGGGGGGG', 'HHHHHHHH', 'ggg.hhh@gmail.com');

INSERT INTO perfiles (id, nombre) VALUES (1, 'ROLE_USER');
INSERT INTO perfiles (id, nombre) VALUES (2, 'ROLE_ADMIN');

INSERT INTO usuarios_perfiles (usuario_id, perfil_id) VALUES (1,1);
INSERT INTO usuarios_perfiles (usuario_id, perfil_id) VALUES (2,2);
INSERT INTO usuarios_perfiles (usuario_id, perfil_id) VALUES (2,1);
INSERT INTO usuarios_perfiles (usuario_id, perfil_id) VALUES (3,1);