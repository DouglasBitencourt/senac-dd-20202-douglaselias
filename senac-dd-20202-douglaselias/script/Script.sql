drop database if exists covid;
create database covid;
use covid;

CREATE TABLE pessoa(
	id_pessoa int not null auto_increment,
    nome varchar(150)not null,
    cpf int not null,
    dtNascimento date not null,
    sexo int not null,
    PRIMARY KEY(id_pessoa)
);

CREATE TABLE publicoGeral(
	id_publicoGeral int not null auto_increment,
    voluntario int not null,
    id_pessoa int not null,
    PRIMARY KEY(id_publicoGeral),
    FOREIGN KEY(id_pessoa) REFERENCES pessoa(id_pessoa)
);

CREATE TABLE pesquisador(
	id_pesquisador int not null auto_increment,
    institution varchar(150) not null,
    id_pessoa int not null,
    PRIMARY KEY(id_pesquisador),
    FOREIGN KEY(id_pessoa) REFERENCES pessoa(id_pessoa)
);

CREATE TABLE vacina(
	id_vacina int not null auto_increment,
    pais varchar(100) not null,
    estagio int not null,
    id_pesquisador int not null,
    PRIMARY KEY(id_vacina),
    FOREIGN KEY(id_pesquisador) REFERENCES pesquisador(id_pesquisador)
);


CREATE TABLE pessoaVacinada(
	id_pessoaVacinada int not null auto_increment,
    avaliacao int not null,
    id_vacina int not null,
    id_pessoa int not null,
    PRIMARY KEY(id_pessoaVacinada),
    FOREIGN KEY(id_vacina) REFERENCES vacina(id_vacina),
    FOREIGN KEY(id_pessoa) REFERENCES pessoa(id_pessoa)
);