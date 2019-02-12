CREATE TABLE "sj_sis_tip_cent" (
"tipc_id" serial NOT NULL,
"tipc_nombre" varchar(100),
"tipc_estador" bool,
PRIMARY KEY ("tipc_id") 
);

COMMENT ON COLUMN "sj_sis_tip_cent"."tipc_id" IS 'Identificador del tipo de centro';
COMMENT ON COLUMN "sj_sis_tip_cent"."tipc_nombre" IS 'Especificacion del centro CAIS CDP CRS  etc.';
COMMENT ON COLUMN "sj_sis_tip_cent"."tipc_estador" IS 'verificador para ver si el tipo de  centro esta activado o desactivado';

CREATE TABLE "sj_sis_centro" (
"cent_id" serial NOT NULL,
"cent_nombre" varchar(100),
"cent_fono" varchar(15),
"cent_direccion" varchar(100),
"cent_longitud" float8,
"cent_latitud" float8,
"pol_provincia" int4,
"pol_caton" int4,
"pol_parroquia" int4,
"tipc_id" int4,
PRIMARY KEY ("cent_id") 
);

COMMENT ON COLUMN "sj_sis_centro"."cent_id" IS 'Identificador del centro ';
COMMENT ON COLUMN "sj_sis_centro"."cent_nombre" IS 'nombre del centro';
COMMENT ON COLUMN "sj_sis_centro"."cent_fono" IS 'Telefono del centro';
COMMENT ON COLUMN "sj_sis_centro"."cent_direccion" IS 'Direccion del centro ';
COMMENT ON COLUMN "sj_sis_centro"."cent_longitud" IS 'longitud del centro ';
COMMENT ON COLUMN "sj_sis_centro"."cent_latitud" IS 'latitud del centro';
COMMENT ON COLUMN "sj_sis_centro"."pol_provincia" IS 'identificado de la provincia del centro';
COMMENT ON COLUMN "sj_sis_centro"."pol_caton" IS 'identificado de la canton del centro';
COMMENT ON COLUMN "sj_sis_centro"."pol_parroquia" IS 'identificado de la parroquia del centro';
COMMENT ON COLUMN "sj_sis_centro"."tipc_id" IS 'identificado del  tipo de centro';

CREATE TABLE "sj_sis_usuario" (
"usu_id" serial NOT NULL,
"usu_usuario" varchar(20),
"usu_clave" varchar(200),
"usu_estado" bool,
"per_id" int4,
PRIMARY KEY ("usu_id") 
);

COMMENT ON COLUMN "sj_sis_usuario"."usu_id" IS 'Identificador del usuarios';
COMMENT ON COLUMN "sj_sis_usuario"."usu_usuario" IS 'Identificador del usuario para ingresar al sistema';
COMMENT ON COLUMN "sj_sis_usuario"."usu_clave" IS 'Password del usuario en MD%';
COMMENT ON COLUMN "sj_sis_usuario"."usu_estado" IS 'etsdo de activacion o desactivacion del usuario';
COMMENT ON COLUMN "sj_sis_usuario"."per_id" IS 'identificador de la persona';

CREATE TABLE "sj_sis_persona" (
"per_id" serial NOT NULL,
"per_nombres" varchar(100),
"per_apellidos" varchar(100),
"per_direccion" varchar(150),
"per_fecnac" date,
"per_fono" varchar(10),
"per_celular" varchar(13),
"per_email" varchar(50),
"per_estado" bool,
"per_identificador" varchar(15),
"tipd_id" int4,
"foto_id" int4,
"civ_id" int4,
"pol_provincia" int4,
"pol_canton" int4,
"pol_parroquia" int4,
"sex_id" int4,
"gen_id" int4,
PRIMARY KEY ("per_id") 
);

