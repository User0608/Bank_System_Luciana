/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import entidades.cuenta.RealCuenta;
import java.util.ArrayList;

/**
 *
 * @author adriana
 */
public class Sucursal {

    private String codigo;
    private String nombre;
    private String ciudad;
    private String direccion;
    private ArrayList<RealCuenta> cuentas;
    private ArrayList<Empleado> empleados;
    
    public Sucursal(){
        
    }
    public Sucursal(String codigo, String nombre, String ciudad, String direccion, ArrayList<RealCuenta> cuentas, ArrayList<Empleado> empleados) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.cuentas = cuentas;
        this.empleados = empleados;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<RealCuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(ArrayList<RealCuenta> cuentas) {
        this.cuentas = cuentas;
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }

    @Override
    public String toString() {
        return "Sucursal{" + "nombre=" + nombre + ", ciudad=" + ciudad + ", direccion=" + direccion + ", cuentas=" + cuentas + ", empleados=" + empleados + '}';
    }

}
