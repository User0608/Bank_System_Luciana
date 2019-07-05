CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_eliminarEmpleado`(p_codigo char(4))
BEGIN
	update Empleado set emplestado=0 where emplcodigo=p_codigo;
END