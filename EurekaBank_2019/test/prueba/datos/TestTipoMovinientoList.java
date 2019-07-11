/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba.datos;

import entidades.movimiento.TipoMovimiento;
import java.util.ArrayList;
import logica.Flogica;

/**
 *
 * @author adriana
 */
public class TestTipoMovinientoList {

    //private static final Flogica f = ;

    public static void main(String[] args) {
        String g= Flogica.getInstance().getMovimiento_descripcion("001");
        System.out.println(g);
    }
}
