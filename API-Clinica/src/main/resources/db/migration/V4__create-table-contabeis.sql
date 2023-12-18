create table contabeis(

    id bigint not null auto_increment,
    nome varchar(100) not null,
    nascimento varchar(100) not null,
    cpf varchar(11) not null unique,
    crc varchar(6) not null unique,
    especialidade varchar(100) not null,
    logradouro varchar(100) not null,
    rua varchar(100) not null,
    uf char(2) not null,
    cidade varchar(100) not null,

    primary key(id)

);