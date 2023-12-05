create schema IF NOT exists mundo_bola_pre_alpha character set = utf8mb4 collate = utf8mb4_general_ci;

create table if not exists marca(
	marca_id varchar(40) not null,
	nome varchar(50) not null,
    imagem_url text,
    data_criacao datetime not null,
    data_alteracao datetime,
    primary key(marca_id)
) engine = MyISAM;

create table if not exists bola(
	bola_id varchar(40) not null,
    nome varchar(50) not null,
    preco decimal (6,2) not null,
    marca_id varchar(36) not null,
    descricao text,
    imagem_url text,
    data_criacao datetime not null,
    data_alteracao datetime,
    primary key(bola_id),
    foreign key(marca_id) references marca(marca_id)
) engine = MyISAM;

alter table marca add index (nome);

alter table bola add index (nome);

insert into marca (marca_id,nome,imagem_url,data_criacao,data_alteracao)values (
'4946112a-b895-4c8f-b5c1-1c8dc0b65dee',
'Adidas',
'https://upload.wikimedia.org/wikipedia/commons/thumb/2/24/Adidas_logo.png/1200px-Adidas_logo.png',
current_date(),
null
),
(
'849324c0-2d2d-4097-87f4-68dae63b2f5b',
'Nike',
'https://logospng.org/wp-content/uploads/nike.jpg',
current_date(),
null
),
(
'8bc9a223-3a8f-4523-aba8-dc1d9811523b',
'Penalty',
'https://seeklogo.com/images/P/penalty-logo-A248974510-seeklogo.com.png',
current_date(),
null
);

insert into bola (bola_id,nome,preco,marca_id,descricao,imagem_url,data_criacao,data_alteracao) values(
'a4216a2e-a33a-4857-b47d-1d17b921c1a6',
'Total90',
99.90,
'849324c0-2d2d-4097-87f4-68dae63b2f5b',
'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc congue. ',
'https://assets-mantosdofutebol.sfo2.digitaloceanspaces.com/wp-content/uploads/2017/03/bola-PL-Nike-Total-90-Aerrow-2004-2005.jpg',
current_date(),
null
),
(
'da6d14aa-9125-4f5a-871e-bbca635c9255',
'Jabulani',
1090.90,
'4946112a-b895-4c8f-b5c1-1c8dc0b65dee',
'Lorem ipsum dolor sit amet. ',
'https://s2.glbimg.com/7dzisN-U42ChaQeJA8HPH9F8L4sp0re7dXrg1kCDpXpIoz-HdGixxa_8qOZvMp3w/s.glbimg.com/es/ge/f/original/2012/08/12/jabu.jpg',
current_date(),
null
),
(
'a27a1d9e-07b3-4ed5-bee0-1d66ee9a7054',
'Penalty Lider Campo',
299.90,
'8bc9a223-3a8f-4523-aba8-dc1d9811523b',
null,
'https://d2p7wtszppk2p4.cloudfront.net/Custom/Content/Products/51/33/51330_bola-campo-lider-xxi-bc-lj-pt-t-u-pr-7852-5213031710_l4_637570278602232766.jpg',
current_date(),
null
),
(
'f6c7214f-5041-4096-91f2-26db7d4341df',
'Bola Society Penalty Se7e R2 Ko X',
249.90,
'8bc9a223-3a8f-4523-aba8-dc1d9811523b',
'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer imperdiet tincidunt tortor non condimentum. Proin egestas accumsan nibh a iaculis. Suspendisse non leo erat. Sed lobortis ligula id tellus pretium. ',
'https://images-americanas.b2w.io/produtos/7332761295/imagens/bola-de-futebol-society-penalty-se7e-r2-ko-x-pt-az-e-pt-am/7332761367_3_large.jpg',
current_date(),
null
),
(
'0309d77c-c7c1-4eb7-b2ba-457b7eafade4',
'Bola Nike Premier League Academy',
199.90,
'849324c0-2d2d-4097-87f4-68dae63b2f5b',
'A Bola de Futebol Premier League Academy tem sulcos inovadores projetados para um giro consistente quando a bola está no ar. ',
'https://imgnike-a.akamaihd.net/768x768/0243935B.jpg',
current_date(),
null
),
(
'e859e886-31dc-4fee-8d4f-01fbd565cabd',
'Bola Al Rihla Pro',
999.90,
'4946112a-b895-4c8f-b5c1-1c8dc0b65dee',
'"Al Rihla" significa "A Jornada", e a bola é só o começo. O resto da sua jornada no futebol ainda vai ser escrito. Com estrutura sem costuras, esta bola oficial da Copa do Mundo FIFA Catar 2022™ adidas Al Rihla Pro representa um novo conceito de alta precisão. ',
'https://assets.adidas.com/images/h_840,f_auto,q_auto:sensitive,fl_lossy,c_fill,g_auto/aa6f6d655b3d40a1a71cae680085031a_9366/Bola_Al_Rihla_Pro_Branco_H57783.jpg',
current_date(),
null
);