CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertarEmpleado`(p_codigo char(4),p_paterno varchar(25),
				p_materno varchar(25),p_nombre varchar(30),p_ciudad varchar(30),
                p_direccion varchar(50),p_usuario varchar(15),p_clave varchar(15))
BEGIN
	insert into Empleado(emplcodigo,emplpaterno,emplmaterno,emplnombre,
						emplciudad,empldireccion,emplusuario,emplclave)
		    values(p_codigo,p_paterno,p_materno,p_nombre,p_ciudad,p_direccion,
					p_usuario,p_clave);
END