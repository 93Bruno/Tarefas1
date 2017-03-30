drop database if exists crud_cardapio;

create database crud_cardapio;

use crud_cardapio;

CREATE TABLE cardapio(
IdProduto INT auto_increment NOT NULL ,
nomeProduto VARCHAR(45) NOT NULL,
descProduto VARCHAR(60) NOT NULL ,
valorProduto double    NOT NULL ,
dispProduto varchar(50) not null,
PRIMARY KEY (IdProduto)
); 
