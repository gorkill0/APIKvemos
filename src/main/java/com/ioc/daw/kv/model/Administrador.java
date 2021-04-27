package com.ioc.daw.kv.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Esta clase define el modelo de un usuario Administrador que extiende de Usuario
 * @Table indica la correspondencia con la tabla de la base de datos
 * @PrimaryKeyJoinColumn indica la columna que se relaciona con la tabla usuario.
 */
@Entity
@Table(name = "administrador")
@PrimaryKeyJoinColumn(name="id_admin")
public class Administrador extends Usuario{
    
    /**
     * Constructor sin parámetros
     */
    public Administrador() {
    }

    /**
     * Constructor con parámetros
     * @param email
     * @param passwd
     * @param token 
     */
    public Administrador(String email, String passwd, String token) {
        super(email, passwd, token);
    }
    
    
    
}
