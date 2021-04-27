
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
 * Documentales que mas veces han sido votados, muestra 10 resultados
 * La anotación @Immutable indica que no se puede mostrar
 * La anotación @Subselect indica la vista
 */
@Entity
@Immutable
@Subselect("SELECT * FROM vista_doc_mas_votadas")
public class DocumentalesNumVotos implements Serializable{
    
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
    public DocumentalesNumVotos() {
    }

    /**
     * Constructor con parámetros
     * @param id
     * @param titulo
     * @param votos 
     */
    public DocumentalesNumVotos(Integer id, String titulo, Integer votos) {
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
