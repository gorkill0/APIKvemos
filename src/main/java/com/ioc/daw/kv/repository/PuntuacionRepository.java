
package com.ioc.daw.kv.repository;

import com.ioc.daw.kv.model.Puntuacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interfaz que extiende de JpaRepository para realizar las operaciones de persistencia
 * @author Xavi
 */
@Repository
public interface PuntuacionRepository extends JpaRepository<Puntuacion, Integer>{
    
}
