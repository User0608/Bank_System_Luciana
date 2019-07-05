/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba.entidades;

import entidades.moneda.*;

/**
 *
 * @author adriana
 */
public class TestMonedaDirector {

    public static void main(String[] args) {
        MonedaDirector director = new MonedaDirector(new Dolar());
        System.out.println(director.construir().toString());
        director = new MonedaDirector(new Sol());
        System.out.println(director.construir().toString());
    }
}
