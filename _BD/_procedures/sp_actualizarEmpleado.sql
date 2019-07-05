CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_actualizarEmpleado`(p_codigo char(4),p_paterno varchar(25),
				p_materno varchar(25),p_nombre varchar(30),p_ciudad varchar(30),
                p_direccion varchar(50),p_usuario varchar(15),p_clave varchar(15))
BEGIN
	update Empleado set emplcodigo=p_codigo,emplpaterno=p_paterno,emplmaterno=p_materno,
					  emplnombre=p_nombre,emplciudad=p_ciudad,empldireccion=p_direccion,
                      emplusuario=p_usuario,emplclave=p_clave 
	where emplcodigo=p_codigo;
END