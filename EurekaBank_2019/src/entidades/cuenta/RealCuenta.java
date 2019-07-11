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
    private double saldo;
    private Date fecha_creacion;
    private String estado;
    private int cantida_movimiento;
    private String clave;
    private String codigo_empleado;

    public RealCuenta() {
        sucursal = new Sucursal();
        cliente = new Cliente();
        moneda = new Moneda();
        movimientos = new ArrayList<>();
    }

    public RealCuenta(String codigo, ArrayList<Movimiento> movimientos, Sucursal sucursal, Cliente cliente, Moneda moneda, double saldo, Date fecha_creacion, String estado, int cantida_movimiento, String clave, String codigo_empleado) {
        this.codigo = codigo;
        this.movimientos = movimientos;
        this.sucursal = sucursal;
        this.cliente = cliente;
        this.moneda = moneda;
        this.saldo = saldo;
        this.fecha_creacion = fecha_creacion;
        this.estado = estado;
        this.cantida_movimiento = cantida_movimiento;
        this.clave = clave;
        this.codigo_empleado = codigo_empleado;
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

    public String getCodigo_empleado() {
        return codigo_empleado;
    }

    public void setCodigo_empleado(String codigo_empleado) {
        this.codigo_empleado = codigo_empleado;
    }

    @Override
    public String toString() {
        return "RealCuenta{" + "codigo=" + codigo + ", movimientos=" + movimientos.size()
                + ",\nsucursal=" + sucursal.toString() + ",\ncliente=" + cliente.toString()
                + ",\nmoneda=" + moneda.toString() + ", saldo=" + saldo + ", fecha_creacion=" + fecha_creacion.toString()
                + ", estado=" + estado + ", cantida_movimiento=" + cantida_movimiento + ", clave=" + clave + ",codigo_empleado=" + codigo_empleado + '}';
    }

    @Override
    public boolean depositar() {
        return true;
    }

    public boolean validar_password(String clave) {
        return (this.clave.compareTo(clave) == 0) ? true : false;
    }

}
