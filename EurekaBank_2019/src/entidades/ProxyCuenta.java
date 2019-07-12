/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import entidades.cuenta.ICuenta;
import entidades.cuenta.RealCuenta;
import entidades.movimiento.Movimiento;
import javax.swing.JOptionPane;
import logica.Flogica;

/**
 *
 * @author adriana
 */
public class ProxyCuenta implements ICuenta {

    private RealCuenta cuenta;
    
    public RealCuenta getCuenta(){
        return this.cuenta;
    }

    public RealCuenta validar_datos_cuenta(String cuenta_codigo, String password) {
        cuenta = Flogica.getInstance().getCuenta(cuenta_codigo);
        if (cuenta != null) {
            if (cuenta.validar_password(password)) {
                return cuenta;
            }
        }
        return null;
    }
    
    @Override
    public boolean retiro(Double monto, boolean internet) {        
        if (cuenta.retiro(monto, internet)) {
            String mensaje = Flogica.getInstance().retirar(cuenta.getMovimientos().get(cuenta.getMovimientos().size() - 1));
            if (mensaje.compareTo("ok") == 0) {
                return true;
            }else{
                JOptionPane.showMessageDialog(null, mensaje,"Error", 0);
            }
            return false;
        }
        return false;
    }

    @Override
    public boolean deposito(Double monto, boolean internet) {
         if (cuenta.deposito(monto, internet)) {
            String mensaje = Flogica.getInstance().depositar(cuenta.getMovimientos().get(cuenta.getMovimientos().size() - 1));
            if (mensaje.compareTo("ok") == 0) {
                return true;
            }else{
                JOptionPane.showMessageDialog(null, mensaje,"Error", 0);
            }
            return false;
        }
        return false;
    }

}
