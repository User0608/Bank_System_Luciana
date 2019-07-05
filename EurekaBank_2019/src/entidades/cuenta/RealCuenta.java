/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.cuenta;

import entidades.Cliente;
import entidades.Sucursal;
import entidades.moneda.Moneda;
import entidades.movimiento.Movimiento;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author adriana
 */
public class RealCuenta implements ICuenta {

    private String codigo;
    private ArrayList<Movimiento> movimientos;
    private Sucursal sucursal;
    private Cliente cliente;
    private Moneda moneda;
    private String numero_cuenta;
    private double saldo;
    private Date fecha_creacion;
    private String estado;
    private int cantida_movimiento;
    private String clave;

    public RealCuenta(String codigo, ArrayList<Movimiento> movimientos, Sucursal sucursal, Cliente cliente,
            Moneda moneda, String numero_cuenta, double saldo, Date fecha_creacion, String estado, int cantida_movimiento, String clave) {
        this.codigo = codigo;
        this.movimientos = movimientos;
        this.sucursal = sucursal;
        this.cliente = cliente;
        this.moneda = moneda;
        this.numero_cuenta = numero_cuenta;
        this.saldo = saldo;
        this.fecha_creacion = fecha_creacion;
        this.estado = estado;
        this.cantida_movimiento = cantida_movimiento;
        this.clave = clave;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public ArrayList<Movimiento> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(ArrayList<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Moneda getMoneda() {
        return moneda;
    }

    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
    }

    public String getNumero_cuenta() {
        return numero_cuenta;
    }

    public void setNumero_cuenta(String numero_cuenta) {
        this.numero_cuenta = numero_cuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCantida_movimiento() {
        return cantida_movimiento;
    }

    public void setCantida_movimiento(int cantida_movimiento) {
        this.cantida_movimiento = cantida_movimiento;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public boolean depositar() {
        return true;
    }

}
