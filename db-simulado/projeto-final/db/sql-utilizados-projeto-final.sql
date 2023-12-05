create schema IF NOT exists mundo_bola_projeto_final character set = utf8mb4 collate = utf8mb4_general_ci;

create table if not exists usuario(
	cpf varchar(14) not null,
	email text not null,
	nome varchar(50) not null,
	senha varchar(50) not null,
	data_criacao datetime not null,
	data_alteracao datetime,
	primary key(cpf),
	index(nome)
) engine = MyISAM;

create table if not exists marca(
	marca_id varchar(40) not null,
	nome varchar(50) not null,
    imagem_url text,
    data_criacao datetime not null,
    data_alteracao datetime,
    criador_usuario_cpf varchar(14) not null,
    alterador_usuario_cpf varchar(14),
    primary key(marca_id),
    index (nome),
    foreign key (criador_usuario_cpf) references usuario(cpf),
    foreign key (alterador_usuario_cpf) references usuario(cpf)
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
    criador_usuario_cpf varchar(14) not null,
    alterador_usuario_cpf varchar(14),
    primary key(bola_id),
    index (nome),
    foreign key(marca_id) references marca(marca_id),
    foreign key (criador_usuario_cpf) references usuario(cpf),
    foreign key (alterador_usuario_cpf) references usuario(cpf)
) engine = MyISAM;

create table if not exists detalhes_tecnicos(
	bola_id varchar(40) not null,
	a_fazer varchar(100),
	primary key(bola_id),
	foreign key(bola_id) references bola(bola_id)
) engine = MyISAM;

create table if not exists loja(
	loja_id varchar(40) not null,
	data_criacao datetime not null,
	data_alteracao datetime,
	criador_usuario_cpf varchar(14) not null,
	alterador_usuario_cpf varchar(14),
    primary key (loja_id),
	foreign key (criador_usuario_cpf) references usuario(cpf),
	foreign key (alterador_usuario_cpf) references usuario(cpf)
) engine = MyISAM;

create table if not exists endereco(
	loja_id varchar(40) not null,
    logradouro varchar(100) not null,
    numero varchar(5) not null,
    complemento varchar(50),
    cep varchar(10),
    bairro varchar(50),
    cidade varchar(50),
    uf varchar(2),
    primary key (loja_id),
    foreign key(loja_id) references loja(loja_id)
) engine = MyISAM;

create table if not exists telefone(
	loja_id varchar(40) not null,
    telefone varchar(20) not null,
    foreign key(loja_id) references loja(loja_id)
)engine = MyISAM;

create table if not exists armazem_loja(
	loja_id varchar(40) not null,
    bola_id varchar(40) not null,
    quantidade_bola integer not null,
    primary key (loja_id,bola_id),
    foreign key(loja_id) references loja(loja_id),
    foreign key(bola_id)references bola(bola_id)
)engine = MyISAM;

insert into usuario(cpf,email,nome,senha,data_criacao,data_alteracao) values(
'29768006005',
'admin@gmail.com',
'admin10',
'123456',
current_date(),
null
),
(
'71292479086',
'silvio@gmail.com',
'silvio20',
'123456',
current_date(),
null
);

insert into marca (marca_id,nome,imagem_url,data_criacao,data_alteracao,criador_usuario_cpf,alterador_usuario_cpf)values (
'4946112a-b895-4c8f-b5c1-1c8dc0b65dee',
'Adidas',
'https://upload.wikimedia.org/wikipedia/commons/thumb/2/24/Adidas_logo.png/1200px-Adidas_logo.png',
current_date(),
null,
'29768006005',
null
),
(
'849324c0-2d2d-4097-87f4-68dae63b2f5b',
'Nike',
'https://logospng.org/wp-content/uploads/nike.jpg',
current_date(),
null,
'29768006005',
null
),
(
'8bc9a223-3a8f-4523-aba8-dc1d9811523b',
'Penalty',
'https://seeklogo.com/images/P/penalty-logo-A248974510-seeklogo.com.png',
current_date(),
null,
'71292479086',
null
);

insert into bola (bola_id,nome,preco,marca_id,descricao,imagem_url,data_criacao,data_alteracao,criador_usuario_cpf,alterador_usuario_cpf) values(
'a4216a2e-a33a-4857-b47d-1d17b921c1a6',
'Total90',
99.90,
'849324c0-2d2d-4097-87f4-68dae63b2f5b',
'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc congue. ',
'https://assets-mantosdofutebol.sfo2.digitaloceanspaces.com/wp-content/uploads/2017/03/bola-PL-Nike-Total-90-Aerrow-2004-2005.jpg',
current_date(),
null,
'29768006005',
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
null,
'29768006005',
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
null,
'29768006005',
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
null,
'29768006005',
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
null,
'29768006005',
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
null,
'29768006005',
null
);

insert into loja(loja_id,data_criacao,data_alteracao,criador_usuario_cpf,alterador_usuario_cpf) values (
	'3c7f85ad-0314-4f7c-977c-9b16e19782c8',
	current_date(),
	null,
	'71292479086',
	null
);

insert into endereco(loja_id,logradouro,numero,complemento,bairro,cep,cidade,uf) values(
	'3c7f85ad-0314-4f7c-977c-9b16e19782c8',
	'Rua das Palmeiras',
	'123',
	null,
	'Jardim Santana',
	'11234456',
	'Salto de Pirapora',
	'SP'
);

insert into telefone(loja_id,telefone) values(
'3c7f85ad-0314-4f7c-977c-9b16e19782c8',
'11965454345'
),
(
'3c7f85ad-0314-4f7c-977c-9b16e19782c8',
'1145678756'
);

insert into armazem_loja (loja_id,bola_id,quantidade_bola) values(
'3c7f85ad-0314-4f7c-977c-9b16e19782c8',
'a4216a2e-a33a-4857-b47d-1d17b921c1a6',
6
),
(
'3c7f85ad-0314-4f7c-977c-9b16e19782c8',
'da6d14aa-9125-4f5a-871e-bbca635c9255',
4
),
(
'3c7f85ad-0314-4f7c-977c-9b16e19782c8',
'a27a1d9e-07b3-4ed5-bee0-1d66ee9a7054',
0
),
(
'3c7f85ad-0314-4f7c-977c-9b16e19782c8',
'f6c7214f-5041-4096-91f2-26db7d4341df',
20
),
(
'3c7f85ad-0314-4f7c-977c-9b16e19782c8',
'0309d77c-c7c1-4eb7-b2ba-457b7eafade4',
3
),
(
'3c7f85ad-0314-4f7c-977c-9b16e19782c8',
'e859e886-31dc-4fee-8d4f-01fbd565cabd',
8
);
