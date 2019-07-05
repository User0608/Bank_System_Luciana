CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listarClientes`()
BEGIN
	select * from Cliente where clieestado=1;
END