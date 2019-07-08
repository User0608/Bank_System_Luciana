/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.cuenta;

import java.sql.SQLException;
import datos.Conexion;
import datos.DAL;
import datos.cliente.ClienteDAL;
import datos.sucursal.SucursalDAL;
import entidades.cuenta.RealCuenta;
import entidades.moneda.Dolar;
import entidades.moneda.Moneda;
import entidades.moneda.MonedaBuilder;
import entidades.moneda.MonedaDirector;
import entidades.moneda.Sol;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author adriana
 */
public class CuentaDAL extends DAL {

    public String registrar(RealCuenta cuenta) {
        String mensaje = "";
        try {
            //call sp_insertarCuenta("00300004","01","001","0001","00005",593.32,"2018/02/28","123456");
            String sql = "{call sp_insertarCuenta(?,?,?,?,?,?,?,?)}";
            conexion = Conexion.establecerConexion();
            callable_statement = conexion.prepareCall(sql);
            callable_statement.setString(1, cuenta.getCodigo());
            callable_statement.setString(2, cuenta.getMoneda().getCodigo());
            callable_statement.setString(3, cuenta.getSucursal().getCodigo());
            callable_statement.setString(4, cuenta.getCodigo_empleado());
            callable_statement.setString(5, cuenta.getCliente().getCodigo());
            callable_statement.setDouble(6, cuenta.getSaldo());
            callable_statement.setDate(7, cuenta.getFecha_creacion());
            callable_statement.setString(8, cuenta.getClave());
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

    public  RealCuenta getCuenta(String codigo) {
        RealCuenta cuenta = new RealCuenta();
        try {
            String sql = "select * from Cuenta where cuencodigo=?";
            conexion = Conexion.establecerConexion();
            prepared_statement = conexion.prepareStatement(sql);
            prepared_statement.setString(1, codigo);
            result_set = prepared_statement.executeQuery();
            while (result_set.next()) {
                cuenta = new RealCuenta();
                cuenta.setCodigo(result_set.getString(1));
                MonedaBuilder moneda_builder = (result_set.getString(2).compareTo("01") == 0) ? new Sol() : new Dolar();
                cuenta.setMoneda(new MonedaDirector(moneda_builder).construir());
                cuenta.setSucursal(new SucursalDAL().getSucursal(result_set.getString(3)));
                cuenta.setCodigo_empleado(result_set.getString(4));
                cuenta.setCliente(new ClienteDAL().getCliente(result_set.getString(5)));
                cuenta.setSaldo(result_set.getDouble(6));
                cuenta.setFecha_creacion(result_set.getDate(7));
                cuenta.setEstado(result_set.getString(8));
                cuenta.setCantida_movimiento(result_set.getInt(9));
                cuenta.setClave(result_set.getString(10));
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

        return cuenta;

    }

    public  ArrayList<RealCuenta> listar() {
        ArrayList<RealCuenta> cuentas = new ArrayList<>();

        try {
            String sql = "select * from Cuenta";
            conexion = Conexion.establecerConexion();
            prepared_statement = conexion.prepareStatement(sql);
            result_set = prepared_statement.executeQuery();
            RealCuenta cuenta;
            while (result_set.next()) {
                cuenta = new RealCuenta();
                cuenta.setCodigo(result_set.getString(1));
                MonedaBuilder moneda_builder = (result_set.getString(2).compareTo("01") == 0) ? new Sol() : new Dolar();
                cuenta.setMoneda(new MonedaDirector(moneda_builder).construir());
                cuenta.setSucursal(new SucursalDAL().getSucursal(result_set.getString(3)));
                cuenta.setCodigo_empleado(result_set.getString(4));
                cuenta.setCliente(new ClienteDAL().getCliente(result_set.getString(5)));
                cuenta.setSaldo(result_set.getDouble(6));
                cuenta.setFecha_creacion(result_set.getDate(7));
                cuenta.setEstado(result_set.getString(8));
                cuenta.setCantida_movimiento(result_set.getInt(9));
                cuenta.setClave(result_set.getString(10));
                cuentas.add(cuenta);
            }

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Erro", 0);
        } finally {
            try {
                conexion.close();
                prepared_statement.close();
                result_set.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e, "Erro", 0);
            }
        }

        return cuentas;
    }

    public  String bloquear(String codigo) {

        String mensaje = "";
        try {
            String sql = "update Cuenta set cuenestado=\"INACTIVO\" where cuencodigo=?";
            conexion = Conexion.establecerConexion();
            prepared_statement = conexion.prepareStatement(sql);
            prepared_statement.setString(1, codigo);
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

}
