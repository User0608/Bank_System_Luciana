/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import entidades.cuenta.ICuenta;
import entidades.cuenta.RealCuenta;

/**
 *
 * @author adriana
 */
public class ProxyCuenta implements ICuenta {

    private RealCuenta cuenta;

    @Override
    public boolean depositar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
