package modelo;

import java.sql.Blob;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mariomatesanz
 */
public class Pelicula {

    private int id;
    private int idusuario;
    private String titulo;
    private int ano;
    private int duracion;
    private String pais;
    private String director;
    private String genero;
    private String sinopsis;
    private String ruta;

    public Pelicula(int idusuario, String titulo, int ano, int duracion, String pais, String director, String genero, String sinopsis, String ruta) {
        //this.id = id;
        this.idusuario = idusuario;
        this.titulo = titulo;
        this.ano = ano;
        this.duracion = duracion;
        this.pais = pais;
        this.director = director;
        this.sinopsis = sinopsis;
        this.genero = genero;
        this.ruta = ruta;
    }

    public Pelicula(int id, int idusuario, String titulo, int ano, int duracion, String pais, String director, String genero, String sinopsis, String ruta) {
        this.id = id;
        this.idusuario = idusuario;
        this.titulo = titulo;
        this.ano = ano;
        this.duracion = duracion;
        this.pais = pais;
        this.director = director;
        this.sinopsis = sinopsis;
        this.genero = genero;
        this.ruta = ruta;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
}
