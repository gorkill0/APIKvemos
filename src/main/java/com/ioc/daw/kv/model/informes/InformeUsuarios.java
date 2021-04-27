
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
 * Usuarios más activos (con más puntuaciones realizadas), muestra 10 resultados
 * La anotación @Immutable indica que no se puede mostrar
 * La anotación @Subselect indica la vista
 */
@Entity
@Immutable
@Subselect("SELECT * FROM vista_usuarios_mas_activos")
public class InformeUsuarios implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column
    private Integer id;
    
    @Column
    private String email;
    
    @Column
    private Integer puntuados;

    /**
     * Constructor sin parámetros
     */
    public InformeUsuarios() {
    }

    /**
     * Constructor con parámetros
     * @param id
     * @param email
     * @param puntuados 
     */
    public InformeUsuarios(Integer id, String email, Integer puntuados) {
        this.id = id;
        this.email = email;
        this.puntuados = puntuados;
    }

    // Getters y Setters
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPuntuados() {
        return puntuados;
    }

    public void setPuntuados(Integer puntuados) {
        this.puntuados = puntuados;
    }
    
    
}
