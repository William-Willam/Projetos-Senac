-- Apagar o banco de dados se já existir
DROP DATABASE IF EXISTS gerenciador_projetos;

-- Criar e selecionar o banco
CREATE DATABASE gerenciador_projetos;
USE gerenciador_projetos;

-- Tabela de usuários
CREATE TABLE usuarios (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(100) NOT NULL,
  email VARCHAR(100) NOT NULL UNIQUE,
  senha VARCHAR(150) NOT NULL
);

-- Tabela de projetos
CREATE TABLE projetos (
  id INT AUTO_INCREMENT PRIMARY KEY,
  usuario_id INT NOT NULL,
  titulo VARCHAR(100) NOT NULL,
  descricao TEXT,
  prazo DATE,
  status VARCHAR(50),
  FOREIGN KEY (usuario_id) REFERENCES usuarios(id) ON DELETE CASCADE
);

-- Tabela de tarefas
CREATE TABLE tarefas (
  id INT AUTO_INCREMENT PRIMARY KEY,
  projeto_id INT NOT NULL,
  usuario_id INT NOT NULL,
  nome VARCHAR(100) NOT NULL,
  descricao TEXT,
  prazo DATE,
  status VARCHAR(50),
  prioridade VARCHAR(50),
  FOREIGN KEY (projeto_id) REFERENCES projetos(id) ON DELETE CASCADE,
  FOREIGN KEY (usuario_id) REFERENCES usuarios(id) ON DELETE CASCADE
);






