/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.operacion;

import datos.DAL;
import entidades.movimiento.Movimiento;
import entidades.movimiento.TipoMovimiento;
import java.util.ArrayList;
import datos.Conexion;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author nuri-
 */
public class OperacionDAL extends DAL {

    public String depositar(String codigo_cuenta, double importe) {
        String mensaje = "";
        try {
            String sql = "update Cuenta set cuensaldo=cuensaldo + ? where cuencodigo=?";
            conexion = Conexion.establecerConexion();
            prepared_statement = conexion.prepareStatement(sql);
            prepared_statement.setDouble(1, importe);
            prepared_statement.setString(2, codigo_cuenta);
            prepared_statement.executeUpdate();
            mensaje = "ok";
        } catch (ClassNotFoundException | SQLException e) {
            mensaje = e.getMessage();
        } finally {
            try {
                conexion.close();
                prepared_statement.close();
            } catch (SQLException e) {
                mensaje = e.getMessage();
            }
        }
        return mensaje;
    }

    public String retirar(String codigo_cuenta, double importe) {
        String mensaje = "";
        try {
            String sql = "update Cuenta set cuensaldo=cuensaldo - ? where cuencodigo=?";
            conexion = Conexion.establecerConexion();
            prepared_statement = conexion.prepareStatement(sql);
            prepared_statement.setDouble(1, importe);
            prepared_statement.setString(2, codigo_cuenta);
            prepared_statement.executeUpdate();
            mensaje = "ok";
        } catch (ClassNotFoundException | SQLException e) {
            mensaje = e.getMessage();
        } finally {
            try {
                conexion.close();
                prepared_statement.close();
            } catch (SQLException e) {
                mensaje = e.getMessage();
            }
        }
        return mensaje;
    }

    public ArrayList<Movimiento> listaMovimiento(String codigo_cuenta) {
        ArrayList<Movimiento> movimientos = new ArrayList<Movimiento>();
        Movimiento movimiento;
        try {
            String sql = "select * from Movimiento where cuencodigo = ?";
            conexion = Conexion.establecerConexion();
            prepared_statement = conexion.prepareStatement(sql);
            prepared_statement.setString(1, codigo_cuenta);
            result_set = prepared_statement.executeQuery();
            while (result_set.next()) {
                movimiento = new Movimiento();                
                movimiento.setNumero_movimiento(result_set.getInt(2));
                movimiento.setFecha(result_set.getDate(3));
                movimiento.setImporte(result_set.getDouble(6));
                movimiento.setCodigo_tipo_movimiento(result_set.getString(5));
                movimientos.add(movimiento);
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
        return movimientos;
    }

    public int cantad_movimientos(String year, String month, String codigo_cuenta) {
        int i = 0;
        try {
            String sql
                    = "select * from Movimiento where YEAR( movifecha ) = ? and MONTH( movifecha ) = ? and cuencodigo = ?";
            conexion = Conexion.establecerConexion();
            prepared_statement = conexion.prepareStatement(sql);
            prepared_statement.setString(1, year);
            prepared_statement.setString(2, month);
            prepared_statement.setString(3, codigo_cuenta);
            result_set = prepared_statement.executeQuery();
            while (result_set.next()) {
                i++;
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
        return i;
    }

    public String registrarMovimiento(Movimiento movimiento) {
        String mensaje = "";
        try {
            String sql = "{call sp_insertarMovimiento(?,?,?,?,?,?)}";
            conexion = Conexion.establecerConexion();
            prepared_statement = conexion.prepareCall(sql);
            prepared_statement.setString(1, movimiento.getCuenta().getCodigo());
            prepared_statement.setInt(2, movimiento.getNumero_movimiento());
            prepared_statement.setDate(3, movimiento.getFecha());
            prepared_statement.setString(4, movimiento.getEmpleado().getCodigo());
            prepared_statement.setString(5, movimiento.getCodigo_tipo_movimiento());
            prepared_statement.setDouble(6, movimiento.getImporte());
            prepared_statement.executeUpdate();
            mensaje = "ok";
        } catch (ClassNotFoundException | SQLException e) {
            mensaje = e.getMessage();
        } finally {
            try {
                conexion.close();
                prepared_statement.close();
            } catch (SQLException e) {
                mensaje = e.getMessage();
            }
        }

        return mensaje;
    }

    public TipoMovimiento getTipoMovimiento(String codigo) {
        TipoMovimiento tmovimiento;
        try {
            String sql = "select * from TipoMovimiento where tipoestado='ACTIVO' and tipocodigo=?";
            conexion = Conexion.establecerConexion();
            prepared_statement = conexion.prepareStatement(sql);
            result_set = prepared_statement.executeQuery();
            while (result_set.next()) {
                tmovimiento = new TipoMovimiento(
                        result_set.getString(1),
                        result_set.getString(2),
                        result_set.getString(3)
                );
                return tmovimiento;
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
        return null;

    }

    public ArrayList<TipoMovimiento> listarTipoMovimientos() {
        ArrayList<TipoMovimiento> tipo_movimientos = new ArrayList<>();
        TipoMovimiento tmovimiento;
        try {
            String sql = "select * from TipoMovimiento where tipoestado='ACTIVO'";
            conexion = Conexion.establecerConexion();
            prepared_statement = conexion.prepareStatement(sql);
            result_set = prepared_statement.executeQuery();
            while (result_set.next()) {
                tmovimiento = new TipoMovimiento(
                        result_set.getString(1),
                        result_set.getString(2),
                        result_set.getString(3)
                );
                tipo_movimientos.add(tmovimiento);
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
        return tipo_movimientos;
    }
}
