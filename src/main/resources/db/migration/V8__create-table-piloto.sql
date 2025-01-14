CREATE TABLE tb_piloto (
    id_piloto BIGSERIAL PRIMARY KEY,
    horas_de_voo INT NOT NULL CHECK (horas_de_voo >= 0),
    nome VARCHAR(50) NOT NULL,
    status_de_saude VARCHAR(20) NOT NULL CHECK (status_de_saude IN ('APTO', 'INAPTO', 'EM_RECUPERACAO')),
    fk_licenca_de_pilotoanac BIGINT NOT NULL UNIQUE,
    CONSTRAINT fk_piloto_licenca FOREIGN KEY (fk_licenca_de_pilotoanac) REFERENCES tb_licenca_de_piloto_anac(numero_da_licenca)
);
