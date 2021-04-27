
package com.ioc.daw.kv.repository;

import com.ioc.daw.kv.model.Pais;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interfaz que extiende de JpaRepository para realizar las operaciones de persistencia
 * @author Xavi
 */
public interface PaisRepository extends JpaRepository<Pais, Integer>{
    
}
