CREATE TABLE tb_localizacao_aeroporto (
    id_localizacao BIGSERIAL PRIMARY KEY,
    cep VARCHAR(15) NOT NULL,
    cidade VARCHAR(25) NOT NULL,
    endereco VARCHAR(75) NOT NULL,
    estado VARCHAR(15) NOT NULL
);