/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Pelicula;

/**
 *
 * @author mariomatesanz
 */
public class GestorPeliculas {

    public String guardaPeliculas(Pelicula pelicula) {
        try {
            ConexionBD conexion = ConexionBD.getInstancia();
            String consulta = "insert into pelicula (idusuario,titulo,ano,duracion,pais,director,genero,sinopsis,ruta) values ("
                    + pelicula.getIdusuario()+","
                    +"'"+pelicula.getTitulo()+"',"
                    +pelicula.getAno()+","
                    +pelicula.getDuracion()+","
                    +"'"+pelicula.getPais()+"',"
                    +"'"+pelicula.getDirector()+"',"
                    +"'"+pelicula.getGenero()+"',"
                    +"'"+pelicula.getSinopsis()+"',"
                    +"'"+pelicula.getRuta()+"'"
                    +")";
            //System.out.println(consulta);
            conexion.ejecutaInserta(consulta);
            return "yes";
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Error en gestor de Peliculas: " + ex);
            return "Error en gestor de Peliculas";
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
                String titulo = resultado.getString("titulo");
                int ano = resultado.getInt("ano");
                int duracion = resultado.getInt("duracion");
                String pais = resultado.getString("pais");
                String director = resultado.getString("director");
                String genero = resultado.getString("genero");
                String sinopsis = resultado.getString("sinopsis");
                String ruta = resultado.getString("ruta");
                Pelicula pelicula = new Pelicula(id,idusuario,titulo,ano,duracion,pais,director,genero,sinopsis,ruta);
                return pelicula;
                
            } else {
                return null;
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Error: en gestor de Peliculas " + ex);
        }
        return null; 
    }
    
    
    public ArrayList extraePeliculas() {
        try {
            ConexionBD conexion = ConexionBD.getInstancia();
            String consulta = "select * from pelicula order by titulo";
            ResultSet resultado = conexion.ejecutaRecuperacion(consulta);
            ArrayList<Pelicula> arrayPeliculas = new ArrayList<>();
            while (resultado.next()) {
                int id = resultado.getInt("id");
                int idusuario = resultado.getInt("idusuario");
                String titulo = resultado.getString("titulo");
                int ano = resultado.getInt("ano");
                int duracion = resultado.getInt("duracion");
                String director = resultado.getString("director");
                String sinopsis = resultado.getString("genero");
                String pais = resultado.getString("pais");
                String genero = resultado.getString("sinopsis");
                String ruta = resultado.getString("ruta");
                Pelicula cm = new Pelicula(id,idusuario,titulo,ano,duracion,pais,director,genero,sinopsis,ruta);
                arrayPeliculas.add(cm);
                //System.out.println(id+ " "+idusuario+ " "+titulo + " " + ano + " " + duracion +" " + director + " " + pais + " " + genero + " " + sinopsis);
            }
            return arrayPeliculas;
            
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Error en gestor de Películas: " + ex);
        }
        return null;
    }
}
