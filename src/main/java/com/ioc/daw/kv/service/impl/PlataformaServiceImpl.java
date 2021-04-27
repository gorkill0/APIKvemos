/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ioc.daw.kv.service.impl;

import com.ioc.daw.kv.model.Plataforma;
import com.ioc.daw.kv.repository.PlataformaRepository;
import com.ioc.daw.kv.service.PlataformaService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Clase para realizar acciones con objetos Plataforma
 * @author Xavi
 */
@Service
public class PlataformaServiceImpl implements PlataformaService{

    @Autowired
    private PlataformaRepository plataformaRepository;
    
    /**
     * Método que devuelve una lista con todas las plataformas de la base de datos
     * @return lista de plataformas
     */
    @Override
    public List<Plataforma> listaPlataformas() {
        
        return this.plataformaRepository.findAll();
        
    }
    
}
