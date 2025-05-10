CREATE DATABASE fitness_db;

USE fitness_db;

CREATE TABLE users (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(100),
  email VARCHAR(100) UNIQUE,
  senha_hash VARCHAR(255),
  plano_id INT DEFAULT NULL
);

CREATE TABLE planos (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(50),
  preco DECIMAL(10,2)
);

CREATE TABLE dados_usuarios (
  id INT AUTO_INCREMENT PRIMARY KEY,
  user_id INT,
  peso DECIMAL(5,2),
  altura DECIMAL(5,2),
  imc DECIMAL(5,2),
  exercicio TEXT,
  atualizado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE pagamentos (
  id INT AUTO_INCREMENT PRIMARY KEY,
  user_id INT,
  status ENUM('pendente', 'pago') DEFAULT 'pendente',
  data_pagamento TIMESTAMP,
  FOREIGN KEY (user_id) REFERENCES users(id)
);
