drop database vacinas;
create database vacinas;
use vacinas;

create table  vacinas(
pk_vacinas int not null auto_increment,
paisDeOrigem varchar(150),
estagioPesquisa int,
nomePesquisador varchar(150),
aplicavao int,
primary key(pk_vacinas)

);

create table pessoa(
pk_pessoa int not null auto_increment,
dataNascimento date,
sexo boolean,
cpf varchar(100),
reacao int,
primary key(pk_pessoa)
);