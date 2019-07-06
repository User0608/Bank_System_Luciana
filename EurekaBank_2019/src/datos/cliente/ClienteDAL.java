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
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author adriana
 */
public class ClienteDAL extends DAL {



    public static String insertar(Cliente cliente) {

        //p_codigo ,p_paterno,p_materno,p_nombre,p_dni,p_ciudad,p_direccion,p_telefono,p_email
        String mensaje = null;
        try {
            String sql = "{call sp_insertarCliente(?,?,?,?,?,?,?,?,?)}";
            conexion = Conexion.establecerConexion();
            callable_statement = conexion.prepareCall(sql);
            callable_statement.setString(1, cliente.getCodigo().trim());
            callable_statement.setString(2, cliente.getPaterno().trim());
            callable_statement.setString(3, cliente.getMaterno().trim());
            callable_statement.setString(4, cliente.getNombre().trim());
            callable_statement.setString(5, cliente.getDni().trim());
            callable_statement.setString(6, cliente.getCiudad().trim());
            callable_statement.setString(7, cliente.getDireccion().trim());
            callable_statement.setString(8, cliente.getTelefono().trim());
            callable_statement.setString(9, cliente.getEmail().trim());
            callable_statement.executeUpdate();
            mensaje = "true";
        } catch (ClassNotFoundException | SQLException e) {
            mensaje = e.getMessage();
        } finally {
            try {
                conexion.close();
                callable_statement.close();
            } catch (SQLException e) {
                mensaje = e.getMessage();
            }
        }

        return mensaje;
    }

    public static String buscar(String codigo) {
        String mensaje = null;
        try {
            String sql = "call sp_buscarCliente(?)";
            conexion = Conexion.establecerConexion();
            callable_statement = conexion.prepareCall(sql);
            callable_statement.setString(1, codigo.trim());
            result_set = callable_statement.executeQuery();
            mensaje = "Registro no encontrado";
            while (result_set.next()) {
                mensaje = "ok";
                //mensaje=result_set.getString(4);
            }
        } catch (ClassNotFoundException | SQLException e) {
            mensaje = e.getMessage();
        } finally {
            try {
                conexion.close();
                callable_statement.close();
                result_set.close();
            } catch (SQLException e) {
                mensaje = e.getMessage();
            }
        }
        return mensaje;
    }

    public static String actualizar(Cliente cliente) {
        String mensaje = null;
        try {
            String sql = "{call sp_acutualizarCliente(?,?,?,?,?,?,?,?,?)}";
            conexion = Conexion.establecerConexion();
            callable_statement = conexion.prepareCall(sql);
            callable_statement.setString(1, cliente.getCodigo().trim());
            callable_statement.setString(2, cliente.getPaterno().trim());
            callable_statement.setString(3, cliente.getMaterno().trim());
            callable_statement.setString(4, cliente.getNombre().trim());
            callable_statement.setString(5, cliente.getDni().trim());
            callable_statement.setString(6, cliente.getCiudad().trim());
            callable_statement.setString(7, cliente.getDireccion().trim());
            callable_statement.setString(8, cliente.getTelefono().trim());
            callable_statement.setString(9, cliente.getEmail().trim());
            callable_statement.executeUpdate();
            mensaje = "ok";
        } catch (ClassNotFoundException | SQLException e) {
            mensaje = e.getMessage();
        } finally {
            try {
                conexion.close();
                callable_statement.close();
            } catch (SQLException e) {
                mensaje = e.getMessage();

            }
        }

        return mensaje;
    }
public Cliente getCliente(String codigo) {
        Cliente cliente = new Cliente();
        try {
            String sql = "select * from Cliente where cliecodigo=?";
            conexion = Conexion.establecerConexion();
            prepared_statement = conexion.prepareStatement(sql);
            prepared_statement.setString(1, codigo);
            result_set = prepared_statement.executeQuery();
            while (result_set.next()) {
                cliente.setCodigo(result_set.getString(1));
                cliente.setPaterno(result_set.getString(2));
                cliente.setMaterno(result_set.getString(3));
                cliente.setNombre(result_set.getString(4));
                cliente.setDni(result_set.getString(5));
                cliente.setCiudad(result_set.getString(6));
                cliente.setDireccion(result_set.getString(7));
                cliente.setTelefono(result_set.getString(8));
                cliente.setEmail(result_set.getString(9));
            }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Error", 0);
        } finally {
            try {
                conexion.close();
                prepared_statement.close();
                result_set.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e, "Error", 0);
            }
        }

        return cliente;
    }


    public static ArrayList<Cliente> listar() {

        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        Cliente cliente = null;
        try {
            String sql = "{call sp_listarClientes()}";
            conexion = Conexion.establecerConexion();
            callable_statement = conexion.prepareCall(sql);
            result_set = callable_statement.executeQuery();
            //p_codigo ,p_paterno,p_materno,p_nombre,p_dni,p_ciudad,p_direccion,p_telefono,p_email
            while (result_set.next()) {
                cliente = new Cliente();
                cliente.setCodigo(result_set.getString(1));
                cliente.setPaterno(result_set.getString(2));
                cliente.setMaterno(result_set.getString(3));
                cliente.setNombre(result_set.getString(4));
                cliente.setDni(result_set.getString(5));
                cliente.setCiudad(result_set.getString(6));
                cliente.setDireccion(result_set.getString(7));
                cliente.setTelefono(result_set.getString(8));
                cliente.setEmail(result_set.getString(9));
                clientes.add(cliente);
            }

        } catch (ClassNotFoundException | SQLException e) {
            showMessageDialog(null, e.getMessage(), "Error", 0);
        } finally {
            try {
                conexion.close();
                callable_statement.close();
                result_set.close();
            } catch (SQLException e) {
                showMessageDialog(null, e.getMessage(), "Error", 0);
            }
        }
        return clientes;
    }

    public static String eliminar(String codigo) {
        String mensaje = null;
        try {
            String sql = "{call sp_eliminarCliente(?)}";
            conexion = Conexion.establecerConexion();
            callable_statement = conexion.prepareCall(sql);
            callable_statement.setString(1, codigo.trim());
            callable_statement.executeUpdate();
            mensaje = "true";
        } catch (ClassNotFoundException | SQLException e) {
            mensaje = e.getMessage();
        } finally {
            try {
                conexion.close();
                callable_statement.close();
            } catch (SQLException e) {
                mensaje = e.getMessage();
            }
        }
        return mensaje;
    }

}
