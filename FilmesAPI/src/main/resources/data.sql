CREATE TABLE filme (
    id varchar(255) not null primary key,
    titulo varchar(50) not null,
    genero varchar(30),
    duracao numeric(3,0),
    diretor varchar(50),
    ano_lancamento varchar(4),
    pais varchar(30),
    imdb numeric(2,1)
);
