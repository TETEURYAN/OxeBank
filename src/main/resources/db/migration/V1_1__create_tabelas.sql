create table fatura(
    id serial not null,
    nome varchar(50) not null,
    valor numeric(5.2) not null,
    PRIMARY KEY(id)
);

create table produto(
    id serial not null,
    idUser serial not null references fatura(id),
    nome varchar(50) not null,
    descricao varchar(50) not null,
    categoria varchar(50) not null,
    preco numeric(5.2) not null,
    PRIMARY KEY(id)
);

