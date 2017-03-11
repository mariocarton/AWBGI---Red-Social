/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.PorVer;

/**
 *
 * @author mariomatesanz
 */
public class GestorPorVer {
    
    
    public ArrayList extraePorVer(int idusuario) {
        try {
            ConexionBD conexion = ConexionBD.getInstancia();
            String consulta = "select * from porVer where idusuario='" + idusuario + "'";
            ResultSet resultado = conexion.ejecutaRecuperacion(consulta);
            ArrayList<PorVer> arrayVistas = new ArrayList<>();
            while (resultado.next()) {
                int id = resultado.getInt("id");
                int idpelicula = resultado.getInt("idpelicula");
                PorVer v = new PorVer(idusuario,idpelicula);
                arrayVistas.add(v);   
            }
            return arrayVistas;
            
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Error en gestor de PorVer: " + ex);
        }
        return null;
    }
    
    public void guardaPorVer(PorVer porver) {
        try {
            ConexionBD conexion = ConexionBD.getInstancia();
            String consulta = "insert into porVer "
                    + "(idusuario,idpelicula) values ("
                    + "'" + porver.getIdusuario() + "'"
                    + "'"+porver.getIdpelicula()+"'"
                    +")";
            conexion.ejecutaInserta(consulta);
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Error en gestor de Porver: " + ex);
        }
    }
}

