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

-- Tabela de Clientes
CREATE TABLE clientes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    cpf VARCHAR(14) NOT NULL UNIQUE
);

-- Adiciona a coluna cliente_id na tabela pedidos
ALTER TABLE pedidos ADD COLUMN cliente_id INT;

-- Cria uma chave estrangeira para a tabela clientes
ALTER TABLE pedidos ADD CONSTRAINT fk_cliente
FOREIGN KEY (cliente_id) REFERENCES clientes(id);

INSERT INTO produtos (nome, descricao, preco) VALUES
('Classic Burger', 'Hambúrguer de carne, queijo, alface, tomate e molho especial.', 25.00),
('Bacon Supreme', 'Hambúrguer com fatias de bacon crocante, queijo cheddar e cebola caramelizada.', 30.50),
('Chicken Crispy', 'Filé de frango empanado, alface, maionese temperada e queijo prato.', 28.00),
('Vegetariano', 'Hambúrguer de grão de bico, queijo, alface, tomate e picles.', 27.00),
('Smash Burger', 'Dois hambúrgueres finos, queijo derretido, cebola picada e pão de brioche.', 22.00),
('Batata Frita Tradicional', 'Porção de batatas fritas crocantes com sal.', 12.00),
('Batata Frita com Cheddar e Bacon', 'Porção de batatas fritas coberta com queijo cheddar cremoso e bacon.', 18.50),
('Anéis de Cebola', 'Porção de anéis de cebola empanados e fritos.', 15.00),
('Coca-Cola (Lata)', 'Lata de 350ml.', 6.00),
('Guaraná Antarctica (Lata)', 'Lata de 350ml.', 6.00),
('Água Mineral', 'Garrafa de água mineral sem gás.', 4.00),
('Milkshake de Chocolate', 'Milkshake cremoso de chocolate.', 20.00),
('Milkshake de Morango', 'Milkshake cremoso de morango.', 20.00),
('Pudim de Leite', 'Sobremesa de pudim de leite condensado.', 10.00),
('Molho Extra', 'Porção extra de molho especial da casa.', 3.00);

-- Insira o administrador inicial
INSERT INTO funcionarios (nome, usuario, senha, is_admin) VALUES ('William', 'admin', 'admin@123@', TRUE);

select * from produtos;
select * from funcionarios;
