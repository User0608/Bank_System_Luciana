/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.cliente;

import datos.cliente.ClienteDAL;
import entidades.Cliente;
import entidades.cuenta.RealCuenta;
import java.util.ArrayList;

/**
 *
 * @author R000R
 */
public class ClienteBL {
    public static ArrayList<RealCuenta> cuenta;
    public static String insertar(String codigo,String paterno,String materno,
            String nombre,String dni,String ciudad,String direccion,String telefono,String email,int estado) {
        String mensaje=null;
        if(codigo.trim().length()==5 &&
           paterno.trim().length()>1 && paterno.trim().length()<=25&&
           materno.trim().length()>1 &&materno.trim().length()<=25 &&
           nombre.trim().length()>1 &&nombre.trim().length()<=30 &&
           dni.trim().length()==8 &&
           ciudad.trim().length()>1 && ciudad.trim().length()<=30 &&
           direccion.trim().length()>1 &&direccion.trim().length()<=50 &&
           telefono.trim().length()>1 &&telefono.trim().length()<=20 &&
           email.trim().length()>1 && email.trim().length()<=50 &&
           estado==1 ) {
       
            Cliente cliente =new Cliente(codigo,cuenta,dni,telefono,email,paterno,materno,nombre,ciudad,
            direccion);
            mensaje = ClienteDAL.insertar(cliente);
            if(mensaje.compareTo("true")==0)
                mensaje = "Registro insertado";
        } 
        else{
            mensaje = "Datos no válidos";
        }
        return mensaje;
    }
    
    
     public static String buscar(String codigo) {     
        return ClienteDAL.buscar(codigo);
    }
        
      public static String eliminar(String codigo) {
        String mensaje = null;
        if(codigo.trim().length() == 5) {
            mensaje = ClienteDAL.eliminar(codigo);    
            if(mensaje.compareTo("true")==0)
                mensaje = "Cliente eliminado";
        } 
        else{
            mensaje = "Datos no válidos";
        }
        return mensaje;
    }
   public static ArrayList<Cliente> listar(){
       return ClienteDAL.listar();
   }
}
