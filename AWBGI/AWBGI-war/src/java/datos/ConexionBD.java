/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author mario
 */
public class ConexionBD {
     // Este es el singleton
    private static ConexionBD laConexion;

    private final String urlBD = "jdbc:mysql://localhost:3306/awbgi";
    private final String userName = "root";
    private final String password = "";

    private final String driverName = "com.mysql.jdbc.Driver";

    private Connection conexion;

    // Garantiza que el cliente no cree objetos
    public ConexionBD() throws SQLException, ClassNotFoundException {
        Class.forName(driverName);
        conexion = (Connection) DriverManager.getConnection(urlBD, userName, password);
    }

    // devuelve el singleton
    public static ConexionBD getInstancia() throws SQLException, ClassNotFoundException {
        if (laConexion==null) laConexion = new ConexionBD();
        return laConexion;
    }

    public void cerrar() throws SQLException {
        conexion.close();
    }

    public void ejecutaInserta(String sql) throws SQLException {

        Statement st = (Statement) conexion.createStatement();

        st.executeUpdate(sql);
    }

    public ResultSet ejecutaRecuperacion(String sql) throws SQLException {

        Statement st = (Statement) conexion.createStatement();

        ResultSet resultado = st.executeQuery(sql);

        return resultado;
    }

}
