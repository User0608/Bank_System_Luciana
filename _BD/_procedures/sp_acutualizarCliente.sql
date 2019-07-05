CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_acutualizarCliente`(p_codigo char(5),p_paterno varchar(25),
p_materno varchar(25),p_nombre varchar(30),p_dni varchar(8),p_ciudad varchar(30),
p_direccion varchar(50),p_telefono varchar(20),p_email varchar(50))
BEGIN
update Cliente set cliecodigo=p_codigo,cliepaterno=p_paterno,cliematerno=p_materno,
				   clienombre=p_nombre,cliedni=p_dni,clieciudad=p_ciudad,cliedireccion=p_direccion,
                   clieemail=p_email 
                   where cliecodigo=p_codigo;
END