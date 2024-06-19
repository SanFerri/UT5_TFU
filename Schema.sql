create database olimpiadas_db;

use olimpiadas_db;

create table Persona (
    ci VARCHAR(10) PRIMARY KEY NOT NULL,
    nombre VARCHAR(20) NOT NULL,
    apellido VARCHAR(20) NOT NULL,
    contacto VARCHAR(20) NOT NULL,
    email VARCHAR(50) UNIQUE NOT NULL
);

create table Disciplina (
    id int auto_increment PRIMARY KEY NOT NULL,
    nombre VARCHAR(20) NOT NULL
);

create table TipoPuntaje (
    id int AUTO_INCREMENT PRIMARY KEY NOT NULL,
    mide_tiempo BOOLEAN NOT NULL,
    mide_distancia BOOLEAN NOT NULL,
    mide_altura BOOLEAN NOT NULL ,
    mide_estilo BOOLEAN NOT NULL,
    mide_tecnica BOOLEAN NOT NULL,
    cuenta_faltas BOOLEAN NOT NULL,
    cantidad_rounds SMALLINT NOT NULL
);

create table Modalidad (
    id int auto_increment PRIMARY KEY NOT NULL,
    nombre VARCHAR(40) NOT NULL,
    disciplina_id int NOT NULL,
    puntaje_id int NOT NULL,
    FOREIGN KEY (disciplina_id) REFERENCES Disciplina(id),
    FOREIGN KEY (puntaje_id) REFERENCES TipoPuntaje(id)
);

create table Categoria (
    id int auto_increment PRIMARY KEY NOT NULL,
    id_modalidad int NOT NULL,
    sexo ENUM('masculino', 'femenino', 'ambos') NOT NULL DEFAULT 'femenino',
    tamano_grupo SMALLINT DEFAULT 1,
    edad_inicio SMALLINT DEFAULT NULL,
    edad_fin SMALLINT DEFAULT NULL,
    peso_inicio SMALLINT DEFAULT NULL,
    peso_fin SMALLINT DEFAULT NULL,
    FOREIGN KEY (id_modalidad) REFERENCES Modalidad(id)
);

create table Juez (
    id int auto_increment PRIMARY KEY NOT NULL,
    ci VARCHAR(10) NOT NULL,
    FOREIGN KEY (ci) REFERENCES Persona(ci)
);

create table Participante (
    id int auto_increment PRIMARY KEY NOT NULL,
    ci VARCHAR(10) NOT NULL,
    edad int NOT NULL,
    peso int NOT NULL,
    modalidad_id int NOT NULL,
    FOREIGN KEY (ci) REFERENCES Persona(ci),
    FOREIGN KEY (modalidad_id) REFERENCES Modalidad(id)
);

create table Participacion(
    participante_id int NOT NULL,
    categoria_id int NOT NULL,
    FOREIGN KEY (participante_id) REFERENCES Participante(id),
    FOREIGN KEY (categoria_id) REFERENCES Categoria(id),
    PRIMARY KEY (participante_id, categoria_id)
);

create table Puntua(
    juez_id int NOT NULL,
    modalidad_id int NOT NULL,
    FOREIGN KEY (juez_id) REFERENCES Juez(id),
    FOREIGN KEY (modalidad_id) REFERENCES Modalidad(id),
    PRIMARY KEY (juez_id, modalidad_id)
);

create table Puntaje (
    id int auto_increment PRIMARY KEY NOT NULL,
    juez_id int NOT NULL,
    participante_id int NOT NULL,
    categoria_id int NOT NULL,
    valor_tiempo TIME NOT NULL,
    valor_distancia FLOAT DEFAULT NULL,
    valor_estilo FLOAT DEFAULT NULL,
    valor_tecnica FLOAT DEFAULT NULL,
    faltas SMALLINT DEFAULT NULL,
    round SMALLINT DEFAULT NULL,
    FOREIGN KEY (participante_id, categoria_id) REFERENCES Participacion(participante_id, categoria_id),
    FOREIGN KEY (juez_id) REFERENCES Juez(id)
);


