/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ioc.daw.kv.controller;

import com.ioc.daw.kv.exception.ResourceNotFoundException;
import com.ioc.daw.kv.model.Pelicula;

import com.ioc.daw.kv.service.PeliculaService;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;


import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Xavi
 */
@RestController
@RequestMapping("/api/v1/pel/")
@CrossOrigin
public class PeliculaController {
    
    @Autowired
    private PeliculaService peliculaService;
    
    
    /**
     * Este método lista todas las peliculas
     * @return List de Registrado
     * RequestMapping(method=GET)
    */
    @GetMapping("peliculas")
    public List<Pelicula> getAllPelicula(){
        return this.peliculaService.listaPeliculas();
    }
    
    /**
     * Este método guarda una nueva pelicula
     * @param pelicula JSON con todos los datos
     * @return Pelicula
     * RequestMapping(method=POST)
    */
    @Secured("ROLE_ADMIN")
    @PostMapping("peliculas")
    public ResponseEntity<Pelicula> createPelicula(@RequestBody Pelicula pelicula){

        return this.peliculaService.agregarPelicula(pelicula);
    }
    
    /**
     * Este método actualiza una pelicula
     * @param id
     * @param peliculaDetails
     * @return respuesta con la pelicula
     * @throws com.ioc.daw.kv.exception.ResourceNotFoundException
     * RequestMapping(method=PUT)
    */    
    @Secured("ROLE_ADMIN")
    @PutMapping("peliculas/{id}")
    public ResponseEntity<Pelicula> updatePelicula(@PathVariable(value = "id") Integer id, @Valid @RequestBody Pelicula peliculaDetails) throws ResourceNotFoundException{
       
        return this.peliculaService.modificarPelicula(peliculaDetails, id);
        
    }
    
    /**
     * Este método elimina una pelicula
     * @param id
     * @return respuesta deleted:true o error
     * @throws com.ioc.daw.kv.exception.ResourceNotFoundException
     * RequestMapping(method=PUT)
    */    
    @Secured("ROLE_ADMIN")
    @DeleteMapping("peliculas/{id}")
    public Map<String, Boolean> deletePelicula(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException{
       
        return this.peliculaService.eliminarPelicula(id);
        
    }  
    
    /**
     * Este método busca en la base de datos peliculas que cumplan unos criterios.El método es POST para poder recibir los parametros de busqueda en el formato correcto.
     * @param datos
     * @return lista de peliculas
     * @throws org.json.JSONException
     * RequestMapping(method=POST)
    */
    @PostMapping("peliculas/buscar")
    public List<Pelicula> buscarPeliculas(@RequestBody String datos) throws JSONException{

        return this.peliculaService.buscarConFiltros(datos);
        
    }
    

    
  
}
