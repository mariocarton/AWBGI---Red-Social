/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Visto;

/**
 *
 * @author mariomatesanz
 */
public class GestorVistas {
    
    public ArrayList<Visto> extraeVistas(int idusuario) {
        try {
            ConexionBD conexion = ConexionBD.getInstancia();
            String consulta = "select * from visto where idusuario='" + idusuario + "'";
            ResultSet resultado = conexion.ejecutaRecuperacion(consulta);
            ArrayList<Visto> arrayVistas = new ArrayList<>();
            while (resultado.next()) {
                int id = resultado.getInt("id");
                int idpelicula = resultado.getInt("idpelicula");
                Visto v = new Visto(idusuario,idpelicula);
                arrayVistas.add(v);   
            }
            return arrayVistas;
            
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Error en gestor de Vistas: " + ex);
        }
        return null;
    }
    
    public void guardaVisto(Visto visto) {
        try {
            ConexionBD conexion = ConexionBD.getInstancia();
            String consulta = "insert into visto "
                    + "(idusuario,idpelicula) values ("
                    + "" + visto.getIdusuario() + ","
                    + ""+visto.getIdpelicula()+""
                    +")";
            conexion.ejecutaInserta(consulta);
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Error en gestor de Vistas (guardaVisto): " + ex);
        }
    }
    
    public void eliminaVisto(int idusuario, int idpelicula){
        try {
            ConexionBD conexion = ConexionBD.getInstancia();
            String consulta = "DELETE FROM visto "
                    + "WHERE idusuario = '"+idusuario+"' AND idpelicula = '"+idpelicula+"'";
            conexion.ejecutaInserta(consulta);
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Error en gestor de Vistas (eliminaVisto): " + ex);
        }
    }
}
