/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.cliente;

import datos.cliente.ClienteDAL;
import entidades.Cliente;
import entidades.cuenta.RealCuenta;
import java.util.ArrayList;

/**
 *
 * @author R000R
 */
public class ClienteBL {

  //  ArrayList<RealCuenta> cuenta;
    ClienteDAL clientedal = new ClienteDAL();

    public String insertar(Cliente cliente) {
        String mensaje = null;
        if (cliente.getCodigo().trim().length() == 5
                && cliente.getPaterno().trim().length() > 1 && cliente.getPaterno().trim().length() <= 25
                && cliente.getMaterno().trim().length() > 1 && cliente.getMaterno().trim().length() <= 25
                && cliente.getNombre().trim().length() > 1 && cliente.getNombre().trim().length() <= 30
                && cliente.getDni().trim().length() == 8
                && cliente.getCiudad().trim().length() > 1 && cliente.getCiudad().trim().length() <= 30
                && cliente.getDireccion().trim().length() > 1 && cliente.getDireccion().trim().length() <= 50
                && cliente.getTelefono().trim().length() > 1 && cliente.getTelefono().trim().trim().length() <= 20
                && cliente.getEmail().trim().length() > 1 && cliente.getEmail().trim().length() <= 50) {

            mensaje = clientedal.insertar(cliente);
            if (mensaje.compareTo("true") == 0) {
                mensaje = "Registro insertado";
            }
        } else {
            mensaje = "Datos no válidos";
        }
        return mensaje;
    }

    public String buscar(String codigo) {
        return clientedal.buscar(codigo);
    }

    public String eliminar(String codigo) {
        String mensaje = null;
        if (codigo.trim().length() == 5) {
            mensaje = clientedal.eliminar(codigo);
            if (mensaje.compareTo("true") == 0) {
                mensaje = "Cliente eliminado";
            }
        } else {
            mensaje = "Datos no válidos";
        }
        return mensaje;
    }

    public ArrayList<Cliente> listar() {
        return clientedal.listar();
    }

    public String actualizar(Cliente cliente) {
        String mensaje = null;
        if (cliente.getCodigo().trim().length() == 5
                && cliente.getPaterno().trim().length() > 1 && cliente.getPaterno().trim().length() <= 25
                && cliente.getMaterno().trim().length() > 1 && cliente.getMaterno().trim().length() <= 25
                && cliente.getNombre().trim().length() > 1 && cliente.getNombre().trim().length() <= 30
                && cliente.getDni().trim().length() == 8
                && cliente.getCiudad().trim().length() > 1 && cliente.getCiudad().trim().length() <= 30
                && cliente.getDireccion().trim().length() > 1 && cliente.getDireccion().trim().length() <= 50
                && cliente.getTelefono().trim().length() > 1 && cliente.getTelefono().trim().trim().length() <= 20
                && cliente.getEmail().trim().length() > 1 && cliente.getEmail().trim().length() <= 50) {

            if (clientedal.buscar(cliente.getCodigo()) == "true") {
                mensaje = clientedal.actualizar(cliente);
                if (mensaje == "ok") {
                    mensaje = "Clente Actualizado";
                } else {
                    mensaje = "error en los datos";
                }
            } else {
                mensaje = "Cliente no existe";
            }
        }
        return mensaje;
    }

    public Cliente getCliente(String codigo) {
        if (codigo.trim().length() == 5) {
            if (clientedal.buscar(codigo) == "ok") {
                return clientedal.getCliente(codigo);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

}
