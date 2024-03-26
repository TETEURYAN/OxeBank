insert into fatura(id, nome, valor)
values ('101', 'Jose Carlos', 0);

insert into fatura(id, nome, valor)
values ('102', 'Lucas Heron', 0);

insert into fatura(id, nome, valor)
values ('103', 'Matheus Ryan', 0);

insert into produto(Iduser, nome,descricao,categoria, preco)
values (101,'Notebook Dell Ispireon 8567', '8Gb de Ram, 1 TB SSD e 15 polegaas', 'Notebooks', 3200.00);
insert into produto(Iduser, nome,descricao,categoria, preco)
values (101, 'Cadeira gamer', 'TGT Heron', 'Moveis', 400.00);
insert into produto(Iduser, nome,descricao,categoria, preco)
values (101, 'Mousepad gamer Multilaer 7.2 polegadas', 'Mousepad da Multilaser', 'Acessorios', 12.00);

insert into produto(Iduser, nome,descricao,categoria, preco)
values (102,'Honda CG 160 ', 'Moto com 120 cilindradas', 'automoveis', 13200.00);
insert into produto(Iduser, nome,descricao,categoria, preco)
values (102,'Box Harry Potter completo + poster', '7 livros do Harry Potter', 'livros', 150.00);

insert into produto(Iduser, nome,descricao,categoria, preco)
values (103,'Funk Pop do Messi', 'Funko Pop da Copa do Mundo FIFA Catar 2022', 'brinquedos', 220.00);
insert into produto(Iduser, nome,descricao,categoria, preco)
values (103,'Cortina siamesa chinessa', 'Cortina oriental para colocar em sua casa', 'acessorios', 560.00);

UPDATE fatura
SET valor = (
    SELECT SUM(preco)
    FROM produto
    WHERE produto.Iduser = fatura.id
)
