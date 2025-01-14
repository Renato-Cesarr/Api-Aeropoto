CREATE TABLE tb_aviao (
    numero_de_serie BIGINT PRIMARY KEY,
    capacidade_maxima_kg FLOAT8 NOT NULL,
    capacidade_maxima_pessoas INT NOT NULL,
    fabricante VARCHAR(50) NOT NULL,
    modelo VARCHAR(50) NOT NULL,
    fk_fly_aware BIGINT NOT NULL UNIQUE,
    fk_piloto BIGINT NOT NULL,
    fk_tripulacao BIGINT NOT NULL,
    fk_aeroporto BIGINT,
    CONSTRAINT fk_aviao_flyaware FOREIGN KEY (fk_fly_aware) REFERENCES tb_flyaware(id_rota),
    CONSTRAINT fk_aviao_piloto FOREIGN KEY (fk_piloto) REFERENCES tb_piloto(id_piloto),
    CONSTRAINT fk_aviao_tripulacao FOREIGN KEY (fk_tripulacao) REFERENCES tb_tripulacao(id_tripulacao),
    CONSTRAINT fk_aviao_aeroporto FOREIGN KEY (fk_aeroporto) REFERENCES tb_aeroporto(codigoiata)
);