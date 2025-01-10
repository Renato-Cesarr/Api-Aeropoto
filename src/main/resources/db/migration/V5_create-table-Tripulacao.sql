CREATE TABLE TB_tripulacao (
    idTripulacao INTEGER PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    funcao VARCHAR(25) NOT NULL,
    numeroVoo INTEGER NOT NULL,
    licenciamento VARCHAR(25) NOT NULL,
    horasDeVoo INTEGER NOT NULL
);
