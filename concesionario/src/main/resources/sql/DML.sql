describe clientes;

insert into clientes (codigo,nombre,apellido,dni) values (1,'leon','o','xxxxx');
insert into clientes (codigo,nombre,apellido,dni) values (2,'seiya','pegaso','xxxxx');
insert into clientes (codigo,nombre,apellido,dni) values (3,'elgokus','vegita','xxxxx');
insert into clientes (codigo,nombre,apellido,dni) values (4,'maestro','splinter','xxxxx');
insert into clientes (codigo,nombre,apellido,dni) values (5,'peter','venkman','xxxxx');

describe facturas;

insert into facturas values ('a',0001,curdate(),500,1);
insert into facturas values ('a',0002,curdate(),2500,2);
insert into facturas values ('b',0003,curdate(),320,3);
insert into facturas values ('b',0004,curdate(),120,4);
insert into facturas values ('b',0005,curdate(),560,5);

describe autos;

insert into autos values (1,'volkswagen','up',2000000,15444);
insert into autos values (2,'volkswagen','gol',1000000,88888);
insert into autos values (3,'renault','clio',3000000,999999);
insert into autos values (4,'fiat','brios',500000,7777);
insert into autos values (5,'renault','12',200000,123456);