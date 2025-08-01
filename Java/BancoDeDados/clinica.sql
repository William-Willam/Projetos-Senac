-- drop database clinica;
CREATE DATABASE clinica;
USE clinica;

CREATE TABLE paciente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    idade INT,
    cpf VARCHAR(14)
);

select * from paciente;