CREATE DATABASE cinemabd;
use cinemabd;

-- administrador
CREATE TABLE administrador(
	id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100),
    codAdmin VARCHAR(100),
    senha VARCHAR(100)
);

-- funcionario
CREATE TABLE funcionario(
	id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100),
    codFunc VARCHAR(100),
    senha VARCHAR(100)
);
