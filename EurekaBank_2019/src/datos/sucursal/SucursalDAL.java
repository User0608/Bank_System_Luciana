/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.sucursal;

import datos.DAL;
import entidades.Sucursal;
import datos.Conexion;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author adriana
 */
public class SucursalDAL extends DAL {

    public  ArrayList<Sucursal> listar() {
        ArrayList<Sucursal> sucursales = new ArrayList<>();
        Sucursal sucursal;
        try {
            String sql = "select * from Sucursal";
            conexion = Conexion.establecerConexion();
            prepared_statement = conexion.prepareStatement(sql);
            result_set = prepared_statement.executeQuery();
            while (result_set.next()) {
                sucursal = new Sucursal();
                sucursal.setCodigo(result_set.getString(1));
                sucursal.setNombre(result_set.getString(2));
                sucursal.setCiudad(result_set.getString(3));
                sucursal.setDireccion(result_set.getString(4));
                sucursales.add(sucursal);
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
        return sucursales;
    }

    public Sucursal getSucursal(String codigo) {
        Sucursal sucursal = new Sucursal();
        try {
            String sql = "select * from Sucursal where sucucodigo=?";
            conexion = Conexion.establecerConexion();
            prepared_statement = conexion.prepareStatement(sql);
            prepared_statement.setString(1, codigo);
            result_set = prepared_statement.executeQuery();
            while (result_set.next()) {
                sucursal.setCodigo(result_set.getString(1));
                sucursal.setNombre(result_set.getString(2));
                sucursal.setCiudad(result_set.getString(3));
                sucursal.setDireccion(result_set.getString(4));
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

        return sucursal;
    }

}
