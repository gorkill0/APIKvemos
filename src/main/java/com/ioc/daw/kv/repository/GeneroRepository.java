
package com.ioc.daw.kv.repository;

import com.ioc.daw.kv.model.Genero;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interfaz que extiende de JpaRepository para realizar las operaciones de persistencia
 * @author Xavi
 */
public interface GeneroRepository extends JpaRepository<Genero, Integer>{
    
}
