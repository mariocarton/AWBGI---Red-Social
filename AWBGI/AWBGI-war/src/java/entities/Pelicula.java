/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mario
 */
@Entity
@Table(name = "pelicula")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pelicula.findAll", query = "SELECT p FROM Pelicula p"),
    @NamedQuery(name = "Pelicula.findById", query = "SELECT p FROM Pelicula p WHERE p.id = :id"),
    @NamedQuery(name = "Pelicula.findByAno", query = "SELECT p FROM Pelicula p WHERE p.ano = :ano"),
    @NamedQuery(name = "Pelicula.findByDuracion", query = "SELECT p FROM Pelicula p WHERE p.duracion = :duracion"),
    @NamedQuery(name = "Pelicula.findByPais", query = "SELECT p FROM Pelicula p WHERE p.pais = :pais"),
    @NamedQuery(name = "Pelicula.findByDirector", query = "SELECT p FROM Pelicula p WHERE p.director = :director"),
    @NamedQuery(name = "Pelicula.findByGenero", query = "SELECT p FROM Pelicula p WHERE p.genero = :genero")})
public class Pelicula implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "ano")
    @Temporal(TemporalType.DATE)
    private Date ano;
    @Column(name = "duracion")
    private Integer duracion;
    @Size(max = 45)
    @Column(name = "pais")
    private String pais;
    @Size(max = 45)
    @Column(name = "director")
    private String director;
    @Size(max = 45)
    @Column(name = "genero")
    private String genero;
    @Lob
    @Size(max = 65535)
    @Column(name = "sinopsis")
    private String sinopsis;
    @OneToMany(mappedBy = "idpelicula")
    private List<Porver> porverList;
    @JoinColumn(name = "idusuario", referencedColumnName = "id")
    @ManyToOne
    private Usuario idusuario;
    @OneToMany(mappedBy = "idpelicula")
    private List<Valoracion> valoracionList;
    @OneToMany(mappedBy = "idpelicula")
    private List<Visto> vistoList;
    @OneToMany(mappedBy = "idpelicula")
    private List<Comentario> comentarioList;

    public Pelicula() {
    }

    public Pelicula(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getAno() {
        return ano;
    }

    public void setAno(Date ano) {
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

    @XmlTransient
    public List<Porver> getPorverList() {
        return porverList;
    }

    public void setPorverList(List<Porver> porverList) {
        this.porverList = porverList;
    }

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
    }

    @XmlTransient
    public List<Valoracion> getValoracionList() {
        return valoracionList;
    }

    public void setValoracionList(List<Valoracion> valoracionList) {
        this.valoracionList = valoracionList;
    }

    @XmlTransient
    public List<Visto> getVistoList() {
        return vistoList;
    }

    public void setVistoList(List<Visto> vistoList) {
        this.vistoList = vistoList;
    }

    @XmlTransient
    public List<Comentario> getComentarioList() {
        return comentarioList;
    }

    public void setComentarioList(List<Comentario> comentarioList) {
        this.comentarioList = comentarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pelicula)) {
            return false;
        }
        Pelicula other = (Pelicula) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Pelicula[ id=" + id + " ]";
    }
    
}
