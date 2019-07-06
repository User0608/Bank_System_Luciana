/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba.datos;

import datos.cuenta.CuentaDAL;
import entidades.*;
import entidades.cuenta.*;
import java.sql.Date;

/**
 *
 * @author adriana
 */
public class TestCuentaDAl {

    private static CuentaDAL cuenta = new CuentaDAL();

    public static void main(String[] args) {
//        
//        System.out.println(cuenta.bloquear("00100001"));
//        System.out.println(cuenta.bloquear("00100002"));
//        System.out.println(cuenta.bloquear("00200001"));    
RealCuenta rcuenta = new RealCuenta();
//                    rcuenta.setCodigo("00400003");
//                    rcuenta.getMoneda().setCodigo("02");
//                    rcuenta.getSucursal().setCodigo("001");
//                    rcuenta.setCodigo_empleado("0001");
//                    rcuenta.getCliente().setCodigo("00003");
//                    rcuenta.setSaldo(5422.932);
//                    rcuenta.setFecha_creacion(new Date(2019-1900, 12-1,23));
//                    rcuenta.setClave("secret");
//
//             System.out.println(cuenta.registrar(rcuenta));

    rcuenta=cuenta.getCuenta("00200002");
    
       System.out.println(rcuenta.toString());    
    
     
    }

}
