/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {

    private static Connection cn = null;
    private static Driver driver = new org.apache.derby.jdbc.ClientDriver();
    private static String URLDerby = "jdbc:derby://localhost:1527/CajadelUnapec";
    private static String usuario = "CAJADELUNAPEC";
    private static String contrasena = "CAJADELUNAPEC";

    public static Connection getConexion() throws SQLException {
        System.out.println("***Mensaje 1***");
        if (cn == null) {
            iniciarConexion();
        }
        System.out.println("***Mensaje 2***");
        return cn;
    }

    public static void iniciarConexion() throws SQLException {
        DriverManager.registerDriver(driver);
        cn = DriverManager.getConnection(URLDerby, usuario, contrasena);
    }

    public static ResultSet ejecutarConsulta(String sql) {
        ResultSet rs = null;
        try {
            Statement st = cn.createStatement();
            rs = st.executeQuery(sql);
        } catch (Throwable e) {
            System.out.println("Ha fallado la consulta de datos la BD. " + e.getMessage());
//e.printStackTrace();
        }
        return rs;
    }

    public static void ejecutarSentencia(String sql) {
        
        try {
            System.out.println(sql);
            Statement st = cn.createStatement();
            st.executeUpdate(sql);
        } catch (Throwable e) {
            System.out.println("***Ha fallado la sentencia de base de datos***"+ e.getMessage());
            e.printStackTrace();
        }
    }

}
