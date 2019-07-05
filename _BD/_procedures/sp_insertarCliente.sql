CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertarCliente`(p_codigo char(5),p_paterno varchar(25),
p_materno varchar(25),p_nombre varchar(30),p_dni varchar(8),p_ciudad varchar(30),
p_direccion varchar(50),p_telefono varchar(20),p_email varchar(50))
BEGIN
	insert into Cliente(cliecodigo,cliepaterno,cliematerno,clienombre,
					cliedni,clieciudad,cliedireccion,clietelefono,clieemail)
                    
		   values(p_codigo,p_paterno,p_materno,p_nombre,p_dni,p_ciudad,
					p_direccion,p_telefono,p_email);
END