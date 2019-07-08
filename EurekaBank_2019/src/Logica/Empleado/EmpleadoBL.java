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
     
       public  String insertar(Empleado empleado) {
        String mensaje; 
        if(empleado.getCodigo().trim().length()==4 &&
           empleado.getPaterno().trim().length()>1 &&  empleado.getPaterno().trim().length()<=25&&
           empleado.getMaterno().trim().length()>1 &&empleado.getMaterno().trim().length()<=25 &&
           empleado.getNombre().trim().length()>1 && empleado.getNombre().trim().length()<=30 &&
           empleado.getCiudad().trim().length()>1 &&  empleado.getCiudad().trim().length()<=30 &&
           empleado.getDireccion().trim().length()>1 &&empleado.getDireccion().trim().length()<=50 &&
           empleado.getUsuario().trim().length()>1 &&empleado.getUsuario().trim().length()<=15 &&
           empleado.getClave().trim().length()>1 &&empleado.getClave().trim().length()<=15 
           )
        {       
            
            if(empleadodal.buscar(empleado.getCodigo())=="true") {
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

       public String actualizar(Empleado empleado){
           String mensaje;
           mensaje=null;
           if(empleado.getCodigo().trim().length()==4 &&
           empleado.getPaterno().trim().length()>1 &&  empleado.getPaterno().trim().length()<=25&&
           empleado.getMaterno().trim().length()>1 &&empleado.getMaterno().trim().length()<=25 &&
           empleado.getNombre().trim().length()>1 && empleado.getNombre().trim().length()<=30 &&
           empleado.getCiudad().trim().length()>1 &&  empleado.getCiudad().trim().length()<=30 &&
           empleado.getDireccion().trim().length()>1 &&empleado.getDireccion().trim().length()<=50 &&
           empleado.getUsuario().trim().length()>1 &&empleado.getUsuario().trim().length()<=15 &&
           empleado.getClave().trim().length()>1 &&empleado.getClave().trim().length()<=15 
           ) {
                if (empleadodal.buscar(empleado.getCodigo()) == "true"){
                    mensaje = empleadodal.actualizar(empleado);
                    if(mensaje == "true")
                        mensaje = "Registro guardado";      
                }
                else
                    mensaje = "Usuario ya existe";
           }
           return mensaje;
       }
       
       public Empleado getEmpleado(String codigo){
           if(codigo.trim().length()==4 ){
               if (empleadodal.buscar(codigo)=="true"){
                 return empleadodal.getEmpleado(codigo);                    
           }else return null;
           }
           else  return null;
       }
}
