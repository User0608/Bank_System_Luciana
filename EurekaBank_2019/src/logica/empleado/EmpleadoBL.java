/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.empleado;

import datos.empleado.EmpleadoDAL;
import entidades.Empleado;
import entidades.Persona;
import java.util.ArrayList;

/**
 *
 * @author adriana
 */
public class EmpleadoBL {

    private EmpleadoDAL empleado_dal;

    public EmpleadoBL() {
        empleado_dal = new EmpleadoDAL();
    }

    private boolean validarPersona(Persona persona) {
        if (persona.getPaterno().length() > 0 && persona.getMaterno().length() > 0
                && persona.getNombre().length() > 0 && persona.getDireccion().length() > 5
                && persona.getCiudad().length() > 0) {
            return true;
        }
        return false;
    }

    public String insertar(Empleado empleado) {
        String mensaje = "Error en los datos";
        if (empleado.getCodigo().length() == 4 && this.validarPersona(empleado)
                && empleado.getUsuario().length() > 6 && empleado.getUsuario().length() > 6) {
            mensaje = empleado_dal.insertar(empleado);
        }
        return mensaje;
    }

    public String buscar(String codigo) {
        if (codigo.length() == 4) {
            return empleado_dal.buscar(codigo);
        }
        return null;
    }

    public String actualizar(Empleado empleado) {
        String mensaje = "Error en los datos";
        if (empleado.getCodigo().length() == 4 && this.validarPersona(empleado)
                && empleado.getUsuario().length() > 6 && empleado.getUsuario().length() > 6) {
            mensaje = empleado_dal.actualizar(empleado);
        }
        return mensaje;
    }

    public Empleado getEmpleado(String codigo) {
        if (codigo.length() == 4) {
            return empleado_dal.getEmpleado(codigo);
        }
        return null;
    }

    public ArrayList<Empleado> listar() {
        return empleado_dal.listar();
    }

    public String Eliminar(String codigo) {
        String mensaje = "Error en los datos";
        if (codigo.length() == 4) {
            mensaje = empleado_dal.eliminar(codigo);
        }
        return mensaje;
    }
}
