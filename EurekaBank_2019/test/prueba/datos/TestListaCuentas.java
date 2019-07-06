/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba.datos;

import datos.cuenta.CuentaDAL;
import entidades.cuenta.RealCuenta;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author adriana
 */
public class TestListaCuentas {

    private static CuentaDAL cuenta = new CuentaDAL();
    private static ArrayList<RealCuenta> cuentas;

    public static void main(String[] args) {
        cuentas = cuenta.listar();
        Iterator<RealCuenta> itera = cuentas.iterator();
        while (itera.hasNext()) {
            System.out.println("->" + itera.next().toString() + "\n\n");
        }

    }
}
