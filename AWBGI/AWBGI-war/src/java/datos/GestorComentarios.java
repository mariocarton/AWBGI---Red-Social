/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Comentario;


/**
 *
 * @author mariomatesanz
 */
public class GestorComentarios {
    
    public void guardaComentario(Comentario comentario) {
        try {
            ConexionBD conexion = ConexionBD.getInstancia();
            String consulta = "insert into comentario "
                    + "(id,idusuario,idpelicula,titulo,texto) values ("
                    + "'" + comentario.getIdusuario() + "'"
                    + "'"+comentario.getIdpelicula()+"'"
                    +"'"+comentario.getTitulo()+"'"
                    +"'"+comentario.getTexto()+"'"
                    +")";
            conexion.ejecutaInserta(consulta);
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Error en gestor de Comentarios: " + ex);
        }
    }
    
  public ArrayList extraeComentarios(int idpelicula) {
        try {
            ConexionBD conexion = ConexionBD.getInstancia();
            String consulta = "select * from comentario  where idpelicula='" + idpelicula + "'";
            ResultSet resultado = conexion.ejecutaRecuperacion(consulta);
            ArrayList<Comentario> arrayComentarios = new ArrayList<>();
            while (resultado.next()) {
                int id = resultado.getInt("id");
                int idusuario = resultado.getInt("idusuario");
                String titulo = resultado.getString("titulo");
                String texto = resultado.getString("texto");
                Comentario cm = new Comentario(id,idusuario,idpelicula,titulo,texto);
                arrayComentarios.add(cm);
                
            }
            return arrayComentarios;
            
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Error en gestor de Comentarios: " + ex);
        }
        return null;
    }
    
}
