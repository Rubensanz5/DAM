create database New_Patch_LoL;
use New_Patch_LoL ;

create table campeones(
id int IDENTITY(1,1) primary key,
nombre varchar(25),
rol varchar(25),
fecha date	
);

create table habilidades(
id int primary key references campeones(id) on delete cascade,
habilidad1 varchar(25),
habilidad2 varchar(25),
habilidad3 varchar(25),
habilidad4 varchar(25),
habilidad5 varchar(25)
);

create table summoners(
id int primary key references campeones(id) on delete cascade,
summoner1 varchar(25),
summoner2 varchar(25)
);


insert into campeones values ('KaiSa', 'Botton', '07/03/2018');
insert into campeones values ('Vi', 'Jungle', '19/12/2012');
insert into campeones values ('Garen', 'Top', '27/04/2010');
insert into campeones values ('Zoe', 'Mid', '21/11/2017');
insert into campeones values ('Leona', 'Support', '13/07/2011');

insert into habilidades values (1,'Segunda piel','Lluvia de Icathia','Buscador de Vacío','Supercarga','Instinto asesino');
insert into habilidades values (2,'Escudo Explosivo','Rompebóvedas','Golpes Abollantes','Fuerza Excesiva','Asalto y Lesiones');
insert into habilidades values (3,'Perseverancia','Golpe Decisivo','Coraje','Juicio','Justicia Demaciana');
insert into habilidades values (4,'¡Mas Chispas!','Estrella Saltarina','Ladrona de Hechizos','Burbuja Dormilona','Salto de Portal');
insert into habilidades values (5,'Luz Solar','Escudo del Amanecer','Eclipse','Espada del Cénit','Llamarada Solar');

insert into summoners values (1,'Destello','Curar');
insert into summoners values (2,'Destello','Aplastar');
insert into summoners values (3,'Teleportar','Destello');
insert into summoners values (4,'Destello','Quemar');
insert into summoners values (5,'Destello','Curar');





