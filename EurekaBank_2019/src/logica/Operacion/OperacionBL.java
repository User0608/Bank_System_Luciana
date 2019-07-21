/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.Operacion;

import datos.operacion.OperacionDAL;
import entidades.cuenta.RealCuenta;
import entidades.movimiento.Movimiento;
import entidades.movimiento.TipoMovimiento;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author adriana
 */
public class OperacionBL {

    private OperacionDAL operacion_dal;

    public OperacionBL() {
        operacion_dal = new OperacionDAL();
    }

    public String depositar(String codigo_cuenta, double importe) {
        String mensaje = "Error en los datos ingresados";
        if (codigo_cuenta.trim().length() == 8 && importe > 0) {
            mensaje = operacion_dal.depositar(codigo_cuenta.trim(), importe);
        }
        return mensaje;
    }

    public String retirar(String codigo_cuenta, double importe) {
        String mensaje = "Error en los datos ingresados";
        if (codigo_cuenta.trim().length() == 8 && importe > 0) {
            mensaje = operacion_dal.retirar(codigo_cuenta.trim(), importe);
        }
        return mensaje;
    }

    

    public String registarMovimiento(Movimiento movimiento) {

        String mensaje = "Error puntero nulo";
        if (movimiento != null) {
            mensaje = "Error en los datos, registro movimiento";
           
            if (movimiento.getCuenta() != null && movimiento.getNumero_movimiento() >= 0
                    && movimiento.getFecha() != null && movimiento.getEmpleado() != null
                    && movimiento.getCodigo_tipo_movimiento().length() == 3 && movimiento.getImporte() > 0) {
                mensaje = operacion_dal.registrarMovimiento(movimiento);
            }
        }
        return mensaje;
    }

    public TipoMovimiento getTipoMovimiento(String codigo) {
        if (codigo.trim().length() == 3) {
            return operacion_dal.getTipoMovimiento(codigo);
        }
        JOptionPane.showMessageDialog(null, "Error en el dato", "Alert", 0);
        return null;
    }

    public int cantidadMovimientos(String year, String month, String codigo_cuenta) {
        if (year.trim().length() == 4 && month.trim().length() > 0 && codigo_cuenta.trim().length() == 8) {
            return operacion_dal.cantad_movimientos(year, month, codigo_cuenta);
        }
        JOptionPane.showMessageDialog(null, "Error en el dato", "Alert", 0);
        return 0;
    }

    public ArrayList<Movimiento> listarMovimientos(String codigo_cuenta) {
        if (codigo_cuenta.trim().length() == 8) {
            return operacion_dal.listaMovimiento(codigo_cuenta);
        }
        JOptionPane.showMessageDialog(null, "Error en el dato", "Alert", 0);
        return null;
    }

    public ArrayList<TipoMovimiento> listarTipoMovimiento() {
        return operacion_dal.listarTipoMovimientos();
    }
}
