drop database if exists concesionario;
create database concesionario;
use concesionario;

create table clientes (
codigo integer auto_increment,
nombre varchar(20) not null,
apellido varchar(20) not null,
dni char(8),
primary key (codigo)
);

create table facturas(
letra char(1),
numero integer,
fecha date,
monto double,
codigocliente integer not null,
constraint FK_facturas_codcli
foreign key (codigocliente)
references clientes(codigo)
on delete cascade,
primary key (letra,numero)
);

create table autos(
codigo integer auto_increment,
marca varchar(20),
modelo varchar(20),
precio double,
codigocliente integer not null,
constraint FK_autos_codcli
foreign key (codigo)
references clientes(codigo)
on delete cascade,
primary key (codigo)

);