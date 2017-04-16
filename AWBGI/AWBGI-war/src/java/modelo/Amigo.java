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
public class Amigo {
    int id;
    int idamigo;
    int idusuario;

    public Amigo(int id,int idusuario,int idamigo) {
        this.id = id;
        this.idamigo = idamigo;
        this.idusuario = idusuario;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdamigo() {
        return idamigo;
    }

    public void setIdamigo(int idamigo) {
        this.idamigo = idamigo;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

}
