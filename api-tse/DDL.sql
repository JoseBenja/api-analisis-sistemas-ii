CREATE TABLE tse.catalogo (
                              id_catag serial4 NOT NULL,
                              tipo varchar(20) NOT NULL,
                              estado bool NOT NULL DEFAULT true,
                              codigo varchar(5) NOT NULL,
                              nombre varchar(100) NOT NULL,
                              referencia_id_catag int4 NULL,
                              CONSTRAINT catalogo_pkey PRIMARY KEY (id_catag),
                              CONSTRAINT fk_id_catag_catalogo FOREIGN KEY (referencia_id_catag) REFERENCES tse.catalogo(id_catag)
);

CREATE TABLE tse.votante (
                             no_empadronado int4 NOT NULL DEFAULT nextval('tse.votante_no_empradonado_seq'::regclass),
                             cui varchar(13) NOT NULL,
                             municipio int4 NOT NULL,
                             direccion varchar(100) NOT NULL,
                             CONSTRAINT votante_pkey PRIMARY KEY (no_empadronado)
);


-- tse.votante foreign keys

ALTER TABLE tse.votante ADD CONSTRAINT fk_municipio_catalogo FOREIGN KEY (municipio) REFERENCES tse.catalogo(id_catag);