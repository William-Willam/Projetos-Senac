CREATE DATABASE hamburgueria;
USE hamburgueria;

CREATE TABLE funcionarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    usuario VARCHAR(50) UNIQUE NOT NULL,
    senha VARCHAR(255) NOT NULL,
    is_admin BOOLEAN NOT NULL DEFAULT FALSE
);

CREATE TABLE produtos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT,
    preco DECIMAL(10, 2) NOT NULL
);

CREATE TABLE pedidos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    funcionario_id INT,
    data_pedido DATETIME DEFAULT CURRENT_TIMESTAMP,
    total DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (funcionario_id) REFERENCES funcionarios(id)
);

-- Tabela de relacionamento para os itens do pedido
CREATE TABLE pedido_itens (
    pedido_id INT,
    produto_id INT,
    quantidade INT NOT NULL,
    preco_unitario DECIMAL(10, 2) NOT NULL,
    PRIMARY KEY (pedido_id, produto_id),
    FOREIGN KEY (pedido_id) REFERENCES pedidos(id),
    FOREIGN KEY (produto_id) REFERENCES produtos(id)
);

-- Insira o administrador inicial
INSERT INTO funcionarios (nome, usuario, senha, is_admin) VALUES ('William', 'admin', 'admin@123@', TRUE);

select * from funcionarios;
