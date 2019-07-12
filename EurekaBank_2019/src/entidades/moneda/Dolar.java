/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.moneda;

/**
 *
 * @author adriana
 */
public class Dolar implements MonedaBuilder {

    public static final float interesMensual = 0.60f;
    public static final float costoMovimiento = 0.60f;
    public static final float mantenimiento = 2.50f;
     public static final String codigo="01";

    private Moneda moneda;

    public Dolar() {
        moneda = new Moneda();
    }

    @Override
    public MonedaBuilder buildInteresMensaual() {

        moneda.setInteres_mensual(Dolar.interesMensual);
        return this;
    }

    @Override
    public MonedaBuilder buildCostoMovimiento() {

        moneda.setCosto_movimiento(Dolar.costoMovimiento);
        return this;
    }

    @Override
    public MonedaBuilder buildMantenimiento() {

        moneda.setCargo_mantenimiento(Dolar.mantenimiento);
        return this;
    }

    @Override
    public MonedaBuilder buildDescripcion(String descripcion) {
        moneda.setDescripcion(descripcion);
        return this;
    }

    @Override
    public Moneda build() {
        return moneda;
    }

    @Override
    public MonedaBuilder buildCodigoMoneda() {
        moneda.setCodigo(Dolar.codigo);
        return this;
    }

}
