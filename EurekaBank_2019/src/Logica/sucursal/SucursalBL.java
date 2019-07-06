/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.sucursal;

import datos.sucursal.SucursalDAL;
import entidades.Sucursal;
import java.util.ArrayList;

/**
 *
 * @author R000R
 */
public class SucursalBL {
     
    
    public static ArrayList<Sucursal> listar() {
        return SucursalDAL.listar();
    }
}
