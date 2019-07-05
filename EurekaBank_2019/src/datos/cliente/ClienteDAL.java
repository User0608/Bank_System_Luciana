/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.cliente;

import datos.Conexion;
import datos.DAL;
import entidades.Cliente;
import java.sql.SQLException;
import java.util.ArrayList;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author adriana
 */
public class ClienteDAL extends DAL {


    public String insertar(Cliente cliente) {
        
        //p_codigo ,p_paterno,p_materno,p_nombre,p_dni,p_ciudad,p_direccion,p_telefono,p_email
        String mensaje = null;
        try {
            String sql = "{call sp_insertarCliente(?,?,?,?,?,?,?,?,?)}";
            conexion = Conexion.establecerConexion();
            callable_statemen = conexion.prepareCall(sql);
            callable_statemen.setString(1, cliente.getCodigo().trim());
            callable_statemen.setString(2, cliente.getPaterno().trim());
            callable_statemen.setString(3, cliente.getMaterno().trim());
            callable_statemen.setString(4, cliente.getNombre().trim());
            callable_statemen.setString(5, cliente.getDni().trim());
            callable_statemen.setString(6, cliente.getCiudad().trim());
            callable_statemen.setString(7, cliente.getDireccion().trim());
            callable_statemen.setString(8, cliente.getTelefono().trim());
            callable_statemen.setString(9, cliente.getEmail().trim());
            callable_statemen.executeUpdate();
            mensaje = "true";
        } catch (ClassNotFoundException | SQLException e) {
            mensaje = e.getMessage();
        } finally {
            try {
                conexion.close();
                callable_statemen.close();
            } catch (SQLException e) {
                mensaje = e.getMessage();
            }
        }

        return mensaje;
    }

    public String buscar(String codigo) {
        String mensaje = null;
        try {
            String sql = "call sp_buscarCliente(?)";
            conexion = Conexion.establecerConexion();
            callable_statemen = conexion.prepareCall(sql);
            callable_statemen.setString(1, codigo.trim());
            result_set = callable_statemen.executeQuery();
            mensaje = "Registro no encontrado";
            while (result_set.next()) {
                mensaje = "true";
                //mensaje=result_set.getString(4);
            }
        } catch (ClassNotFoundException | SQLException e) {
            mensaje = e.getMessage();
        } finally {
            try {
                conexion.close();
                callable_statemen.close();
                result_set.close();
            } catch (SQLException e) {
                mensaje = e.getMessage();
            }
        }
        return mensaje;
    }

    public String actualizar(Cliente cliente) {
        String mensaje = null;
        try {
            String sql = "{call sp_acutualizarCliente(?,?,?,?,?,?,?,?,?)}";
            conexion = Conexion.establecerConexion();
            callable_statemen = conexion.prepareCall(sql);
            callable_statemen.setString(1, cliente.getCodigo().trim());
            callable_statemen.setString(2, cliente.getPaterno().trim());
            callable_statemen.setString(3, cliente.getMaterno().trim());
            callable_statemen.setString(4, cliente.getNombre().trim());
            callable_statemen.setString(5, cliente.getDni().trim());
            callable_statemen.setString(6, cliente.getCiudad().trim());
            callable_statemen.setString(7, cliente.getDireccion().trim());
            callable_statemen.setString(8, cliente.getTelefono().trim());
            callable_statemen.setString(9, cliente.getEmail().trim());
            callable_statemen.executeUpdate();
            mensaje = "true";
        } catch (ClassNotFoundException | SQLException e) {
            mensaje = e.getMessage();
        } finally {
            try {
                conexion.close();
                callable_statemen.close();
            } catch (SQLException e) {
                mensaje = e.getMessage();

            }
        }

        return mensaje;
    }

    public ArrayList<Cliente> listar() {
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        try {
            String sql = "{call sp_listarClientes()}";
            conexion = Conexion.establecerConexion();
            callable_statemen = conexion.prepareCall(sql);
            result_set = callable_statemen.executeQuery();
            //p_codigo ,p_paterno,p_materno,p_nombre,p_dni,p_ciudad,p_direccion,p_telefono,p_email
            while (result_set.next()) {
//                clientes.add(
//                        new Cliente(
//                                result_set.getString(1), result_set.getString(2),
//                                result_set.getString(3), result_set.getString(4),
//                                result_set.getString(5), result_set.getString(6),
//                                result_set.getString(7), result_set.getString(8),
//                                result_set.getString(9))
//                );
            }

        } catch (ClassNotFoundException | SQLException e) {
            showMessageDialog(null, e.getMessage(), "Error", 0);
        } finally {
            try {
                conexion.close();
                callable_statemen.close();
                result_set.close();
            } catch (SQLException e) {
                showMessageDialog(null, e.getMessage(), "Error", 0);
            }
        }
        return clientes;
    }

    public String eliminar(String codigo) {
        String mensaje = null;
        try {
            String sql = "{call sp_eliminarCliente(?)}";
            conexion = Conexion.establecerConexion();
            callable_statemen = conexion.prepareCall(sql);
            callable_statemen.setString(1, codigo.trim());
            callable_statemen.executeUpdate();
            mensaje = "true";
        } catch (ClassNotFoundException | SQLException e) {
            mensaje = e.getMessage();
        } finally {
            try {
                conexion.close();
                callable_statemen.close();
            } catch (SQLException e) {
                mensaje = e.getMessage();
            }
        }
        return mensaje;
    }

}
