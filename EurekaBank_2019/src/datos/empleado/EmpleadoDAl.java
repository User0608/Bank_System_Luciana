/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.empleado;

import datos.Conexion;
import datos.DAL;
import entidades.Empleado;
import java.sql.SQLException;
import java.util.ArrayList;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author adriana
 */
public class EmpleadoDAl extends DAL{
    //emplcodigio,emplpaterno,emplmatern,emplnombre,emplciudad,empldireccion,emplusuario,emplclave
    public String insertar(Empleado empleado) {
        String mensaje = null;
        try {
            String sql = "{call sp_insertarEmpleado(?,?,?,?,?,?,?,?)}";
            conexion = Conexion.establecerConexion();
            callable_statemen = conexion.prepareCall(sql);
            callable_statemen.setString(1, empleado.getCodigo().trim());
            callable_statemen.setString(2, empleado.getPaterno().trim());
            callable_statemen.setString(3, empleado.getMaterno().trim());
            callable_statemen.setString(4, empleado.getNombre().trim());
            callable_statemen.setString(5, empleado.getCiudad().trim());
            callable_statemen.setString(6, empleado.getDireccion().trim());
            callable_statemen.setString(7, empleado.getUsuario().trim());
            callable_statemen.setString(8, empleado.getClave().trim());

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
            String sql = "{call sp_buscarEmpleado(?)}";
            conexion = Conexion.establecerConexion();
            callable_statemen = conexion.prepareCall(sql);
            callable_statemen.setString(1, codigo.trim());
            result_set = callable_statemen.executeQuery();
            mensaje = "Registro no encontrado";
            while (result_set.next()) {
                mensaje = "true";
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

    public String actualizar(Empleado empleado) {
        String mensaje = null;
        try {
            String sql = "{call sp_actualizarEmpleado(?,?,?,?,?,?,?,?)}";
            conexion = Conexion.establecerConexion();
            callable_statemen = conexion.prepareCall(sql);
            callable_statemen.setString(1, empleado.getCodigo().trim());
            callable_statemen.setString(2, empleado.getPaterno().trim());
            callable_statemen.setString(3, empleado.getMaterno().trim());
            callable_statemen.setString(4, empleado.getNombre().trim());
            callable_statemen.setString(5, empleado.getCiudad().trim());
            callable_statemen.setString(6, empleado.getDireccion().trim());
            callable_statemen.setString(7, empleado.getUsuario().trim());
            callable_statemen.setString(8, empleado.getClave().trim());

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

    public  ArrayList<Empleado> listar() {
        ArrayList<Empleado> empleados = new ArrayList<Empleado>();
        try {
            String sql = "{call sp_listarEmpleados()}";
            conexion = Conexion.establecerConexion();
            callable_statemen = conexion.prepareCall(sql);
            result_set = callable_statemen.executeQuery();

            while (result_set.next()) {
//                empleados.add(
//                        new Empleado(
//                                result_set.getString(1), result_set.getString(2),
//                                result_set.getString(3), result_set.getString(4),
//                                result_set.getString(5), result_set.getString(6),
//                                result_set.getString(7), result_set.getString(8))
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
        return empleados;
    }

    public String eliminar(String codigo) {
        String mensaje = null;
        try {
            String sql = "{call sp_eliminarEmpleado(?)}";
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
