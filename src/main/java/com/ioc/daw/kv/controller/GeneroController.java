/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ioc.daw.kv.controller;

import com.ioc.daw.kv.model.Genero;
import com.ioc.daw.kv.service.GeneroService;

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
public class GeneroController {
    
    @Autowired
    private GeneroService generoService;
    
    /**
     * Este método lista todos los generos
     * @return lista de géneros
     * RequestMapping(method=GET)
    */
    @GetMapping("generos")
    public List<Genero> getAllGenero(){
        
        return this.generoService.listaGeneros();
        
    }
}
