/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ioc.daw.kv.service.impl.informes;

import com.ioc.daw.kv.model.informes.PeliculasMedia;
import com.ioc.daw.kv.repository.informes.PeliculasMediaRepository;
import com.ioc.daw.kv.service.informes.PeliculasMediaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author Xavi
 */
@Service
public class PeliculasMediaServiceImpl implements PeliculasMediaService {
    
    @Autowired
    private PeliculasMediaRepository peliculasMediaRepository;
    
    @Override
    public List<PeliculasMedia> mostrarInforme() {
        return this.peliculasMediaRepository.findAll();
    }
    
}
