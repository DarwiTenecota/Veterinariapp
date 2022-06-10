CREATE TABLE IF NOT EXISTS veterinario(
    id SERIAL,
    name VARCHAR (16) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS dueño (
     id SERIAL,
     nombre VARCHAR (100) NOT NULL,
     PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS mascota (
    id SERIAL,
    name VARCHAR (100) NOT NULL,
    edad INT  NOT NULL,
    peso INT  NOT NULL,
    veterinarioId INT NOT NULL,
    dueñoId INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (veterinarioId) references veterinario(id),
    FOREIGN KEY (dueñoId) references dueño(id)
);

 CREATE TABLE IF NOT EXISTS usuario(
    id SERIAL,
    username VARCHAR (100) NOT NULL,
    password VARCHAR (10) NOT NULL,
    PRIMARY KEY (id)
    );






