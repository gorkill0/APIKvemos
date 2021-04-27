package com.ioc.daw.kv.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Esta clase define el modelo de una Serie que extiende de Producto
 * @Table indica la correspondencia con la tabla de la base de datos
 * @PrimaryKeyJoinColumn indica la columna que se relaciona con la tabla
 * producto_audiovisual.
 */
@Entity
@Table(name = "serie")
@PrimaryKeyJoinColumn(name="id_serie")
public class Serie extends Producto {
    
//    private static final long serialVersionUID = 1L;

    private Integer capitulos;
    
    private Integer temporadas;

    /**
     * Constructor sin parámetros
     */
    public Serie() {
    }
    
//    public Serie(Integer capitulos, Integer temporadas) {
//        this.capitulos = capitulos;
//        this.temporadas = temporadas;
//    }

    /**
     * Constructor con parámetros, se omite id porque se genera automaticamente
     * @param capitulos
     * @param temporadas
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
    public Serie(String titulo, String tituloOriginal, Integer duracion, Integer estreno, Integer edadMinima, String sinopsis, String caratula, Integer genero, Integer pais, List<Plataforma> plataformas, Integer capitulos, Integer temporadas) {
        super(titulo, tituloOriginal, duracion, estreno, edadMinima, sinopsis, caratula, genero, pais, plataformas);
        this.capitulos = capitulos;
        this.temporadas = temporadas;
    }

    // Getters y Setters
    public Integer getCapitulos() {
        return capitulos;
    }

    public void setCapitulos(Integer capitulos) {
        this.capitulos = capitulos;
    }

    public Integer getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(Integer temporadas) {
        this.temporadas = temporadas;
    }
    
    
    
}
