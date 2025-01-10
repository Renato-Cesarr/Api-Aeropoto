CREATE TABLE TB_PILOTO (
    idPiloto SERIAL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    fk_LicencaDePilotoANAC INTEGER NOT NULL,
    horasDeVoo INTEGER NOT NULL CHECK (horasDeVoo >= 0),
    statusDeSaude VARCHAR(20) NOT NULL CHECK (statusDeSaude IN ('APTO', 'INAPTO', 'EM_RECUPERACAO')),
    FOREIGN KEY (fk_LicencaDePilotoANAC) REFERENCES LicencaDePilotoANAC(idLicencaDePilotoANAC)
);
