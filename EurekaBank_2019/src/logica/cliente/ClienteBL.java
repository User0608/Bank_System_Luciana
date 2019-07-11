/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.cliente;

import datos.cliente.ClienteDAL;
import entidades.Cliente;
import entidades.Persona;
import java.util.ArrayList;

/**
 *
 * @author adriana
 */
public class ClienteBL {

    private ClienteDAL cliente_dal;

    public ClienteBL() {
        cliente_dal = new ClienteDAL();
    }

    private boolean validarPersona(Persona persona) {
        if (persona.getPaterno().length() > 0 && persona.getMaterno().length() > 0
                && persona.getNombre().length() > 0 && persona.getDireccion().length() > 5
                && persona.getCiudad().length() > 0) {
            return true;
        }
        return false;
    }

    public String insertar(Cliente cliente) {
        String mensaje = "Error en los datos";
        if (cliente.getCodigo().length() == 5 && this.validarPersona(cliente)
                && cliente.getDni().length() == 6 && cliente.getTelefono().length() > 5
                && cliente.getEmail().length() > 6) {
            mensaje = cliente_dal.insertar(cliente);
        }
        return mensaje;
    }

    public String buscar(String codigo) {
        if (codigo.length() == 5) {
            return cliente_dal.buscar(codigo);
        }
        return null;
    }

    public String actualizar(Cliente cliente) {
        String mensaje = "Error en los datos";
        if (cliente.getCodigo().length() == 5 && this.validarPersona(cliente)
                && cliente.getDni().length() == 6 && cliente.getTelefono().length() > 5
                && cliente.getEmail().length() > 6) {
            mensaje = cliente_dal.actualizar(cliente);
        }
        return mensaje;
    }

    public Cliente getCliente(String codigo) {
        if (codigo.length() == 5) {
            return cliente_dal.getCliente(codigo);
        }
        return null;
    }

    public ArrayList<Cliente> listar() {
        return cliente_dal.listar();
    }

    public String Eliminar(String codigo) {
        String mensaje = "Error en los datos";
        if (codigo.length() == 5) {
            mensaje = cliente_dal.eliminar(codigo);
        }
        return mensaje;
    }
}
