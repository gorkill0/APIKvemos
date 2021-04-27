/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ioc.daw.kv.service.impl;

import com.ioc.daw.kv.model.InformeUsuarios;
import com.ioc.daw.kv.repository.InformeUsuariosRepository;
import com.ioc.daw.kv.service.InformesUsuariosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Xavi
 */
@Service
public class InformesUsuariosServiceImpl implements InformesUsuariosService{

    @Autowired
    InformeUsuariosRepository informeUsuariosRepository;
    
    @Override
    public List<InformeUsuarios> mostrarInforme() {
        return this.informeUsuariosRepository.findAll();
    }
    
}
