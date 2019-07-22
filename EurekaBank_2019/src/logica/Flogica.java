/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import entidades.Cliente;
import entidades.Empleado;
import entidades.Sucursal;
import entidades.cuenta.RealCuenta;
import entidades.movimiento.Movimiento;
import entidades.movimiento.TipoMovimiento;
import java.util.ArrayList;
import java.util.Iterator;
import logica.Operacion.OperacionBL;
import logica.cliente.ClienteBL;
import logica.cuenta.CuentaBL;
import logica.empleado.EmpleadoBL;
import logica.sucursal.SucursalBL;

/**
 *
 * @author aBriones
 */
public class Flogica {

    private static Flogica flogica;

    private OperacionBL operacion_bl;
    private CuentaBL cuenta_bl;
    private SucursalBL sucursal_bl;
    private ClienteBL cliente_bl;
    private EmpleadoBL empleado_bl;
    
    private ArrayList<TipoMovimiento> tmovimientos;
    private Flogica() {
        operacion_bl = new OperacionBL();
        cuenta_bl = new CuentaBL();
        sucursal_bl = new SucursalBL();
        cliente_bl = new ClienteBL();
        empleado_bl = new EmpleadoBL();
        tmovimientos = operacion_bl.listarTipoMovimiento();
    }

    public static Flogica getInstance() {
        if (flogica == null) {
            synchronized (Flogica.class) {
                if (flogica == null) {
                    flogica = new Flogica();
                }
            }
        }
        return flogica;
    }

    public String depositar(Movimiento movimiento) {
        String mensaje = "Error flogica";

        mensaje = operacion_bl.registarMovimiento(movimiento);
        if (mensaje.compareTo("ok") == 0) {
            mensaje = operacion_bl.depositar(movimiento.getCuenta().getCodigo(), movimiento.getImporte());
        }
        return mensaje;
    }

    public String retirar(Movimiento movimiento) {
        String mensaje = "Error flogica";
        mensaje = operacion_bl.registarMovimiento(movimiento);
        if (mensaje.compareTo("ok") == 0) {
            mensaje = operacion_bl.retirar(movimiento.getCuenta().getCodigo(), movimiento.getImporte());
        }
        return mensaje;
    }

    public RealCuenta getCuenta(String codigo_cuenta) {
        RealCuenta cuenta = cuenta_bl.getCuenta(codigo_cuenta);
        cuenta.setMovimientos(operacion_bl.listarMovimientos(codigo_cuenta));
        return cuenta;
    }

    public ArrayList<RealCuenta> listarCuentas() {
        return cuenta_bl.listar();
    }

    public ArrayList<Sucursal> listarSucursal() {
        return sucursal_bl.list();
    }

    public String getMovimiento_descripcion(String codigo) {
        Iterator<TipoMovimiento> itera = tmovimientos.iterator();
        while (itera.hasNext()) {
            TipoMovimiento movimiento = itera.next();
            if (movimiento.getCodigo().compareTo(codigo) == 0) {
                return movimiento.getDescripcion();
            }
        }
        return null;
    }

    public Empleado getEmpleado(String codigo_empleado) {
        return empleado_bl.getEmpleado(codigo_empleado);
    }

    public Cliente getCliente(String codigo) {
        return cliente_bl.getCliente(codigo);
    }

    public String rcuenta_cexistente(RealCuenta cuenta, Movimiento movimiento) {
        String mensaje = null;
        mensaje = cuenta_bl.registrar(cuenta);
        if (mensaje.compareTo("ok") == 0) {
            mensaje = operacion_bl.registarMovimiento(movimiento);
        }
        return mensaje;
    }

    public String registrarCuenta(RealCuenta cuenta, Movimiento movimiento, Cliente cliente) {
        String mensaje = null;
        mensaje = cliente_bl.insertar(cliente);
        if (mensaje.compareTo("ok") == 0) {
            mensaje = this.rcuenta_cexistente(cuenta, movimiento);
        }
        return mensaje;
    }
}
