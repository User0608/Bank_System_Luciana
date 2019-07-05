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
public class Moneda {   
    private float interes_mensual;
    private float costo_movimiento;
    private float cargo_mantenimiento;
    private String descripcion;
  
    public float getInteres_mensual() {
        return interes_mensual;
    }

    public void setInteres_mensual(float interes_mensual) {
        this.interes_mensual = interes_mensual;
    }

    public float getCosto_movimiento() {
        return costo_movimiento;
    }

    public void setCosto_movimiento(float costo_movimiento) {
        this.costo_movimiento = costo_movimiento;
    }

    public float getCargo_mantenimiento() {
        return cargo_mantenimiento;
    }

    public void setCargo_mantenimiento(float cargo_mantenimiento) {
        this.cargo_mantenimiento = cargo_mantenimiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Moneda{" + "interes_mensual=" + interes_mensual + ", costo_movimiento=" + costo_movimiento + ", cargo_mantenimiento=" + cargo_mantenimiento + ", descripcion=" + descripcion + '}';
    }

}
