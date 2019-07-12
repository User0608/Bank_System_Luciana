/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template fecha_actualile, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba.datos;

import datos.operacion.OperacionDAL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.GregorianCalendar;

/**
 *
 * @author adriana
 */
public class TestOperacion {

    private static OperacionDAL op = new OperacionDAL();

    public static void main(String[] args) {
//        System.out.println(op.depositar("00100002", 1250.50));
//        System.out.println(op.retirar("00100002", 600));
        GregorianCalendar fecha_actual = new GregorianCalendar();

        Date date = new Date(fecha_actual.get(GregorianCalendar.YEAR)-1900,
                            fecha_actual.get(GregorianCalendar.MONTH)-1,
                            fecha_actual.get(GregorianCalendar.DAY_OF_MONTH));
        System.out.println(fecha_actual.toString());
        System.out.println("year->" + date.getYear() + " month ->" + date.getMonth() + " day ->" + date.getDate());
        System.out.println(date.toString());
    }
}
