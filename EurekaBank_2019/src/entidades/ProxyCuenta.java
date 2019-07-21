/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import entidades.cuenta.ICuenta;
import entidades.cuenta.RealCuenta;
import entidades.moneda.Moneda;
import entidades.movimiento.Movimiento;
import javax.swing.JOptionPane;
import logica.Flogica;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author adriana
 */
public class ProxyCuenta implements ICuenta {

    private RealCuenta cuenta;

    public String getCodigo() {
        return cuenta.getCodigo();
    }

    public void setCodigo(String codigo) {
        this.cuenta.setCodigo(codigo);
    }

    public ArrayList<Movimiento> getMovimientos() {
        return this.cuenta.getMovimientos();
    }

    public void setMovimientos(ArrayList<Movimiento> movimientos) {
        this.cuenta.setMovimientos(movimientos);
    }

    public Sucursal getSucursal() {
        return this.cuenta.getSucursal();
    }

    public void setSucursal(Sucursal sucursal) {
        this.cuenta.setSucursal(sucursal);
    }

    public Cliente getCliente() {
        return this.cuenta.getCliente();
    }

    public void setCliente(Cliente cliente) {
       this.cuenta.setCliente(cliente);
    }

    public Moneda getMoneda() {
       return this.cuenta.getMoneda();
    }

    public void setMoneda(Moneda moneda) {
        this.cuenta.setMoneda(moneda);
    }

    public double getSaldo() {
        return this.cuenta.getSaldo();
    }

    public void setSaldo(double saldo) {
        this.cuenta.setSaldo(saldo);
    }

    public Date getFecha_creacion() {
        return this.cuenta.getFecha_creacion();
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.cuenta.setFecha_creacion(fecha_creacion);
    }

    public String getEstado() {
        return this.cuenta.getEstado();
    }

    public void setEstado(String estado) {
        this.cuenta.setEstado(estado);
    }

    public int getCantida_movimiento() {
        return this.cuenta.getCantida_movimiento();
    }

    public void setCantida_movimiento(int cantida_movimiento) {
         this.cuenta.setCantida_movimiento(cantida_movimiento);
    }

    public String getClave() {
        return this.cuenta.getClave();
    }

    public void setClave(String clave) {
        this.cuenta.setClave(clave);
    }

    public String getCodigo_empleado() {
        return this.cuenta.getCodigo_empleado();
    }

    public void setCodigo_empleado(String codigo_empleado) {
        this.cuenta.setCodigo_empleado(codigo_empleado);
    }

    public RealCuenta getCuenta() {
        return this.cuenta;
    }

    public boolean validar_datos_cuenta(String cuenta_codigo, String password) {
        cuenta = Flogica.getInstance().getCuenta(cuenta_codigo);
        if (cuenta != null) {
            if (cuenta.validar_password(password)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean retiro(Double monto, boolean internet) {
        if (cuenta.retiro(monto, internet)) {
            String mensaje = Flogica.getInstance()
                    .retirar(cuenta.getMovimientos()
                            .get(cuenta.getMovimientos().size() - 1));
            if (mensaje.compareTo("ok") == 0) {
                return true;
            } else {
                JOptionPane.showMessageDialog(null, mensaje, "Error", 0);
            }
            return false;
        }
        return false;
    }

    @Override
    public boolean deposito(Double monto, boolean internet) {
        if (cuenta.deposito(monto, internet)) {
            String mensaje = Flogica.getInstance()
                    .depositar(cuenta.getMovimientos()
                            .get(cuenta.getMovimientos().size() - 1));
            if (mensaje.compareTo("ok") == 0) {
                return true;
            } else {
                JOptionPane.showMessageDialog(null, mensaje, "Error", 0);
            }
            return false;
        }
        return false;
    }

}
