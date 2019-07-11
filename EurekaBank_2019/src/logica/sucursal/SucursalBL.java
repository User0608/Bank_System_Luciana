/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.sucursal;

import datos.sucursal.SucursalDAL;
import entidades.Sucursal;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author adriana
 */
public class SucursalBL {

    private SucursalDAL sucursal_dal;

    public SucursalBL() {
        sucursal_dal = new SucursalDAL();
    }

    public ArrayList<Sucursal> list() {
        return sucursal_dal.list();
    }

    public Sucursal getSucursal(String codigo) {
        if (codigo.length() == 3) {
            return sucursal_dal.getSucursal(codigo);
        }
        JOptionPane.showMessageDialog(null, "Error en los datos", "Alert", 0);
        return null;
    }

}