COMMENT ON COLUMN "sj_sis_persona"."per_id" IS 'Identificador de las personas';
COMMENT ON COLUMN "sj_sis_persona"."per_nombres" IS 'Nombres del integrante del sistema';
COMMENT ON COLUMN "sj_sis_persona"."per_apellidos" IS 'Apellidos del integrante del sistema';
COMMENT ON COLUMN "sj_sis_persona"."per_direccion" IS 'Direcciond del integrante del sistema';
COMMENT ON COLUMN "sj_sis_persona"."per_fecnac" IS 'Fecha de nacimiento del integrante del sistema';
COMMENT ON COLUMN "sj_sis_persona"."per_fono" IS 'Telefono de del integrante del sistema';
COMMENT ON COLUMN "sj_sis_persona"."per_celular" IS 'Celular del integrante del sistema ';
COMMENT ON COLUMN "sj_sis_persona"."per_estado" IS 'estado activo o desactivado del integrante del sistema';
COMMENT ON COLUMN "sj_sis_persona"."per_identificador" IS 'Numeor de cedula o passaporte del integrante del sistema';
COMMENT ON COLUMN "sj_sis_persona"."tipd_id" IS 'Tipo de cedula o passaporte del integrante del sistema';
COMMENT ON COLUMN "sj_sis_persona"."foto_id" IS 'fotos del del integrante del sistema';
COMMENT ON COLUMN "sj_sis_persona"."civ_id" IS 'Estado civil del integrante del sistema';
COMMENT ON COLUMN "sj_sis_persona"."pol_provincia" IS 'Provincia del integrante del sistema';
COMMENT ON COLUMN "sj_sis_persona"."pol_canton" IS 'Canton del integrante del sistema';
COMMENT ON COLUMN "sj_sis_persona"."pol_parroquia" IS 'Parroquia del integrante del sistema';
COMMENT ON COLUMN "sj_sis_persona"."sex_id" IS 'identificador del sexo';
COMMENT ON COLUMN "sj_sis_persona"."gen_id" IS 'identificador del genero';

CREATE TABLE "sj_sis_rol" (
"rol_id" serial NOT NULL,
"rol_nombre" varchar(50),
"rol_estado" bool,
PRIMARY KEY ("rol_id") 
);

COMMENT ON COLUMN "sj_sis_rol"."rol_id" IS 'Identificadr para el rol';
COMMENT ON COLUMN "sj_sis_rol"."rol_nombre" IS 'Descripcion del rol';
COMMENT ON COLUMN "sj_sis_rol"."rol_estado" IS 'Estado del rol ';

CREATE TABLE "sj_sis_rol_men_usu_cen" (
"rmuc_id" serial NOT NULL,
"rmuc_estado" bool,
"rmuc_determinado" int,
"rol_id" int4,
"men_id" int4,
"usu_id" int4,
"cent_id" int4,
PRIMARY KEY ("rmuc_id") 
);

COMMENT ON COLUMN "sj_sis_rol_men_usu_cen"."rmuc_id" IS 'Identificado del rol menu usuario y centro';
COMMENT ON COLUMN "sj_sis_rol_men_usu_cen"."rmuc_estado" IS 'estado del rmuc';
COMMENT ON COLUMN "sj_sis_rol_men_usu_cen"."rmuc_determinado" IS 'determinado del del rmuc';
COMMENT ON COLUMN "sj_sis_rol_men_usu_cen"."rol_id" IS 'rol del del rmuc';
COMMENT ON COLUMN "sj_sis_rol_men_usu_cen"."men_id" IS 'menu del rmuc';
COMMENT ON COLUMN "sj_sis_rol_men_usu_cen"."usu_id" IS 'usuario del rmuc';
COMMENT ON COLUMN "sj_sis_rol_men_usu_cen"."cent_id" IS 'centro del del rmuc';

CREATE TABLE "sj_sis_menu" (
"men_id" serial NOT NULL,
"men_nombre" varchar(50),
"men_url" varchar(100),
"men_padre" int4,
PRIMARY KEY ("men_id") 
);

COMMENT ON COLUMN "sj_sis_menu"."men_id" IS 'Identificador del menu';
COMMENT ON COLUMN "sj_sis_menu"."men_nombre" IS 'Nombre del menu';
COMMENT ON COLUMN "sj_sis_menu"."men_url" IS 'direccion del menu';
COMMENT ON COLUMN "sj_sis_menu"."men_padre" IS 'padre del menu';

CREATE TABLE "sj_sis_civil" (
"civ_id" serial NOT NULL,
"civ_nombre" varchar(10),
PRIMARY KEY ("civ_id") 
);

