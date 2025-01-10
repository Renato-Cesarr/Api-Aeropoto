CREATE TABLE tb_aviao (
    numero_de_serie INT PRIMARY KEY,
    capacidade_maxima_kg FLOAT8 NOT NULL,
    capacidade_maxima_pessoas INT NOT NULL,
    fabricante VARCHAR(50) NOT NULL,
    modelo VARCHAR(50) NOT NULL,
    fk_fly_aware INT NOT NULL UNIQUE,
    fk_piloto INT NOT NULL UNIQUE,
    fk_tripulacao INT NOT NULL UNIQUE,
    fk_aeroporto INT,
    CONSTRAINT fk_aviao_flyaware FOREIGN KEY (fk_fly_aware) REFERENCES tb_flwaware(id_rota),
    CONSTRAINT fk_aviao_piloto FOREIGN KEY (fk_piloto) REFERENCES tb_piloto(id_piloto),
    CONSTRAINT fk_aviao_tripulacao FOREIGN KEY (fk_tripulacao) REFERENCES tb_tripulacao(id_tripulacao),
    CONSTRAINT fk_aviao_aeroporto FOREIGN KEY (fk_aeroporto) REFERENCES tb_aeroporto(codigoiata)
);
