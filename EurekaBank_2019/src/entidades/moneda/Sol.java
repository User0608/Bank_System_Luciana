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
public class Sol implements MonedaBuilder {

    public static final float interesMensual = 0.7f;
    public static final float costoMovimiento = 2.00f;
    public static final float mantenimiento = 7.00f;
    public static final String codigo = "01";

    private Moneda moneda;

    public Sol() {
        moneda = new Moneda();
    }

    @Override
    public MonedaBuilder buildCodigoMoneda() {
        moneda.setCodigo(Sol.codigo);
        return this;
    }

    @Override
    public MonedaBuilder buildInteresMensaual() {

        moneda.setInteres_mensual(Sol.interesMensual);
        return this;
    }

    @Override
    public MonedaBuilder buildCostoMovimiento() {

        moneda.setCosto_movimiento(Sol.costoMovimiento);
        return this;
    }

    @Override
    public MonedaBuilder buildMantenimiento() {

        moneda.setCargo_mantenimiento(Sol.mantenimiento);
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

}
