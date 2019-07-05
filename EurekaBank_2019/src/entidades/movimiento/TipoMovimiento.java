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
    private String descripcion;
    private String accion;
    private String estado;

    public TipoMovimiento(String descripcion, String accion, String estado) {
        this.descripcion = descripcion;
        this.accion = accion;
        this.estado = estado;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "TipoMovimiento{" + "descripcion=" + descripcion + ", accion=" + accion + ", estado=" + estado + '}';
    }
    
    
    
}
