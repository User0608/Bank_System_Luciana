CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_buscarEmpleado`(p_codigo char(4))
BEGIN
	select * from Empleado where emplcodigo = p_codigo;
END