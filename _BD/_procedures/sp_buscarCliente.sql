CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_buscarCliente`(p_codigo char(5))
BEGIN
	select * from Cliente where cliecodigo=p_codigo;
END