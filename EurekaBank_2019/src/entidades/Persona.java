/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author adriana
 */
public class Persona {
    private String paterno;
    private String materno;
    private String nombre;
    private String ciudad;
    private String direccion;
    
    public Persona(){
        
    }
    public Persona(String paterno, String materno, String nombre, String ciudad, String direccion) {
        this.paterno = paterno;
        this.materno = materno;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.direccion = direccion;
    }
    
    

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
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

    @Override
    public String toString() {
        return "Persona{" + "paterno=" + paterno + ", materno=" + materno + ", nombre=" + nombre + ", ciudad=" + ciudad + ", direccion=" + direccion + '}';
    }
    
    
}
