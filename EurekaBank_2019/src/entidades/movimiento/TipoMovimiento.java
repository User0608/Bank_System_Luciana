/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.movimiento;

/**
 *
 * @author adriana
 */
public class TipoMovimiento {

    private String codigo;
    private String descripcion;
    private String accion;
    

    public TipoMovimiento(String codigo, String descripcion, String accion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.accion = accion;      
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

   

    @Override
    public String toString() {
        return "TipoMovimiento{" + "descripcion=" + descripcion + ", accion=" + accion + '}';
    }

}
