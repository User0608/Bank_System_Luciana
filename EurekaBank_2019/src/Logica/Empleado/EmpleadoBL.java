/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Empleado;
import java.util.ArrayList;
import  datos.*;
import datos.empleado.EmpleadoDAl;
import entidades.*;
import entidades.cuenta.RealCuenta;
import entidades.movimiento.Movimiento;

/**
 *
 * @author R000R
 */
public class EmpleadoBL {
    ArrayList<Movimiento> movimientos;
     RealCuenta cuenta;
     EmpleadoDAl empleadodal= new EmpleadoDAl();

      public  String insertar(String codigo,  String paterno, String materno, String nombre, String ciudad,
              String direccion ,String usuario, String clave,int estado) {
        String mensaje;
        
        if(codigo.trim().length()==4 &&
           paterno.trim().length()>1 && paterno.trim().length()<=25&&
           materno.trim().length()>1 &&materno.trim().length()<=25 &&
           nombre.trim().length()>1 &&nombre.trim().length()<=30 &&
           ciudad.trim().length()>1 && ciudad.trim().length()<=30 &&
           direccion.trim().length()>1 &&direccion.trim().length()<=50 &&
           usuario.trim().length()>1 &&usuario.trim().length()<=15 &&
           clave.trim().length()>1 &&clave.trim().length()<=15 &&
           estado==1 )
        {       
            
            if(empleadodal.buscar(codigo)=="true") {
                    Empleado empleado= new Empleado(movimientos,cuenta,usuario,clave,paterno,materno,
                            nombre,ciudad,direccion);
                    mensaje = empleadodal.insertar(empleado);                   
                    if(mensaje.compareTo("true")==0)
                        mensaje = "Registro insertado";      
              
            } else mensaje = "Código de empleado ya existe";
        } 
        else{
            mensaje = "Datos no válidos";
        }
        return mensaje;
    }
        
    public  String buscar(String codigo) {
        String mensaje;
        if(codigo.trim().length()==4){
            mensaje= empleadodal.buscar(codigo);
        }
        else
            mensaje= "Dato no válido";
        return mensaje;
    }
    
    
     public  String eliminar(String codigo) {
        String mensaje;
        if(codigo.trim().length() == 4) {
            mensaje = empleadodal.eliminar(codigo);
            if(mensaje.compareTo("true")==0)
               mensaje = "Registro eliminado";      
        } 
        else{
            mensaje = "Datos no válidos";
        }
        return mensaje;
    }
     
       public  ArrayList<Empleado> listar() {
        return empleadodal.listar();
    }
}