COMMENT ON COLUMN "sj_sis_civil"."civ_id" IS 'identificador del estado civil';
COMMENT ON COLUMN "sj_sis_civil"."civ_nombre" IS 'descripcion del estado';

CREATE TABLE "sj_sis_sexo" (
"sex_id" serial NOT NULL,
"sex_nombre" varchar,
PRIMARY KEY ("sex_id") 
);

COMMENT ON COLUMN "sj_sis_sexo"."sex_id" IS 'identificador del sex genero';
COMMENT ON COLUMN "sj_sis_sexo"."sex_nombre" IS 'Descripcion del sex genero';

CREATE TABLE "sj_sis_foto" (
"fotos_id" serial NOT NULL,
"foto_url" varchar(100),
"foto_estado" bool,
"foto_predefinido" int,
"per_id" int4,
PRIMARY KEY ("fotos_id") 
);

COMMENT ON COLUMN "sj_sis_foto"."fotos_id" IS 'identificador de la foto';
COMMENT ON COLUMN "sj_sis_foto"."foto_url" IS 'direccion de la ubicacion de la foto';
COMMENT ON COLUMN "sj_sis_foto"."foto_estado" IS 'estado de la foto';
COMMENT ON COLUMN "sj_sis_foto"."foto_predefinido" IS 'foto predeterminada';
COMMENT ON COLUMN "sj_sis_foto"."per_id" IS 'Identificador de la persona';

CREATE TABLE "sj_sis_tip_documento" (
"tipd_id" serial NOT NULL,
"tipd_nombre" varchar(50),
PRIMARY KEY ("tipd_id") 
);

COMMENT ON COLUMN "sj_sis_tip_documento"."tipd_id" IS 'identificador del tipo de documento';
COMMENT ON COLUMN "sj_sis_tip_documento"."tipd_nombre" IS 'clasificacion del tipo de documento cedula pasaporte etc';

CREATE TABLE "sj_sis_log" (
"log_id" serial NOT NULL,
"log_fecha" date,
"log_usuario" varchar(50),
"log_ip" varchar(20),
"log_observaciones" varchar(255),
"log_accion" varchar(50),
"log_tabla" varchar(50),
PRIMARY KEY ("log_id") 
);

COMMENT ON COLUMN "sj_sis_log"."log_id" IS 'identificador del log';
COMMENT ON COLUMN "sj_sis_log"."log_fecha" IS 'fecha del creacion del log';
COMMENT ON COLUMN "sj_sis_log"."log_usuario" IS 'usuario  que realizo el cambio';
COMMENT ON COLUMN "sj_sis_log"."log_ip" IS 'ip desde donde se realizo el cambio';
COMMENT ON COLUMN "sj_sis_log"."log_observaciones" IS 'observaciones del cambio realizado';
COMMENT ON COLUMN "sj_sis_log"."log_accion" IS 'lo ejecutado el el campo';
COMMENT ON COLUMN "sj_sis_log"."log_tabla" IS 'tabla donde se realizo el cambio';

CREATE TABLE "sj_sis_div_politica" (
"pol_id" serial NOT NULL,
"pol_zona" int,
"pol_distrito" int,
"pol_circuito" int,
"pol_id_provincia" int,
"pol_id_canton" int,
"pol_id_parroquia" int,
"pol_nombre" varchar(100),
"pol_activo" int,
PRIMARY KEY ("pol_id") 
);

COMMENT ON COLUMN "sj_sis_div_politica"."pol_id" IS 'Identificador de  divicion politica';
COMMENT ON COLUMN "sj_sis_div_politica"."pol_zona" IS 'Zona a la que pertenece';
COMMENT ON COLUMN "sj_sis_div_politica"."pol_distrito" IS 'Distrito al que pertenece';
COMMENT ON COLUMN "sj_sis_div_politica"."pol_circuito" IS 'Circuito al que pertenece';
COMMENT ON COLUMN "sj_sis_div_politica"."pol_id_provincia" IS 'Identificador de la provincia';
COMMENT ON COLUMN "sj_sis_div_politica"."pol_id_canton" IS 'iIentificador del canton';
COMMENT ON COLUMN "sj_sis_div_politica"."pol_id_parroquia" IS 'Identificador de la parroquia';
COMMENT ON COLUMN "sj_sis_div_politica"."pol_nombre" IS 'nombre de la provincia  canto parroquia';
COMMENT ON COLUMN "sj_sis_div_politica"."pol_activo" IS 'Verificador si esta activo o no la provincia';

