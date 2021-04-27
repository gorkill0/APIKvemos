
package com.ioc.daw.kv.repository;

import com.ioc.daw.kv.model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interfaz que extiende de JpaRepository para realizar las operaciones de persistencia
 * @author Xavi
 */
public interface PeliculaRepository extends JpaRepository<Pelicula, Integer>{
   
}
