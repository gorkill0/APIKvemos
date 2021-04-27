package com.ioc.daw.kv.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

/**
 * Esta clase define el modelo de una puntuación, utiliza una clave primaria formada
 * por la clave primaria de las tablas registrado y producto_audiovisual
 * Representa una realción muchos a muchos entre Producto y Registrado
 * Para poder agregar el atributo puntuacion se ha de crear varias realciones ManyToOne
 * @Table indica la correspondencia con la tabla de la base de datos
 */
@Entity
@Table(name = "puntuar")
public class Puntuacion implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    // id 
    @EmbeddedId
    PuntuacionClavePrimaria id = new PuntuacionClavePrimaria();
    
    /**
     * Atributo Registrado relacionado con el Producto puntuado
     */
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER, optional = false)
    @MapsId("idRegistrado")
    @JoinColumn(name = "id_registrado")
    Registrado registrado;
 
    /**
     * Atributo Producto relacionado con el usuario Registrado que lo puntua
     */
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER, optional = false)
    @MapsId("idProducto")
    @JoinColumn(name = "id_prod")
    Producto producto;
 
    int puntuacion;

    /**
     * Constructor sin parámetros
     */
    public Puntuacion() {
    }

    /**
     * Constructor con parámetros
     * @param registrado
     * @param producto
     * @param puntuacion 
     */
    public Puntuacion(Registrado registrado, Producto producto, int puntuacion) {
        this.registrado = registrado;
        this.producto = producto;
        this.puntuacion = puntuacion;
    }

//    public PuntuacionClavePrimaria getId() {
//        return id;
//    }

//    public void setId(PuntuacionClavePrimaria id) {
//        this.id = id;
//    }

//    public Registrado getRegistrado() {
//        return registrado;
//    }

    // Getters y Setters
    
    public void setRegistrado(Registrado registrado) {
        this.registrado = registrado;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    
    
}
