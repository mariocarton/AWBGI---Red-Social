/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author mariomatesanz
 */
public class PorVer {

    int id;
    int idusuario;
    int idpelicula;

    public PorVer(int id,int idusuario,int idpelicula) {
        this.id = id;
        this.idusuario = idusuario;
        this.idpelicula = idpelicula;
    }
    public PorVer(int idusuario,int idpelicula) {
        //this.id = id;
        this.idusuario = idusuario;
        this.idpelicula = idpelicula;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdpelicula() {
        return idpelicula;
    }

    public void setIdpelicula(int idpelicula) {
        this.idpelicula = idpelicula;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }
}
