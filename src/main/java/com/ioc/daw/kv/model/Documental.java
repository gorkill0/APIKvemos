package com.ioc.daw.kv.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Esta clase define el modelo de un Documental que extiende de Producto
 * @Table indica la correspondencia con la tabla de la base de datos
 * @PrimaryKeyJoinColumn indica la columna que se relaciona con la tabla
 * producto_audiovisual.
 */
@Entity
@Table(name = "documental")
@PrimaryKeyJoinColumn(name="id_documental")
public class Documental extends Producto {
    
//    private static final long serialVersionUID = 1L;

    /**
     * Constructor sin parámetros
     */
    public Documental() {
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
    public Documental(String titulo, String tituloOriginal, Integer duracion, Integer estreno, Integer edadMinima, String sinopsis, String caratula, Integer genero, Integer pais, List<Plataforma> plataformas) {
        super(titulo, tituloOriginal, duracion, estreno, edadMinima, sinopsis, caratula, genero, pais, plataformas);
    }
    
    
    
}
