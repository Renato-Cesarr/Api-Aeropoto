CREATE TABLE tb_licenca_de_piloto_anac (
    numero_da_licenca INT PRIMARY KEY,
    data_emissao TIMESTAMP(6) NOT NULL,
    data_validade TIMESTAMP(6) NOT NULL,
    situacao VARCHAR(15) NOT NULL CHECK (situacao IN ('ATIVA', 'SUSPENSA', 'CANCELADA', 'VENCIDA')),
    tipo_da_licenca VARCHAR(40) NOT NULL
);