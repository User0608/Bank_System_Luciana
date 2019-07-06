/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author adriana
 */
public abstract class DAL {

    protected Connection conexion = null;
    protected PreparedStatement prepared_statement = null;
    protected Statement statement = null;
    protected CallableStatement callable_statement = null;
    protected ResultSet result_set = null;
    
}
