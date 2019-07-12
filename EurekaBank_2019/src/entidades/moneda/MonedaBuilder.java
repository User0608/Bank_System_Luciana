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
public interface MonedaBuilder {

    MonedaBuilder buildCodigoMoneda();
    MonedaBuilder buildInteresMensaual();

    MonedaBuilder buildCostoMovimiento();

    MonedaBuilder buildMantenimiento();

    MonedaBuilder buildDescripcion(String descripcion);
    

    Moneda build();
}
