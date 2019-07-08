/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba.datos;

import datos.operacion.OperacionDAL;

/**
 *
 * @author adriana
 */
public class TestOperacion {

    private static OperacionDAL op = new OperacionDAL();

    public static void main(String[] args) {
        System.out.println(op.depositar("00100002", 1250.50));
        System.out.println(op.retirar("00100002", 600));
    }
}
