/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ioc.daw.kv.controller;

import com.ioc.daw.kv.model.Plataforma;
import com.ioc.daw.kv.service.PlataformaService;

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
public class PlataformaController {
   
    @Autowired
    private PlataformaService plataformaService;

    /**
     * Este método lista todas las plataformas
     * @return lista de plataformas
     * RequestMapping(method=GET)
    */
    @GetMapping("plataformas")
    public List<Plataforma> getAllPlataformas(){
        
        return this.plataformaService.listaPlataformas();
        
    }

 
}
