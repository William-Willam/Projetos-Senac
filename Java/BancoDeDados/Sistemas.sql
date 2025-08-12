create database Sistema_Clientes;
use Sistema_Clientes;

create table clientes(
	id int auto_increment primary key,
    nome varchar(100) not null,
    email varchar(100) not null
);

select * from clientes;