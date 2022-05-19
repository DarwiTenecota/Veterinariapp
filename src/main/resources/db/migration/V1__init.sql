CREATE TABLE IF NOT EXISTS veterinario(
    id SERIAL,
    name VARCHAR (16) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS dueno (
     id SERIAL,
     nombre VARCHAR (100) NOT NULL,
     PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS mascota (
    id SERIAL,
    name VARCHAR (100) NOT NULL,
    edad VARCHAR (100) NOT NULL,
    peso VARCHAR (15) NOT NULL,
    PRIMARY KEY (id)
);







