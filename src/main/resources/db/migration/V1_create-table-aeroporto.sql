CREATE TABLE TB_AEROPORTO (
    codigoIATA SERIAL PRIMARY KEY,
    nomeAeroporto VARCHAR(255) NOT NULL,
    permitidoPousoAeronaves BOOLEAN UNIQUE NOT NULL,
    portoesDeEmbarque JSON NOT NULL,
    capacidadeDeArmazenamentoDeCombustivel DOUBLE PRECISION,
    limiteMaximoAeronaves INTEGER,
    fk_localizacaoAeroporto INTEGER NOT NULL,
    fk_torreDeControle INTEGER NOT NULL,
    fk_aviao INTEGER NOT NULL,
    CONSTRAINT fk_localizacao FOREIGN KEY (fk_localizacaoAeroporto) REFERENCES TB_LOCALIZACAO_AEROPORTO(id),
    CONSTRAINT fk_torre FOREIGN KEY (fk_torreDeControle) REFERENCES TB_TORRE_CONTROLE(id),
    CONSTRAINT fk_aviao FOREIGN KEY (fk_aviao) REFERENCES TB_AVIAO(id)
);
