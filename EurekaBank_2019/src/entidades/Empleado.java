/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import entidades.movimiento.Movimiento;
import entidades.cuenta.RealCuenta;
import java.util.ArrayList;

/**
 *
 * @author adriana
 */
public class Empleado extends Persona {

    private String codigo;
    private ArrayList<Movimiento> movimientos;
    private RealCuenta cuenta;
    private String usuario;
    private String clave;

    public Empleado() {
        this.movimientos = new ArrayList<Movimiento>();        
    }

    public Empleado(ArrayList<Movimiento> movimientos, RealCuenta cuenta, String usuario, String clave, String paterno,
            String materno, String nombre, String ciudad, String direccion) {
        super(paterno, materno, nombre, ciudad, direccion);
        this.codigo = codigo;
        this.usuario = usuario;
        this.clave = clave;
        this.cuenta = cuenta;
        this.movimientos = (movimientos == null) ? new ArrayList<Movimiento>() : movimientos;

    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public ArrayList<Movimiento> getMovimientos() {
        return this.movimientos;
    }

    public void setMovimientos(ArrayList<Movimiento> movimientos) {
        this.movimientos = movimientos;

    }

    public void addMovimiento(Movimiento movimiento) {
        movimientos.add(movimiento);

    }

    public RealCuenta getCuenta() {
        return this.cuenta;
    }

    public void setCuenta(RealCuenta cuenta) {
        this.cuenta = cuenta;

    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public String toString() {
        return super.toString() + " -> Empleado{" + "usuario=" + usuario + ", clave=" + clave + '}';
    }

}
