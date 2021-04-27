package com.ioc.daw.kv.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Esta clase define el modelo de una Plataforma
 * La anotación @Table indica la tabla correspondiente a la base de datos
 */
@Entity
@Table(name = "plataforma")
public class Plataforma implements Serializable{

    private static final long serialVersionUID = 1L;
    
    /**
     * Atriuto id que se genera automaticamente.
     */
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_plataforma")
    private Integer id;
    
    private String nombre;
    
     /**
     * Constructor sin parámetros
     */
    public Plataforma() {
    }

    /**
     * Contructor con parámetros
     * @param nombre 
     */
    public Plataforma(String nombre) {
        this.nombre = nombre;
    }

    // Getters y Setters
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
        
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
   
}
