/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {

    private Connection conexion;
    public Statement sentencia;

    public Conexion() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {

        Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
        conexion = DriverManager.getConnection("jdbc:derby://localhost:1527/CajadelUnapec?user=CAJADELUNAPEC&password=CAJADELUNAPEC");
        sentencia = conexion.createStatement();
    }

    public void ejecutarSentencia(String sql) throws SQLException {
        sentencia.execute(sql);
    }

    public ResultSet ejecutaconsulta(String sql) throws SQLException {
        System.out.println(sql);
        return sentencia.executeQuery(sql);
    }
}
