-- 1 Informar quienes (nombre,apellido) compraron 'up'.
select c.nombre, c.apellido, a.marca, a.modelo
	from clientes c join autos a on c.codigo=a.codigo
    where a.modelo like '%up%';
    
-- 2 Informar la lista de autos vendidos el día de hoy.
select a.codigo, a.marca, a.precio, f.fecha
	from facturas f join autos a on f.codigocliente=a.codigo
    join clientes c on c.codigo=a.codigo
    where fecha=curdate();
    
-- 3- Informar que auto compro 'maestro splinter'.
select c.codigo, c.nombre,c.apellido, a.marca,a.modelo
	from clientes c join facturas f on c.codigo=f.codigoCliente
	join autos a on f.codigocliente=a.codigo 
	where c.nombre='maestro' and c.apellido='splinter';

-- 4- Informar la lista de artículos vendidos en este mes.
select  f.numero, f.fecha, f.monto, a.marca,a.modelo
	from facturas f join autos a on f.codigocliente=a.codigo	
    where month(fecha)=month(curdate())
	and year(fecha)=year(curdate());
    
-- 5- Informar la suma de los montos de cada cliente (código,nombre,apellido,total_comprado)
select c.codigo, c.nombre, c.apellido, sum(a.precio) total 
	from clientes c join facturas f on c.codigo=f.codigoCliente
    join autos a on f.codigocliente=a.codigo
    group by c.codigo;