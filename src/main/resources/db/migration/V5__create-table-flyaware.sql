CREATE TABLE tb_flyaware (
    id_rota BIGSERIAL PRIMARY KEY,
    destino VARCHAR(50) NOT NULL,
    numero_da_rota INT NOT NULL,
    origem VARCHAR(50) NOT NULL,
    tempo_estimado_voo FLOAT8 NOT NULL
);
