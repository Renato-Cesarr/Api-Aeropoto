CREATE TABLE tb_tipo_de_carga (
    ticket_da_carga SERIAL PRIMARY KEY,
    carga_fragil BOOLEAN,
    categoria_carga VARCHAR(50) NOT NULL,
    classificacao_periculosidade VARCHAR(50) NOT NULL CHECK (classificacao_periculosidade IN ('BAIXA', 'MEDIA', 'ALTA')),
    temperatura_da_carga FLOAT8
);