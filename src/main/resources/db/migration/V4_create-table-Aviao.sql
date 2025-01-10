CREATE TABLE TB_AVIAO (
    numeroDeSerie INTEGER PRIMARY KEY NOT NULL,
    modelo VARCHAR(25) NOT NULL,
    fabricante VARCHAR(25) NOT NULL,
    capacidadeMaximaKg DOUBLE PRECISION NOT NULL,
    capacidadeMaximaPessoas INTEGER NOT NULL,
    fk_piloto INTEGER NOT NULL,
    fk_tripulacao INTEGER NOT NULL,
    fk_fly_aware INTEGER NOT NULL,
    fk_passageiro INTEGER NOT NULL,
    CONSTRAINT fk_piloto FOREIGN KEY (fk_piloto) REFERENCES TB_PILOTO(id),
    CONSTRAINT fk_tripulacao FOREIGN KEY (fk_tripulacao) REFERENCES TB_TRIPULACAO(id),
    CONSTRAINT fk_fly_aware FOREIGN KEY (fk_fly_aware) REFERENCES TB_FLY_AWARE(id),
    CONSTRAINT fk_passageiro FOREIGN KEY (fk_passageiro) REFERENCES TB_PASSAGEIRO(id)
);
