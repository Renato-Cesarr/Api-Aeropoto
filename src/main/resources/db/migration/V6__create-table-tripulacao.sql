CREATE TABLE tb_tripulacao (
    id_tripulacao BIGSERIAL PRIMARY KEY,
    funcao VARCHAR(255) NOT NULL,
    horas_de_voo INT NOT NULL,
    licenciamento VARCHAR(25) NOT NULL,
    nome VARCHAR(75) NOT NULL,
    numero_voo INT NOT NULL
);