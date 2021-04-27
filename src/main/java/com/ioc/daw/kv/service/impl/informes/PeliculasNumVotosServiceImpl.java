/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ioc.daw.kv.service.impl.informes;

import com.ioc.daw.kv.model.informes.PeliculasNumVotos;
import com.ioc.daw.kv.repository.informes.PeliculasNumVotosRepository;
import com.ioc.daw.kv.service.informes.PeliculasNumVotosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Xavi
 */
@Service
public class PeliculasNumVotosServiceImpl implements PeliculasNumVotosService {

    @Autowired
    private PeliculasNumVotosRepository peliculasNumVotosRepository;
    
    @Override
    public List<PeliculasNumVotos> mostrarInforme() {
        return this.peliculasNumVotosRepository.findAll();
    }
    
}
