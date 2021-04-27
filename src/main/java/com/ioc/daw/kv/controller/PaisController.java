/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ioc.daw.kv.controller;

import com.ioc.daw.kv.model.Pais;
import com.ioc.daw.kv.service.PaisService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Xavi
 */
@RestController
@RequestMapping("/api/v1/")
@CrossOrigin
public class PaisController {
    
    @Autowired
    private PaisService paisService;
    
    /**
     * Este método lista todos los paises
     * @return lista de paises
     * RequestMapping(method=GET)
    */
    @GetMapping("paises")
    public List<Pais> getAllPais(){
        
        return this.paisService.listaPaises();
        
    }
    
}
