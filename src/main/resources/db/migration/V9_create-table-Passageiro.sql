CREATE TABLE tb_passageiro (
    numero_bilhete INT PRIMARY KEY,
    assento VARCHAR(255) NOT NULL,
    nome VARCHAR(75) NOT NULL,
    status_embarque VARCHAR(15) NOT NULL CHECK (status_embarque IN ('CHECK_IN', 'EMBARCADO', 'NAO_EMBARCADO', 'CANCELADO')),
    fk_aviao INT NOT NULL,
    fk_carga INT,
    CONSTRAINT fk_passageiro_aviao FOREIGN KEY (fk_aviao) REFERENCES tb_aviao(numero_de_serie),
    CONSTRAINT fk_passageiro_carga FOREIGN KEY (fk_carga) REFERENCES tb_carga(numero_identificador_carga)
);