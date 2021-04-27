package com.ioc.daw.kv.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Esta clase define el modelo de un Producto (audiovisual)
 * @Table indica la correspondencia con la tabla de la base de datos
 * @Inheritance indica la relación de herencia.
 */
@Entity
@Table(name = "producto_audiovisual")
@Inheritance(strategy=InheritanceType.JOINED)
public class Producto implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    /**
     * Atriuto id que se genera automaticamente.
     */
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prod")
    private Integer id;
    
    private String titulo;
    
    @Column(name = "titulo_original")
    private String tituloOriginal;
    
    private Integer duracion;
    
    private Integer estreno;
    
    @Column(name = "media_puntuacion")
    private Float puntuacion = 0f;
    
    @Column(name = "edad_minima")
    private Integer edadMinima;
    
    private String sinopsis;
    
    private String caratula;
    
    @Column(name = "id_genero")
    private Integer genero;
    
    @Column(name = "id_pais")
    private Integer pais;

    /**
     * Atributo relacionado con la clase Plataforma, un Producto puede contener
     * varias plataformas
     * JoinTable indica la relación con la tabla oferta
     * ManyToMany indica una realción de muchos a muchos con la clase Plataforma
     */
    @JoinTable(
        name = "oferta",
        joinColumns = @JoinColumn(name = "id_prod", nullable = false),
        inverseJoinColumns = @JoinColumn(name="id_plataforma", nullable = false)
    )
    @ManyToMany()
    private List<Plataforma> plataformas;
    
    
    /**
     * Constructor sin parámetros
     */
    public Producto() {
    }

    /**
     * Constructor con parámetros, se omite id porque se genera automaticamente
     * @param titulo
     * @param tituloOriginal
     * @param duracion
     * @param estreno
     * @param edadMinima
     * @param sinopsis
     * @param caratula
     * @param genero
     * @param pais
     * @param plataformas 
     */
    public Producto(String titulo, String tituloOriginal, Integer duracion, Integer estreno, Integer edadMinima, String sinopsis, String caratula, Integer genero, Integer pais, List<Plataforma> plataformas) {
        this.titulo = titulo;
        this.tituloOriginal = tituloOriginal;
        this.duracion = duracion;
        this.estreno = estreno;
        this.edadMinima = edadMinima;
        this.sinopsis = sinopsis;
        this.caratula = caratula;
        this.genero = genero;
        this.pais = pais;
        this.plataformas = plataformas;
    }

    // Getters y Setters
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPais() {
        return pais;
    }

    public void setPais(Integer pais) {
        this.pais = pais;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public Integer getEstreno() {
        return estreno;
    }

    public void setEstreno(Integer estreno) {
        this.estreno = estreno;
    }

    public Float getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Float puntuacion) {
        this.puntuacion = puntuacion;
    }

    public Integer getEdadMinima() {
        return edadMinima;
    }

    public void setEdadMinima(Integer edadMinima) {
        this.edadMinima = edadMinima;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getCaratula() {
        return caratula;
    }

    public void setCaratula(String caratula) {
        this.caratula = caratula;
    }

    public Integer getGenero() {
        return genero;
    }

    public void setGenero(Integer genero) {
        this.genero = genero;
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTituloOriginal() {
        return tituloOriginal;
    }

    public void setTituloOriginal(String tituloOriginal) {
        this.tituloOriginal = tituloOriginal;
    }

    public List<Plataforma> getPlataformas() {
        return plataformas;
    }

    public void setPlataformas(List<Plataforma> plataforma) {
        this.plataformas = plataforma;
    }
    
//    public void addPlataforma(Plataforma plataforma){
//        if(this.plataformas == null){
//            this.plataformas= new ArrayList<>();
//        }
//        
//        this.plataformas.add(plataforma);
//    }
//    
            
}
