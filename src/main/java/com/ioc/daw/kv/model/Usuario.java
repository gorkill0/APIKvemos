package com.ioc.daw.kv.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Esta clase define el modelo de un Usuario
 * @Table indica la correspondencia con la tabla de la base de datos
 * @Inheritance indica la relación de herencia.
 */
@Entity
@Table(name = "usuario")
@Inheritance(strategy=InheritanceType.JOINED)
public class Usuario implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    /**
     * Atriuto id que se genera automaticamente.
     */
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer id;

    @NotNull
    @Size(max = 50)
    @Column(name = "email")
    private String email;

    @NotNull
    @Size(max = 8)
    @Column(name = "passwd")
    private String passwd;

    private String token;
    
    /**
     * Constructor sin parámetros
     */
    public Usuario() {
    }
    
    /**
     * Constructor con parámetros
     * @param email
     * @param passwd
     * @param token 
     */
    public Usuario(String email, String passwd, String token) {
        this.email = email;
        this.passwd = passwd;
        this.token = token;
    }

    // Getters y Setters
    
    public String getToken() {
        
        return token;
    }

    public void setToken(String token) {
        
        this.token = token;
    }

    public Integer getId() {
        
        return id;
    }

    public void setId(Integer id) {
        
        this.id = id;
    }

    public String getEmail() {
        
        return email;
    }

    public void setEmail(String email) {
        
        this.email = email;
    }

    public String getPasswd() {
        
        return passwd;
    }

    public void setPasswd(String passwd) {
        
        this.passwd = passwd;
    }

}