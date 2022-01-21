use pruebas;

drop table if exists empleados;
drop table if exists departamentos;


create table departamentos(
	depto_no int identity(1,1) primary key,
	dnombre varchar(15),
	loc varchar(15)
);

create table empleados(
	emp_no int identity(1,1) primary key,
	apellido varchar(15),
	oficio varchar(15),
	dir int,
	fecha_alt date,
	salario float,
	comision float,
	depto_no int references departamentos(depto_no)
);