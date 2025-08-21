create database Login;
use Login;

create table usuarios(
	id int auto_increment primary key,
    usuario varchar(50) not null,
    senha varchar(255) not null
);

insert into usuarios( usuario, senha) values ("william", "wsdr123");