create schema sistema_votaciones;

--truncate table sistema_votaciones.tipo_catalogo restart identity cascade;


CREATE TABLE sistema_votaciones.usuario_voto (
    cui VARCHAR(13),
    empadronado BOOLEAN,
    fecha_votacion timestamp not null default current_timestamp,    
    constraint pk_usuario_voto primary key(cui)
);


create table sistema_votaciones.tipo_catalogo
(
	tipo_catalogo varchar(128)not null,
	fecha_creacion timestamp not null default CURRENT_TIMESTAMP,
	constraint pk_tipo_catalogos primary key(tipo_catalogo)
);


create table sistema_votaciones.catalogos
(
	nombre_catalogo varchar(255)not null,
	descripcion_catalogo varchar(255)not null default 'NA',
	fecha_creacion timestamp not null default current_timestamp,
	tipo_catalogo varchar(128)not null,
	constraint pk_catalogos primary key(nombre_catalogo)
);
 
alter table sistema_votaciones.catalogos add constraint fk_catalogos_tipo
foreign key(tipo_catalogo) references sistema_votaciones.tipo_catalogo(tipo_catalogo);


CREATE TABLE sistema_votaciones.candidatos (
    id SERIAL PRIMARY KEY,
    nombre_pres VARCHAR(100)not null,
    nombre_vice varchar(100),
    partido_politico VARCHAR(255),
    imagen_url VARCHAR(255),
    tipo_candidato varchar(255)not null
);

alter table sistema_votaciones.candidatos add constraint fk_candidatos_partidos
foreign key(partido_politico) references  sistema_votaciones.catalogos(nombre_catalogo);

alter table sistema_votaciones.candidatos add constraint fk_candidatos_tipo_candidatura
foreign key(tipo_candidato) references  sistema_votaciones.catalogos(nombre_catalogo);

alter table sistema_votaciones.candidatos add constraint fk_candidatos_catalogo_img
foreign key(imagen_url) references  sistema_votaciones.catalogos(nombre_catalogo);

CREATE TABLE sistema_votaciones.votos (
    id SERIAL PRIMARY KEY,
    cui_votante varchar(13) REFERENCES sistema_votaciones.usuario_voto(cui),
    presidente_id INTEGER REFERENCES sistema_votaciones.candidatos(id),
    alcalde_id INTEGER REFERENCES sistema_votaciones.candidatos(id),
    diputado_lista_id INTEGER REFERENCES sistema_votaciones.candidatos(id),
    diputado_distrito_id INTEGER REFERENCES sistema_votaciones.candidatos(id),
    parlacen_id INTEGER REFERENCES sistema_votaciones.candidatos(id),
    fecha_voto TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);