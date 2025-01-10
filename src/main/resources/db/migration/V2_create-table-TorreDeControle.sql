CREATE TABLE tb_torre_de_controle (
    nome VARCHAR(255) PRIMARY KEY,
    equipamento_comunicacao VARCHAR(50) NOT NULL,
    trafego_aereo_atual INT NOT NULL,
    fk_aeroporto INT,
    CONSTRAINT fk_torre_aeroporto FOREIGN KEY (fk_aeroporto) REFERENCES tb_aeroporto(codigoiata)
);