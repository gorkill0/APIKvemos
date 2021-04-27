/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ioc.daw.kv.controller;

import com.ioc.daw.kv.exception.ResourceNotFoundException;
import com.ioc.daw.kv.model.Administrador;
import com.ioc.daw.kv.model.Registrado;
import com.ioc.daw.kv.service.AdministradorService;
import com.ioc.daw.kv.service.RegistradoService;
import java.util.Map;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Xavi
 */
@RestController
@RequestMapping("/api/v1/")
@CrossOrigin
public class LoginController {
    
    @Autowired
    private RegistradoService registradoService;
    
    @Autowired
    private AdministradorService administradorService;
    
    /**
     * Este método realiza el login de un usuario Registrado
     * @param email
     * @param passwd
     * @return Registrado
     * @throws com.ioc.daw.kv.exception.ResourceNotFoundException
     * RequestMapping(method=POST)
    */
    @PostMapping("registrados/login")
    public Registrado userLogin(@RequestParam("email") String email, @RequestParam("passwd") String passwd) throws ResourceNotFoundException{
        
        return this.registradoService.login(email, passwd);
        
    }
    
    /**
     * Este método realiza el login de un Administrador
     * @param email
     * @param passwd
     * @return Administrador
     * @throws com.ioc.daw.kv.exception.ResourceNotFoundException
     * RequestMapping(method=POST)
    */
    @PostMapping("admin/login")
    public Administrador adminLogin(@RequestParam("email") String email, @RequestParam("passwd") String passwd) throws ResourceNotFoundException{
        
        return this.administradorService.login(email, passwd);
        
    }
    
    /**
     * Este método devuelve True si existe un usuario con el email pasado como parámetro
     * @param email
     * @return true o usuario no encontrado
     * @throws com.ioc.daw.kv.exception.ResourceNotFoundException
     * @throws org.json.JSONException
     * RequestMapping(method=GET)
    */
    @GetMapping("registrados/recuperar")
    public Map<String, Boolean> existeEmail(@RequestParam("email") String email) throws ResourceNotFoundException, JSONException{
        
        return this.registradoService.recuperar(email);
    }
}
