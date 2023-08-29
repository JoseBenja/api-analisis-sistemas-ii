CREATE SCHEMA renap AUTHORIZATION postgres;

CREATE TABLE renap.ciudadano (
	cui varchar(13) NOT NULL,
	primer_nombre varchar(25) NOT NULL,
	segundo_nombre varchar(25) NULL,
	primer_apellido varchar(25) NOT NULL,
	segundo_apellido varchar(25) NOT NULL,
	apellido_casada varchar(25) NULL,
	sexo varchar(1) NOT NULL,
	nacionalidad varchar(30) NOT NULL,
	pais_nacimiento int4 NOT NULL,
	fecha_nacimiento date NOT NULL,
	estado_civil varchar(5) NOT NULL,
	municipio int4 NOT NULL,
	direccion varchar(300) NOT NULL,
	fallecido bool NOT NULL DEFAULT false,
	etnia varchar(20) NOT NULL,
	analfabeta bool NOT NULL,
	idioma varchar(30) NOT NULL,
	discapacidad varchar(100) NULL,
	CONSTRAINT ciudadano_pkey PRIMARY KEY (cui)
);


-- renap.ciudadano foreign keys

ALTER TABLE renap.ciudadano ADD CONSTRAINT fk_muni_catalogo FOREIGN KEY (municipio) REFERENCES renap.catalogo(id_catag);
ALTER TABLE renap.ciudadano ADD CONSTRAINT fk_pais_nac_catalogo FOREIGN KEY (pais_nacimiento) REFERENCES renap.catalogo(id_catag);

CREATE TABLE renap.dpi (
                           id_dpi serial4 NOT NULL,
                           cui varchar(13) NOT NULL,
                           version_dpi int4 NOT NULL,
                           fecha_emision date NOT NULL,
                           activo bool NOT NULL DEFAULT false,
                           CONSTRAINT dpi_pkey PRIMARY KEY (id_dpi)
);


-- renap.dpi foreign keys

ALTER TABLE renap.dpi ADD CONSTRAINT fk_cui_dpi FOREIGN KEY (cui) REFERENCES renap.ciudadano(cui);

CREATE TABLE renap.catalogo (
                                id_catag serial4 NOT NULL,
                                tipo varchar(20) NOT NULL,
                                estado bool NOT NULL DEFAULT true,
                                codigo varchar(5) NOT NULL,
                                nombre varchar(100) NOT NULL,
                                referencia_id_catag int4 NULL,
                                CONSTRAINT catalogo_pkey PRIMARY KEY (id_catag),
                                CONSTRAINT fk_id_catag_catalogo FOREIGN KEY (referencia_id_catag) REFERENCES renap.catalogo(id_catag)
);