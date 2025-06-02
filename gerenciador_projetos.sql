create database gerenciador_projetos;
use gerenciador_projetos;

create table projetos(
	id int auto_increment primary key,
    titulo varchar(100) not null,
    descricao text,
    prazo date,
    status varchar(50)
);

CREATE TABLE tarefas (
  id INT AUTO_INCREMENT PRIMARY KEY,
  projeto_id INT NOT NULL,
  nome VARCHAR(100) NOT NULL,
  descricao TEXT,
  prazo DATE,
  status VARCHAR(50),
  prioridade VARCHAR(50),
  FOREIGN KEY (projeto_id) REFERENCES projetos(id) ON DELETE CASCADE
);