create table Competencia(
    id int auto_increment PRIMARY KEY NOT NULL,
    nombre VARCHAR(20) NOT NULL,
    id_modalidad int NOT NULL,
    id_categoria int NOT NULL,
    fecha DATE NOT NULL,
    hora TIME NOT NULL,
    lugar VARCHAR(20) NOT NULL
);

INSERT INTO
    Disciplina (nombre)
VALUES
    ('Atletismo'),
    ('Natación'),
    ('Gimnasia Artistica'),
    ('Clavados'),
    ('Halterofilia'),
    ('Esgrima'),
    ('Surf'),
    ('Kitesurf');

INSERT INTO TipoPuntaje (mide_tiempo,mide_distancia,mide_altura,mide_estilo,mide_tecnica,cuenta_faltas,cantidad_rounds)
VALUES
    (TRUE, FALSE,FALSE, FALSE, FALSE, FALSE, 1),
    (TRUE, TRUE, FALSE,FALSE, TRUE, FALSE, 1),
    ( FALSE,TRUE,FALSE,FALSE,FALSE,FALSE, 1),
    ( FALSE, TRUE,FALSE, FALSE, FALSE, FALSE, 1),
    ( FALSE, TRUE,FALSE, FALSE, TRUE, FALSE, 1),
    ( FALSE, FALSE,FALSE, TRUE, TRUE, TRUE, 1),
    (FALSE, FALSE,FALSE, TRUE, TRUE, FALSE, 1),
    (FALSE, FALSE,TRUE, TRUE, FALSE, FALSE, 1);

INSERT INTO
    Modalidad (nombre, disciplina_id, puntaje_id)
VALUES
('Vallas 110mts', 1, 1),
('Vallas 400mts', 1, 1),
('Planos 100mts', 1, 1),
('Planos 200mts', 1, 1),
('Planos 400mts', 1, 1),
('Planos 800mts', 1, 1),
('Planos 1500mts', 1, 1),
('Planos 5000mts', 1, 1),
('Planos 10000mts', 1, 1),
('Relevos 400mts', 1, 1),
('Relevos 1600mts', 1, 1),
('Marcha 20000mts', 1, 2),
('Salto en Largo', 1, 3),
('Salto en Alto', 1, 8),
('Salto con Pértiga', 1, 8),
('Salto Triple', 1, 3),
('Lanzamiento de Bala', 1, 4),
('Lanzamiento de Disco', 1, 4),
('Lanzamiento de Jabalina', 1, 4),
('Lanzamiento de Martillo', 1, 4),
('Decatlón', 1, 1),
('Heptatlón', 1, 1),
('Natación Libre 50mts', 2, 1),
('Natación Libre 100mts', 2, 1),
('Natación Libre 200mts', 2, 1),
('Natación Libre 400mts', 2, 1),
('Natación Libre 1500mts', 2, 1),
('Espalda 100mts', 2, 1),
('Espalda 200mts', 2, 1),
('Pecho 100mts', 2, 1),
('Pecho 200mts', 2, 1),
('Mariposa 100mts', 2, 1),
('Mariposa 200mts', 2, 1),
('Relevos Libre 400mts', 2, 1),
('Relevos Libre 800mts', 2, 1),
('Maraton de Natacion 10000mts', 2, 1),
('Sable', 6, 6),
('Florete', 6, 6),
('Espada', 6, 6),
('Shortboard', 7, 7),
('Longboard', 7, 7),
('SUP (Stand Up Paddle)', 7, 7),
('Kitesurf de Velocidad', 8, 7),
('Kitesurf Freestyle', 8, 7),
('KiteSurf de Olas', 8, 7);

INSERT INTO
    Categoria (id_modalidad, sexo, tamano_grupo, edad_inicio, edad_fin, peso_inicio, peso_fin)
VALUES
    (1, 'masculino', 1, 18, 35, null, null),
