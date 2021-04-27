/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ioc.daw.kv.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * Clase utilizada para utilizar una clave primaria compuesta en la clase Puntuacion
 */
@Embeddable
public class PuntuacionClavePrimaria implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Column(name = "id_registrado")
    Integer idRegistrado;
 
    @Column(name = "id_prod")
    Integer idProducto;

    /**
     * Constructor sin parámetros
     */
    public PuntuacionClavePrimaria() {
    }

    /**
     * Constructor con parámetros
     * @param idRegistrado
     * @param idProducto 
     */
    public PuntuacionClavePrimaria(Integer idRegistrado, Integer idProducto) {
        this.idRegistrado = idRegistrado;
        this.idProducto = idProducto;
    }

    // Getter y Setters
    public Integer getIdRegistrado() {
        return idRegistrado;
    }

    public void setIdRegistrado(Integer idRegistrado) {
        this.idRegistrado = idRegistrado;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    // Métodos hashCode y equals
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.idRegistrado);
        hash = 59 * hash + Objects.hashCode(this.idProducto);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PuntuacionClavePrimaria other = (PuntuacionClavePrimaria) obj;
        if (!Objects.equals(this.idRegistrado, other.idRegistrado)) {
            return false;
        }
        if (!Objects.equals(this.idProducto, other.idProducto)) {
            return false;
        }
        return true;
    }
    
    
}
