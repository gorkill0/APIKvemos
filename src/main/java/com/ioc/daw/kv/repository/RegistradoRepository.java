
package com.ioc.daw.kv.repository;

import com.ioc.daw.kv.model.Registrado;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interfaz que extiende de JpaRepository para realizar las operaciones de persistencia
 * @author Xavi
 */
public interface RegistradoRepository extends JpaRepository<Registrado, Integer>{
    
    /**
     * Método que devuelve un usuari Registrado cuyo email y password coincidan con
     * un registro de la tabla registrado.
     * JPA genera la consulta automaticamente mediante el nombre del método.
     * @param email
     * @param passwd
     * @return Registrado en caso de encontrarlo
     */
    public Optional<Registrado> findByEmailAndPasswd(String email, String passwd);
    
    /**
     * Método que devuelve un usuari Registrado cuyo email coincidan con
     * un registro de la tabla registrado.
     * JPA genera la consulta automaticamente mediante el nombre del método.
     * @param email
     * @return Registrado en caso de encontrarlo
     */
    public Optional<Registrado> findByEmail(String email);
}
