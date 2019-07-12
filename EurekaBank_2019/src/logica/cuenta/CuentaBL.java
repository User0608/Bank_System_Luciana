/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.cuenta;

import datos.cuenta.CuentaDAL;
import entidades.cuenta.RealCuenta;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author adriana
 */
public class CuentaBL {

    private CuentaDAL cuenta_dal;

    public CuentaBL() {
        cuenta_dal = new CuentaDAL();
    }

    public String registrar(RealCuenta cuenta) {
        String mensaje = "Error en los datos";
        if (cuenta.getCodigo().length() == 8 && cuenta.getMoneda() != null
                && cuenta.getSucursal() != null && cuenta.getCodigo_empleado().length() == 4
                && cuenta.getSaldo() >= 0 && cuenta.getFecha_creacion() != null
                && cuenta.getClave().length() > 2) {
            mensaje = cuenta_dal.registrar(cuenta);
        }
        return mensaje;
    }

    public RealCuenta getCuenta(String codigo) {
        if (codigo.length() == 8) {
            return cuenta_dal.getCuenta(codigo);
        }
        JOptionPane.showMessageDialog(null, "Error en los datos", "Alert", 0);
        return null;
    }

    public ArrayList<RealCuenta> listar() {
        return cuenta_dal.listar();
    }

    public String bloquear(String codigo) {
        String mensaje = "Error en los datos";
        if (codigo.length() == 8) {
            mensaje = cuenta_dal.bloquear(codigo);
        }
        return mensaje;
    }

}
