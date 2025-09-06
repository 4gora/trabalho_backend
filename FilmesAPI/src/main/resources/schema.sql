CREATE TABLE IF NOT EXISTS filme (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(50) NOT NULL,
    genero VARCHAR(30),
    duracao NUMERIC(3,0),
    diretor VARCHAR(50),
    ano_lancamento VARCHAR(4),
    pais VARCHAR(30),
    imdb NUMERIC(3,1) CHECK (imdb >= 0 AND imdb <= 10)
);
