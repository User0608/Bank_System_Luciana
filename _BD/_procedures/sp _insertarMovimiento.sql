CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertarMovimiento`(p_cuencodigo char(8),p_movinumero int(11),p_movifecha date,
	 p_emplcodigo char(4),p_tipocodigo char(3),p_moviimporte decimal(12,2))
BEGIN
	insert into Movimiento(cuencodigo,movinumero,movifecha,emplcodigo,tipocodigo,moviimporte)
    values(p_cuencodigo,p_movinumero,p_movifecha,p_emplcodigo,p_tipocodigo,p_moviimporte);
END