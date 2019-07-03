/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

/**
 *
 * @author adriana
 */
public class Conexion {
        public static Connection establecerConexion() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/eurekabank";
        String user = "root";
        String password = "";
        return DriverManager.getConnection(url, user, password);
    }

    public static void main(String[] args) {
        try {
            Connection cn = Conexion.establecerConexion();
            System.out.println("\nConexión establecida");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("\nConexión fallida: " + ex.toString());
        }
    }
}
