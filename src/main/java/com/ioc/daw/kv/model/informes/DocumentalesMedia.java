
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
 * Documentales con la media más alta, muestra 10 resultados
 * La anotación @Immutable indica que no se puede mostrar
 * La anotación @Subselect indica la vista
 */
@Entity
@Immutable
@Subselect("SELECT * FROM vista_mejores_documentales")
public class DocumentalesMedia implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column
    private Integer id;
    
    @Column
    private String titulo;
    
    @Column
    private Float media;

    /**
     * Constructor sin parámetros
     */
    public DocumentalesMedia() {
    }

    /**
     * Constructor con parámetros
     * @param id
     * @param titulo
     * @param media 
     */
    public DocumentalesMedia(Integer id, String titulo, Float media) {
        this.id = id;
        this.titulo = titulo;
        this.media = media;
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

    public Float getMedia() {
        return media;
    }

    public void setMedia(Float media) {
        this.media = media;
    }
    
}
