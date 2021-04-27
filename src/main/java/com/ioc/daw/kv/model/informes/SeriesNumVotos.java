/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ioc.daw.kv.model.informes;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

/**
 *
 * Clase que modela los resultados obtenidos de una vista de la base de datos
 * Series que mas veces han sida votadas, muestra 10 resultados
 * La anotación @Immutable indica que no se puede mostrar
 * La anotación @Subselect indica la vista
 */
@Entity
@Immutable
@Subselect("SELECT * FROM vista_ser_mas_votadas")
public class SeriesNumVotos implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column
    private Integer id;
    
    @Column
    private String titulo;
    
    @Column
    private Integer votos;

    /**
     * Constructor sin parámetros
     */
    public SeriesNumVotos() {
    }

    /**
     * Constructor con parámetros
     * @param id
     * @param titulo
     * @param votos 
     */
    public SeriesNumVotos(Integer id, String titulo, Integer votos) {
        this.id = id;
        this.titulo = titulo;
        this.votos = votos;
    }

    // Getters y Setters
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getVotos() {
        return votos;
    }

    public void setVotos(Integer votos) {
        this.votos = votos;
    }
    
    
}