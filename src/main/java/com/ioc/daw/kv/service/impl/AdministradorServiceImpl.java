
package com.ioc.daw.kv.service.impl;

import com.ioc.daw.kv.exception.ResourceNotFoundException;
import com.ioc.daw.kv.model.Administrador;
import com.ioc.daw.kv.repository.AdministradorRepository;
import com.ioc.daw.kv.security.TokenProvider;
import com.ioc.daw.kv.service.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Clase que permite realizar la acción de loguearse como Administrador
 * @author Xavi
 */
@Service
public class AdministradorServiceImpl implements AdministradorService{

    @Autowired
    private AdministradorRepository administradorRepository;
    
    @Autowired
    private TokenProvider tokenProvider;
    
    /**
     * Método que autentica un Administrador contra la base de datos y genera un
     * token de acceso
     * @param email
     * @param passwd
     * @return Administrador con el token generado
     * @throws ResourceNotFoundException 
     */
    @Override
    public Administrador login(String email, String passwd) throws ResourceNotFoundException {
        
        Administrador admin = administradorRepository.findByEmailAndPasswd(email, passwd)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario Administrador no encontrado:: " ));
        String token = tokenProvider.getJWTToken(email, "ROLE_ADMIN");
        admin.setToken(token);
        this.administradorRepository.save(admin);
        return admin;
        
    }
    
}
