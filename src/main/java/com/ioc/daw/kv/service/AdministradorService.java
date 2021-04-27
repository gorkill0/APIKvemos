
package com.ioc.daw.kv.service;

import com.ioc.daw.kv.exception.ResourceNotFoundException;
import com.ioc.daw.kv.model.Administrador;


/**
 *
 * @author Xavi
 */
public interface AdministradorService {
    
    public Administrador login(String email, String passwd) throws ResourceNotFoundException;
    
}
