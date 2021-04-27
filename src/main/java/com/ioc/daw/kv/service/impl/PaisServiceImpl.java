
package com.ioc.daw.kv.service.impl;

import com.ioc.daw.kv.model.Pais;
import com.ioc.daw.kv.repository.PaisRepository;
import com.ioc.daw.kv.service.PaisService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Clase para realizar acciones con objertos Pais
 * @author Xavi
 */
@Service
public class PaisServiceImpl implements PaisService {

    @Autowired
    private PaisRepository paisRepository;
    
    /**
     * Método que devuelve una lista con todos los paises de la base de datos
     * @return lista de paises
     */
    @Override
    public List<Pais> listaPaises() {
        
        return this.paisRepository.findAll();
        
    }
    
}