CREATE TABLE "sj_sis_genero" (
"gen_id" serial NOT NULL,
"gen_nombre" varchar(20),
PRIMARY KEY ("gen_id") 
);

COMMENT ON COLUMN "sj_sis_genero"."gen_id" IS 'identificador del genero';
COMMENT ON COLUMN "sj_sis_genero"."gen_nombre" IS 'nombre del genero';


ALTER TABLE "sj_sis_usuario" ADD CONSTRAINT "fk_sj_sis_usuario_sj_sis_usuario_1" FOREIGN KEY ("per_id") REFERENCES "sj_sis_persona" ("per_id");
ALTER TABLE "sj_sis_rol_men_usu_cen" ADD CONSTRAINT "fk_sj_sis_rol_men_usu_cen_sj_sis_rol_men_usu_cen_1" FOREIGN KEY ("men_id") REFERENCES "sj_sis_menu" ("men_id");
ALTER TABLE "sj_sis_centro" ADD CONSTRAINT "fk_sj_sis_centro_sj_sis_centro_2" FOREIGN KEY ("tipc_id") REFERENCES "sj_sis_tip_cent" ("tipc_id");
ALTER TABLE "sj_sis_rol_men_usu_cen" ADD CONSTRAINT "fk_sj_sis_rol_men_usu_cen_sj_sis_rol_men_usu_cen_3" FOREIGN KEY ("usu_id") REFERENCES "sj_sis_usuario" ("usu_id");
ALTER TABLE "sj_sis_rol_men_usu_cen" ADD CONSTRAINT "fk_sj_sis_rol_men_usu_cen_sj_sis_rol_men_usu_cen_2" FOREIGN KEY ("rol_id") REFERENCES "sj_sis_rol" ("rol_id");
ALTER TABLE "sj_sis_persona" ADD CONSTRAINT "fk_sj_sis_persona_sj_sis_persona_1" FOREIGN KEY ("civ_id") REFERENCES "sj_sis_civil" ("civ_id");
ALTER TABLE "sj_sis_foto" ADD CONSTRAINT "fk_sj_sis_foto_sj_sis_foto_1" FOREIGN KEY ("per_id") REFERENCES "sj_sis_persona" ("per_id");
ALTER TABLE "sj_sis_rol_men_usu_cen" ADD CONSTRAINT "fk_sj_sis_rol_men_usu_cen_sj_sis_rol_men_usu_cen_4" FOREIGN KEY ("cent_id") REFERENCES "sj_sis_centro" ("cent_id");
ALTER TABLE "sj_sis_persona" ADD CONSTRAINT "fk_sj_sis_persona_sj_sis_persona_2" FOREIGN KEY ("tipd_id") REFERENCES "sj_sis_tip_documento" ("tipd_id");
ALTER TABLE "sj_sis_persona" ADD CONSTRAINT "fk_sj_sis_persona_sj_sis_persona_3" FOREIGN KEY ("sex_id") REFERENCES "sj_sis_sexo" ("sex_id");
ALTER TABLE "sj_sis_centro" ADD CONSTRAINT "fk_sj_sis_centro_sj_sis_centro_5" FOREIGN KEY ("pol_parroquia") REFERENCES "sj_sis_div_politica" ("pol_id");
ALTER TABLE "sj_sis_centro" ADD CONSTRAINT "fk_sj_sis_centro_sj_sis_centro_4" FOREIGN KEY ("pol_caton") REFERENCES "sj_sis_div_politica" ("pol_id");
ALTER TABLE "sj_sis_centro" ADD CONSTRAINT "fk_sj_sis_centro_sj_sis_centro_3" FOREIGN KEY ("pol_provincia") REFERENCES "sj_sis_div_politica" ("pol_id");
ALTER TABLE "sj_sis_persona" ADD CONSTRAINT "fk_sj_sis_persona_sj_sis_persona_4" FOREIGN KEY ("gen_id") REFERENCES "sj_sis_genero" ("gen_id");

