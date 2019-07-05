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
public class Cliente extends Persona {
    private String codigo;
    private ArrayList<RealCuenta> cuenta;
    private String dni;
    private String telefono;
    private String email;

    public Cliente(String codigo,ArrayList<RealCuenta> cuenta, String dni, String telefono, String email, String paterno, String materno, String nombre, String ciudad, String direccion) {
        super(paterno, materno, nombre, ciudad, direccion);
        this.codigo=codigo;
        this.cuenta = cuenta;
        this.dni = dni;
        this.telefono = telefono;
        this.email = email;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    
    public ArrayList<RealCuenta> getCuenta() {
        return cuenta;
    }

    public void setCuenta(ArrayList<RealCuenta> cuenta) {
        this.cuenta = cuenta;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return super.toString()+ " -> Cliente{" + "cuenta=" + cuenta + ", dni=" + dni + ", telefono=" + telefono + ", email=" + email + '}';
    }
    

}
