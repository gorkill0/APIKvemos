/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ioc.daw.kv.service.impl;

import com.ioc.daw.kv.model.PeliculasMasVistas;
import com.ioc.daw.kv.repository.PeliculasMasVistasRepository;
import com.ioc.daw.kv.service.PeliculasMasVistasService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author Xavi
 */
@Service
public class PeliculasMasVistasServiceImpl implements PeliculasMasVistasService {
    
    @Autowired
    private PeliculasMasVistasRepository peliculasMasVistasRepository;
    
    @Override
    public List<PeliculasMasVistas> mostrarInforme() {
        return this.peliculasMasVistasRepository.findAll();
    }
    
}
