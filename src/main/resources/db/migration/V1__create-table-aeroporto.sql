CREATE TABLE IF NOT EXISTS tb_aeroporto (
    codigoiata SERIAL PRIMARY KEY,
    capacidade_de_armazenamento_de_combustivel FLOAT8,
    limite_maximo_aeronaves INT,
    nome_aeroporto VARCHAR(50) NOT NULL,
    permitido_pouso_aeronaves BOOLEAN NOT NULL,
    portoes_de_embarque INT[] NOT NULL,
    fk_localizacao_aeroporto INT NOT NULL UNIQUE,
    CONSTRAINT fk_aeroporto_localizacao FOREIGN KEY (fk_localizacao_aeroporto) REFERENCES tb_localizacao_aeroporto(id_localizacao)
);