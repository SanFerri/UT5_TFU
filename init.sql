create database olimpiadas_db;

use olimpiadas_db;


create table Persona
(
    CI int(8) PRIMARY KEY NOT NULL,
    Nombre VARCHAR(20) NOT NULL,
    Apellido VARCHAR(20) NOT NULL,
    Contacto VARCHAR(20) NOT NULL,
    Email VARCHAR(50) UNIQUE NOT NULL
);

create table Disciplina
(
    DisciplinaID int auto_increment PRIMARY KEY NOT NULL,
    Nombre  VARCHAR(20) NOT NULL
);

create table Modalidad
(
    ModalidadID int auto_increment PRIMARY KEY NOT NULL,
    Nombre  VARCHAR(20) NOT NULL,
    DisciplinaID int  NOT NULL,
    FOREIGN KEY (DisciplinaID) REFERENCES Disciplina(DisciplinaID)
);

create table Categoria
(
    CategoriaID int auto_increment PRIMARY KEY NOT NULL,
    Nombre  VARCHAR(20) NOT NULL,
    DisciplinaID int  NOT NULL,
    FOREIGN KEY (DisciplinaID) REFERENCES Disciplina(DisciplinaID)
);

create table Juez
(
    JuezID int auto_increment PRIMARY KEY NOT NULL,
    CI int  NOT NULL,
    ModalidadID int  NOT NULL,
    FOREIGN KEY (CI) REFERENCES Persona(CI),
    FOREIGN KEY (ModalidadID) REFERENCES Modalidad(ModalidadID)
);

create table Participante
(
    ParticipanteID int auto_increment PRIMARY KEY NOT NULL,
    CI int  NOT NULL,
    ModalidadID int NOT NULL,
    FOREIGN KEY (CI) REFERENCES Persona(CI),
    FOREIGN KEY (ModalidadID) REFERENCES Modalidad(ModalidadID)
);

create table TipoPuntaje
(
    Nombre VARCHAR(20) PRIMARY KEY NOT NULL
);


create table TipoPuntajeModalidad
(
    Nombre VARCHAR(20)  NOT NULL,
    ModalidadID int  NOT NULL,
    FOREIGN KEY (ModalidadID) REFERENCES Modalidad(ModalidadID),
    FOREIGN KEY (Nombre) REFERENCES TipoPuntaje(Nombre)
);

create table Puntaje
(
    PuntajeID int auto_increment PRIMARY KEY NOT NULL,
    Nombre  VARCHAR(20) NOT NULL,
    Valor int NOT NULL,
    ParticipanteID int  NOT NULL,
    JuezID int  NOT NULL,
    FOREIGN KEY (ParticipanteID) REFERENCES Participante(ParticipanteID),
    FOREIGN KEY (JuezID) REFERENCES Juez(JuezID),
    FOREIGN KEY (Nombre) REFERENCES TipoPuntaje(Nombre)
);