(1, 'masculino', 4, 18, 35, null, null),
(1, 'femenino', 1, 18, 35, null, null),
(1, 'femenino', 4, 18, 35, null, null),
(2, 'masculino', 1, 18, 35, null, null),
(2, 'masculino', 4, 18, 35, null, null),
(2, 'femenino', 1, 18, 35, null, null),
(2, 'femenino', 4, 18, 35, null, null),
(6, 'masculino', 1, 18, 35, null, null),
(6, 'masculino', 4, 18, 35, null, null),
(6, 'femenino', 1, 18, 35, null, null),
(6, 'femenino', 4, 18, 35, null, null),
(7, 'masculino', 1, 18, 35, null, null),
(7, 'masculino', 4, 18, 35, null, null),
(7, 'femenino', 1, 18, 35, null, null),
(7, 'femenino', 4, 18, 35, null, null),
(8, 'masculino', 1, 18, 35, null, null),
(8, 'masculino', 4, 18, 35, null, null),
(8, 'femenino', 1, 18, 35, null, null),
(8, 'femenino', 4, 18, 35, null, null);


INSERT INTO Persona (ci, nombre, apellido, contacto, email) VALUES
('1234567890', 'Juan', 'Pérez', '555-1234', 'juan.perez@example.com'),
('0987654321', 'Carlos', 'López', '555-5678', 'carlos.lopez@example.com'),
('1122334455', 'Luis', 'Rodríguez', '555-1122', 'luis.rodriguez@example.com'),
('5566778899', 'Miguel', 'Sánchez', '555-3344', 'miguel.sanchez@example.com'),
('6677889900', 'Ana', 'Martínez', '555-5566', 'ana.martinez@example.com'),
('9988776655', 'María', 'Gómez', '555-7788', 'maria.gomez@example.com'),
('4455667788', 'Laura', 'Fernández', '555-9900', 'laura.fernandez@example.com'),
('2233445566', 'Carmen', 'Ruiz', '555-1133', 'carmen.ruiz@example.com'),
('3344556677', 'Pedro', 'Gutiérrez', '555-2211', 'pedro.gutierrez@example.com'),
('7788990011', 'José', 'Torres', '555-3344', 'jose.torres@example.com');

INSERT INTO Juez (ci) VALUES
('1234567890'), -- Juan Pérez
('0987654321'), -- Carlos López
('1122334455'), -- Luis Rodríguez
('5566778899'), -- Miguel Sánchez
('6677889900'); -- Ana Martínez


INSERT INTO Participante (ci, edad, peso, modalidad_id) VALUES
('1234567890', 25, 70, 1), -- Juan Pérez en 400 metros
('0987654321', 28, 75, 2), -- Carlos López en 4x100 metros
('1122334455', 22, 68, 1), -- Luis Rodríguez en 400 metros
('5566778899', 30, 80, 3), -- Miguel Sánchez en 4x400 metros
('6677889900', 26, 60, 1), -- Ana Martínez en 400 metros
('9988776655', 24, 58, 2), -- María Gómez en 4x100 metros
('4455667788', 27, 62, 3), -- Laura Fernández en 4x400 metros
('2233445566', 29, 63, 1), -- Carmen Ruiz en 400 metros
('3344556677', 23, 70, 1), -- Pedro Gutiérrez en 400 metros
('7788990011', 31, 82, 2); -- José Torres en 4x100 metros

-- Inserciones de prueba en Participacion
INSERT INTO Participacion (participante_id, categoria_id) VALUES
(1, 1), -- Juan Pérez en categoría masculina individual de 400 metros
(2, 2), -- Carlos López en categoría masculina de equipo de 4x100 metros
(3, 1), -- Luis Rodríguez en categoría masculina individual de 400 metros
(4, 10), -- Miguel Sánchez en categoría masculina de equipo de 4x400 metros
(5, 3), -- Ana Martínez en categoría femenina individual de 400 metros
(6, 4), -- María Gómez en categoría femenina de equipo de 4x100 metros
(7, 11), -- Laura Fernández en categoría femenina de equipo de 4x400 metros
(8, 3), -- Carmen Ruiz en categoría femenina individual de 400 metros
(9, 1), -- Pedro Gutiérrez en categoría masculina individual de 400 metros
(10, 2); -- José Torres en categoría masculina de equipo de 4x100 metros
