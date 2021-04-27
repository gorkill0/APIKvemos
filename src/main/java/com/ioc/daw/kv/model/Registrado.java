package com.ioc.daw.kv.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Esta clase define el modelo de un usuario Registrado que extiende de Usuario
 * @Table indica la correspondencia con la tabla de la base de datos
 * @PrimaryKeyJoinColumn indica la columna que se relaciona con la tabla usuario.
 */

@Entity
@Table(name = "registrado")
@PrimaryKeyJoinColumn(name="id_registrado")
public class Registrado extends Usuario{
    
    //private static final long serialVersionUID = 1L;

    /**
     * Atributo relacionado con la clase Producto, un usuario Registrado
     * puede tener varios productos guardados para votar más tarde.
     * JoinTable indica la relación con la tabla guardar
     * ManyToMany indica una realción de muchos a muchos con la clase Producto
     */
    @JoinTable(
        name = "guardar",
        joinColumns = @JoinColumn(name = "id_registrado", nullable = false),
        inverseJoinColumns = @JoinColumn(name="id_prod", nullable = false)
    )
    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Producto> guardados;

    /**
     * Atributo que representa las puntuaciones realizadas por el usuario Registrado
     * sobre los diferentes productos
     * OneToMany indica la relación con la tabla puntuacion de la base de datos
     * mediante la clase Puntuacion (relación muchos a muchos con un atributo)
     */
    @OneToMany(mappedBy = "registrado")
    private List<Puntuacion> puntuaciones;

    /**
     * Constructor sin parámetros
     */
    public Registrado() {
        
    }
    
    /**
     * Método constructor con parámetros
     * @param token
     * @param email
     * @param passwd 
     */
    public Registrado(String email, String passwd, String token) {
        super(email, passwd, token);

    }
    
    // Getters y Setters
    
    public List<Producto> getGuardados() {
        
        return guardados;
    }

    public void setGuardados(List<Producto> gurdados) {
        
        this.guardados = gurdados;
    }
    
    public void addGuardado(Producto producto){
        
        if(this.guardados == null){
            this.guardados= new ArrayList<>();
        }
        
        this.guardados.add(producto);
    }
    
    public void deleteGuardado(Producto producto){
        
        if (this.guardados != null){
            this.guardados.remove(producto);
        }
    }
    
    public List<Puntuacion> getPuntuaciones() {
        
        return puntuaciones;
    }

    public void setPuntuaciones(List<Puntuacion> puntuaciones) {
        
        this.puntuaciones = puntuaciones;
    }
    
//    public void addPuntuacion(Puntuacion puntuacion){
//        if(this.puntuaciones == null){
//            this.puntuaciones= new ArrayList<>();
//        }
//        
//        this.puntuaciones.add(puntuacion);
//    }
}
