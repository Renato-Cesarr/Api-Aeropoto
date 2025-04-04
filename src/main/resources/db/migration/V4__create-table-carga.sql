CREATE TABLE tb_carga (
    numero_identificador_carga BIGSERIAL PRIMARY KEY,
    peso_total_carga FLOAT8,
    status_da_carga VARCHAR(25) CHECK (status_da_carga IN ('EM_PROCESSO', 'ENTREGUE', 'PENDENTE')),
    tipo_de_carga_ticket_da_carga BIGINT,
    CONSTRAINT fk_carga_tipo_carga FOREIGN KEY (tipo_de_carga_ticket_da_carga) REFERENCES tb_tipo_de_carga(ticket_da_carga)
);