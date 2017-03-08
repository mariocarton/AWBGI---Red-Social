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
    
    public ArrayList extraeVistas(int idusuario) {
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
}
