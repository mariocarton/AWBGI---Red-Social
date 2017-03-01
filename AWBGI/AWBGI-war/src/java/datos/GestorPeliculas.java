/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Pelicula;

/**
 *
 * @author mariomatesanz
 */
public class GestorPeliculas {

    public void guardaPeliculas(Pelicula pelicula) {
        try {
            ConexionBD conexion = ConexionBD.getInstancia();
            String consulta = "insert into pelicula "
                    + "(id,idusuario,ano,duracion,pais,director,genero,sinopsis) values ("
                    + "'" + pelicula.getIdusuario() + "'"
                    + "'"+pelicula.getAno()+"'"
                    +"'"+pelicula.getAno()+"'"
                    +"'"+pelicula.getDuracion()+"'"
                    +"'"+pelicula.getPais()+"'"
                    +"'"+pelicula.getDirector()+"'"
                    +"'"+pelicula.getGenero()+"'"
                    +"'"+pelicula.getSinopsis()+"'"
                    +")";
            conexion.ejecutaInserta(consulta);
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Error en gestor de Peliculas: " + ex);
        }
    }
    
 
    
    public Pelicula getPeliculaPorId(int i){
        try{
            ConexionBD conexion = ConexionBD.getInstancia();
            String consulta = "select * from pelicula where id='" + i + "'";
            ResultSet resultado = conexion.ejecutaRecuperacion(consulta);
            if (resultado.next()) {
                int id = resultado.getInt("id");
                int idusuario =resultado.getInt("idusuario");
                Date ano = resultado.getDate("ano");
                int duracion = resultado.getInt("duracion");
                String pais = resultado.getString("pais");
                String director = resultado.getString("director");
                String genero = resultado.getString("genero");
                String sinopsis = resultado.getString("sinopsis");
                Pelicula pelicula = new Pelicula(id,idusuario,ano,duracion,pais,director,genero,sinopsis);
                return pelicula;
                
            } else {
                return null;
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Error: en gestor de Peliculas " + ex);
        }
        return null; 
    }
}
