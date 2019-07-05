CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listarEmpleados`()
BEGIN
	select * from Empleado where emplestado=1;
END