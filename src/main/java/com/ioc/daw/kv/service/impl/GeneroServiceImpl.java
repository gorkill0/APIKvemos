
package com.ioc.daw.kv.service.impl;

import com.ioc.daw.kv.model.Genero;
import com.ioc.daw.kv.repository.GeneroRepository;
import com.ioc.daw.kv.service.GeneroService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Clase para realizar acciones con objetos Genero
 * @author Xavi
 */
@Service
public class GeneroServiceImpl implements GeneroService{

    @Autowired
    private GeneroRepository generoRepository;
    
    /**
     * Método que devuelve la lista con todos los generos
     * @return lista de géneros
     */
    @Override
    public List<Genero> listaGeneros() {
        
        return this.generoRepository.findAll();
        
    }
    
}
