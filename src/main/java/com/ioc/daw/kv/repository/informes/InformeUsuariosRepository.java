
package com.ioc.daw.kv.repository.informes;

import com.ioc.daw.kv.model.informes.InformeUsuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interfaz que extiende de JpaRepository para realizar las operaciones de persistencia
 * @author Xavi
 */
@Repository
public interface InformeUsuariosRepository extends JpaRepository<InformeUsuarios, Integer> {
    
}
