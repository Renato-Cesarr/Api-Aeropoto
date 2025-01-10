CREATE TABLE TB_PASSAGEIRO (
    numeroBilhete INT PRIMARY KEY NOT NULL,
    nome VARCHAR(50) NOT NULL,
    assento VARCHAR(10) NOT NULL,
    statusEmbarque VARCHAR(20) NOT NULL,
    fk_carga INTEGER NOT NULL,
    fk_aviao INTEGER NOT NULL,
    FOREIGN KEY (fk_aviao) REFERENCES TB_AVIAO(numeroDeSerie)  
);
