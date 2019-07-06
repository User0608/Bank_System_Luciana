/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.cuenta;

import entidades.cuenta.RealCuenta;
import java.util.ArrayList;

/**
 *
 * @author R000R
 */
public class CuentaBL {
    public static String registrar(RealCuenta cuenta){
        String mensaje;
        mensaje=null;
        if(CuentaDAL.registrar(cuenta)=="true"){
            mensaje="Nueva Cuenta Registrada";
        }
        else mensaje= "datos de la cuenta encontrados";
        return mensaje;        
    }
     public static String bloquear(String codigo){   
         String mensaje;
        if(codigo.trim().length()!=0){
            if (CuentaDAL.bloquear(codigo)=="true"){
                mensaje ="cuenta Bloqueada";
            }
            else mensaje="oh no";
            
        }
        else mensaje="datos incorrectos";
        return mensaje;
    }
     
     
      public static ArrayList<RealCuenta> listar(){
        return CuentaDAL.listar();
    }
}
