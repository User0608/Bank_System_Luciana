CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertarCuenta`(p_cuencodigo char(8),p_monecodigo char(2),p_sucucodigo char(3),
p_emplcreacuenta char(4),p_cliecodigo char(5),p_cuensaldo decimal(12,2),p_cuenfechacreacion date,
p_cuenclave char(6))
BEGIN
	insert into Cuenta(cuencodigo,monecodigo,sucucodigo,emplcreacuenta,cliecodigo,cuensaldo,cuenfechacreacion,
				cuencontmov,cuenclave) 
			values(p_cuencodigo,p_monecodigo,p_sucucodigo,p_emplcreacuenta,p_cliecodigo,p_cuensaldo,p_cuenfechacreacion,
				0,p_cuenclave);
END