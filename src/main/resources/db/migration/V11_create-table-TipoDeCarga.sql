CREATE TABLE TB_TIPO_DE_CARGA (
    ticketDaCarga INT PRIMARY KEY,
    categoriaCarga VARCHAR(25) NOT NULL,
    cargaFragil BOOLEAN,
    temperaturaDaCarga DOUBLE,
    classificacaoPericulosidade BOOLEAN NOT NULL
);
