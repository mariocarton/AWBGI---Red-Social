/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Amigo;



/**
 *
 * @author mariomatesanz
 */
public class GestorAmigos {
    public void guardaAmistad(int id1, int id2) {
        try {
            ConexionBD conexion = ConexionBD.getInstancia();
            String consulta = "insert into amigo "
                    + "(idusuario,idamigo) values ("
                    + "'" + id1 + "'"
                    + "'"+id2+"'"
                    +")";
            conexion.ejecutaInserta(consulta);
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Error en gestor de Comentarios: " + ex);
        }
    }
    
    public ArrayList extraeAmigos(int idusuario) {
        try {
            ConexionBD conexion = ConexionBD.getInstancia();
            String consulta = "select * from amigo  where idusuario='" + idusuario + "'";
            ResultSet resultado = conexion.ejecutaRecuperacion(consulta);
            ArrayList<Amigo> arrayAmigos = new ArrayList<>();
            while (resultado.next()) {
                int id = resultado.getInt("id");
                int iduser = resultado.getInt("idusuario");
                int idamigo = resultado.getInt("idamigo");
                Amigo am = new Amigo(id,iduser,idamigo);
                arrayAmigos.add(am);
            }
            return arrayAmigos;
            
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Error en gestor de Comentarios: " + ex);
        }
        return null;
    }
    
}
