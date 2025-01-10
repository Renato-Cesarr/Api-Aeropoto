CREATE TABLE TB_AVIAO (
    numeroDeSerie INTEGER PRIMARY KEY NOT NULL,
    modelo VARCHAR(25) NOT NULL,
    fabricante VARCHAR(25) NOT NULL,
    capacidadeMaximaKg DOUBLE PRECISION NOT NULL,
    capacidadeMaximaPessoas INTEGER NOT NULL,
    fk_piloto INTEGER NOT NULL,
    fk_tripulacao INTEGER NOT NULL,
    fk_flyaware INTEGER NOT NULL,
    CONSTRAINT fk_piloto FOREIGN KEY (fk_piloto) REFERENCES TB_PILOTO(id),
    CONSTRAINT fk_tripulacao FOREIGN KEY (fk_tripulacao) REFERENCES TB_TRIPULACAO(id),
    CONSTRAINT fk_flyaware FOREIGN KEY (fk_flyaware) REFERENCES TB_FLYAWARE(id)
);
