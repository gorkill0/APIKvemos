/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ioc.daw.kv.service.impl.informes;

import com.ioc.daw.kv.model.informes.DocumentalesNumVotos;
import com.ioc.daw.kv.repository.informes.DocumentalesNumVotosRepository;
import com.ioc.daw.kv.service.informes.DocumentalesNumVotosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Xavi
 */
@Service
public class DocumentalesNumVotosServiceImpl implements DocumentalesNumVotosService {

    @Autowired
    private DocumentalesNumVotosRepository documentalesNumVotosRepository;
    
    @Override
    public List<DocumentalesNumVotos> mostrarInforme() {
        return this.documentalesNumVotosRepository.findAll();
    }
    
}

