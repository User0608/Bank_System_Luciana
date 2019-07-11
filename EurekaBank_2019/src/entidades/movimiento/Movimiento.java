/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.movimiento;

import entidades.Empleado;
import entidades.cuenta.RealCuenta;
import java.sql.Date;

/**
 *
 * @author adriana
 */
public class Movimiento {

    private String codigo_tipo_movimiento;
    private Empleado empleado;
    private RealCuenta cuenta;
    private Date fecha;
    private int numero_movimiento;
    private double importe;

    public Movimiento() {

    }

    public Movimiento(String codigo_tipo_movimiento, Empleado empleado, RealCuenta cuenta, Date fecha, int numero_movimiento, double importe) {
        this.codigo_tipo_movimiento = codigo_tipo_movimiento;
        this.empleado = empleado;
        this.cuenta = cuenta;
        this.fecha = fecha;
        this.numero_movimiento = numero_movimiento;
        this.importe = importe;
    }

    public String getCodigo_tipo_movimiento() {
        return codigo_tipo_movimiento;
    }

    public void setCodigo_tipo_movimiento(String codigo_tipo_movimiento) {
        this.codigo_tipo_movimiento = codigo_tipo_movimiento;
    }


    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public RealCuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(RealCuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getNumero_movimiento() {
        return numero_movimiento;
    }

    public void setNumero_movimiento(int numero_movimiento) {
        this.numero_movimiento = numero_movimiento;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    @Override
    public String toString() {
        return "Movimiento{" + "codigo_tipo_movimiento=" + codigo_tipo_movimiento + ", empleado=" + empleado + ", cuenta=" + cuenta + ", fecha=" + fecha + ", numero_movimiento=" + numero_movimiento + ", importe=" + importe + '}';
    }

   

}
