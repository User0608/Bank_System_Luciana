/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.cuenta;

import datos.cuenta.CuentaDAL;
import entidades.cuenta.RealCuenta;
import java.util.ArrayList;

/**
 *
 * @author R000R
 */
public class CuentaBL {
    CuentaDAL cuentadal =new CuentaDAL();
    public  String registrar(RealCuenta cuenta){
        String mensaje;
        mensaje=cuentadal.registrar(cuenta);
        if(mensaje=="ok"){
            mensaje="Nueva Cuenta Registrada";
        }
        else mensaje= "datos de la cuenta encontrados";
        return mensaje;        
    }
     public  String bloquear(String codigo){   
         String mensaje;
        if(codigo.trim().length()!=0){
            mensaje = cuentadal.bloquear(codigo);
            if (mensaje=="ok"){
                mensaje ="cuenta Bloqueada";
            }
            else mensaje="oh no";
            
        }
        else mensaje="datos incorrectos";
        return mensaje;
    }
     
     
      public  ArrayList<RealCuenta> listar(){
        return cuentadal.listar();
    }
}
