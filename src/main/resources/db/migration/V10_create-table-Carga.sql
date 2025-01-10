CREATE TABLE TB_CARGA (
    numeroIdentificadorCarga INT PRIMARY KEY,
    pesoTotalCarga DOUBLE,
    statusDaCarga VARCHAR(20) NOT NULL,
    fk_tipoDeCarga INT NOT NULL,
    CONSTRAINT fk_tipoDeCarga FOREIGN KEY (fk_tipoDeCarga) REFERENCES TB_LOCALIZACAO_AEROPORTO(id)
);
