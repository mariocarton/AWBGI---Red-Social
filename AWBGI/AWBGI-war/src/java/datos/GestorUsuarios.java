/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Usuario;

/**
 *
 * @author mario
 */
public class GestorUsuarios {
    
    public void guardaUsuario(Usuario usuario){
        try{
            ConexionBD conexion = ConexionBD.getInstancia();
            String consulta = "insert into usuario "
                    + "(apodo,nombre,apellidos,contraseña,tipo) values ("
                    + "'"+usuario.getApodo()+"',"
                    + "'"+usuario.getNombre()+"',"
                    + "'"+usuario.getApellidos()+"',"
                    + "'"+usuario.getContraseña()+"',"
                    + ""+usuario.getTipo()+""
                    + ")";
            conexion.ejecutaInserta(consulta);
            
        } catch(SQLException | ClassNotFoundException ex){
            System.out.println("Error en gestor de Usuarios: "+ex);
        }
    }
    
    public Usuario getUsuarioPorApodo(String a){
        try {
            ConexionBD conexion = ConexionBD.getInstancia();
            String consulta = "select * from usuario where apodo='" + a + "'";
            ResultSet resultado = conexion.ejecutaRecuperacion(consulta);
            if (resultado.next()) {
                int id = resultado.getInt("id");
                String apodo = resultado.getString("apodo");
                String pass = resultado.getString("contraseña");
                String nombre = resultado.getString("nombre");              
                String apellidos = resultado.getString("apellidos");
                int tipo = resultado.getInt("tipo");
                Usuario usuario = new Usuario(id, apodo, nombre, apellidos, pass, id);
                return usuario;
            } else {
                return null;
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Error: en gestor de usuarios " + ex);
        }
        return null;
    }
}
