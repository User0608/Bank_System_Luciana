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

    CuentaDAL cuentadal = new CuentaDAL();

    public String registrar(RealCuenta cuenta) {
        String mensaje;
        //
        if (cuenta.getCantida_movimiento() < 11
                && cuenta.getClave().trim().length() == 6
                && cuenta.getCliente().getCodigo().trim().length() == 5
                && cuenta.getCodigo().trim().length() == 8
                && cuenta.getCodigo_empleado().trim().length() == 4
                && cuenta.getEstado().trim().length() > 1 && cuenta.getEstado().trim().length() <= 15
                && cuenta.getFecha_creacion() != null
                && cuenta.getMoneda().getCodigo().trim().length() == 2
                && cuenta.getSaldo() >= 0
                && cuenta.getSucursal().getCodigo().trim().length() == 3) {

            if (cuentadal.registrar(cuenta) == "ok") {
                mensaje = "Nueva Cuenta Registrada";
            } else {
                mensaje = "datos de la cuenta encontrados";
            }

        } else {
            mensaje = "error en los datos";
        }
        //
        return mensaje;
    }

    public String bloquear(String codigo) {
        String mensaje;
        if (codigo.trim().length() == 8) {
            if (cuentadal.bloquear(codigo) == "ok") {
                mensaje = "cuenta Bloqueada";
            } else {
                mensaje = "oh no";
            }
        } else {
            mensaje = "Codigo no encontrado";
        }
        return mensaje;
    }

    public ArrayList<RealCuenta> listar() {
        return cuentadal.listar();
    }
    
    public RealCuenta getCuenta(String codigo){
        if(codigo.trim().length()==8){
          return  cuentadal.getCuenta(codigo);
        }else return null;
    }
}
