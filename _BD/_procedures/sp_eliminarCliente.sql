CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_eliminarCliente`(p_codigo char(5))
BEGIN
	update Cliente set clieestado=0 where cliecodigo=p_codigo;
END