CREATE TABLE TB_PASSAGEIRO (
    numeroBilhete INT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    assento VARCHAR(10) NOT NULL,
    statusEmbarque VARCHAR(20) NOT NULL,
    fk_carga INT,
    FOREIGN KEY (carga_id) REFERENCES TB_CARGA(id)
);
