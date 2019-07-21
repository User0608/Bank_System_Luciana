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
public class MonedaDirector {

    private MonedaBuilder builder;

    public MonedaDirector(MonedaBuilder builder) {
        this.builder = builder;
    }

    public Moneda construir() {
        String tipo = (this.builder instanceof Dolar) ? "Dolares" : "Soles";
        return builder.buildCostoMovimiento().buildDescripcion(tipo).buildInteresMensaual()
                .buildMantenimiento().buildDescripcion(tipo).buildCodigoMoneda().build();
    }
}
