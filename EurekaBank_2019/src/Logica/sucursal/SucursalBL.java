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
     SucursalDAL sucursaldal =new SucursalDAL();
    
    public  ArrayList<Sucursal> listar() {
        return sucursaldal.listar();
    }
    public Sucursal getSucursal(String codigo){
        if(codigo.trim().length()==3){
          return sucursaldal.getSucursal(codigo);            
        }else return null;        
    }
}
