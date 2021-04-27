
package com.ioc.daw.kv.repository;

import com.ioc.daw.kv.model.Administrador;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interfaz que extiende de JpaRepository para realizar las operaciones de persistencia
 * @author Xavi
 */
public interface AdministradorRepository extends JpaRepository<Administrador, Integer> {
    
    /**
     * Método que devuelve un Administrador cuyo email y password coincidan con
     * un registro de la tabla administrador.
     * JPA genera la consulta automaticamente mediante el nombre del método.
     * @param email
     * @param passwd
     * @return Administrador en caso de encontrarlo
     */
    public Optional<Administrador> findByEmailAndPasswd(String email, String passwd);
    
}
