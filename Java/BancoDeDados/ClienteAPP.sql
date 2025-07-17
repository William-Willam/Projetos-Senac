CREATE DATABASE ClienteBD;
USE ClienteBD;

CREATE TABLE clientes (
    id     INT AUTO_INCREMENT PRIMARY KEY,
    nome   VARCHAR(100),
    email  VARCHAR(100),
    cpf    VARCHAR(100)
);