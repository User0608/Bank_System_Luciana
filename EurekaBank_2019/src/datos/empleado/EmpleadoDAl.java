/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.empleado;

import datos.Conexion;
import datos.DAL;
import entidades.Cliente;
import entidades.Empleado;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author adriana
 */
public class EmpleadoDAl extends DAL {

    //emplcodigio,emplpaterno,emplmatern,emplnombre,emplciudad,empldireccion,emplusuario,emplclave
    public static String insertar(Empleado empleado) {
        String mensaje = null;
        try {
            String sql = "{call sp_insertarEmpleado(?,?,?,?,?,?,?,?)}";
            conexion = Conexion.establecerConexion();
            callable_statement = conexion.prepareCall(sql);
            callable_statement.setString(1, empleado.getCodigo().trim());
            callable_statement.setString(2, empleado.getPaterno().trim());
            callable_statement.setString(3, empleado.getMaterno().trim());
            callable_statement.setString(4, empleado.getNombre().trim());
            callable_statement.setString(5, empleado.getCiudad().trim());
            callable_statement.setString(6, empleado.getDireccion().trim());
            callable_statement.setString(7, empleado.getUsuario().trim());
            callable_statement.setString(8, empleado.getClave().trim());

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
            String sql = "{call sp_buscarEmpleado(?)}";
            conexion = Conexion.establecerConexion();
            callable_statement = conexion.prepareCall(sql);
            callable_statement.setString(1, codigo.trim());
            result_set = callable_statement.executeQuery();
            mensaje = "Registro no encontrado";
            while (result_set.next()) {
                mensaje = "true";
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

    public static String actualizar(Empleado empleado) {
        String mensaje = null;
        try {
            String sql = "{call sp_actualizarEmpleado(?,?,?,?,?,?,?,?)}";
            conexion = Conexion.establecerConexion();
            callable_statement = conexion.prepareCall(sql);
            callable_statement.setString(1, empleado.getCodigo().trim());
            callable_statement.setString(2, empleado.getPaterno().trim());
            callable_statement.setString(3, empleado.getMaterno().trim());
            callable_statement.setString(4, empleado.getNombre().trim());
            callable_statement.setString(5, empleado.getCiudad().trim());
            callable_statement.setString(6, empleado.getDireccion().trim());
            callable_statement.setString(7, empleado.getUsuario().trim());
            callable_statement.setString(8, empleado.getClave().trim());

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
    public Empleado getEmpleado(String codigo) {
        Empleado empleado = new Empleado();
        try {
            String sql = "select * from Empleado where emplcodigo=?";
            conexion = Conexion.establecerConexion();
            prepared_statement = conexion.prepareStatement(sql);
            prepared_statement.setString(1, codigo);
            result_set = prepared_statement.executeQuery();
            while (result_set.next()) {
                empleado.setCodigo(result_set.getString(1));
                empleado.setPaterno(result_set.getString(2));
                empleado.setMaterno(result_set.getString(3));
                empleado.setNombre(result_set.getString(4));
                empleado.setCiudad(result_set.getString(5));
                empleado.setDireccion(result_set.getString(7));
                empleado.setUsuario(result_set.getString(8));
                empleado.setClave(result_set.getString(9));
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
        return empleado;
    }


    public static ArrayList<Empleado> listar() {
        Empleado empleado;

        ArrayList<Empleado> empleados = new ArrayList<Empleado>();
        try {
            String sql = "{call sp_listarEmpleados()}";
            conexion = Conexion.establecerConexion();
            callable_statement = conexion.prepareCall(sql);
            result_set = callable_statement.executeQuery();

            while (result_set.next()) {
                empleado=new Empleado();
                empleado.setCodigo(result_set.getString(1));
                empleado.setPaterno(result_set.getString(2));
                empleado.setMaterno(result_set.getString(3));
                empleado.setNombre(result_set.getString(4));
                empleado.setCiudad(result_set.getString(5));
                empleado.setDireccion(result_set.getString(7));
                empleado.setUsuario(result_set.getString(8));
                empleado.setClave(result_set.getString(9));
                
                empleados.add(empleado);
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
        return empleados;
    }

    public static String eliminar(String codigo) {
        String mensaje = null;
        try {
            String sql = "{call sp_eliminarEmpleado(?)}";
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
