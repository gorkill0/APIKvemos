/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ioc.daw.kv.controller;

import com.ioc.daw.kv.exception.ResourceNotFoundException;
import com.ioc.daw.kv.model.Serie;
import com.ioc.daw.kv.service.SerieService;
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
@RequestMapping("/api/v1/")
@CrossOrigin
public class SerieController {
       
    @Autowired
    private SerieService serieService;
     
    /**
     * Este método lista todos los series
     * @return lista de series
     * RequestMapping(method=GET)
    */
    @GetMapping("series")
    public List<Serie> getAllSerie(){
        
        return this.serieService.listaSeries();

    }
    
    /**
     * Este método guarda un nuevo Serie
     * @param serie
     * @return respuesta con el serie 
     * RequestMapping(method=POST)
    */
    @Secured("ROLE_ADMIN")
    @PostMapping("series")
    public ResponseEntity<Serie> createSerie(@RequestBody Serie serie){

        return this.serieService.agregarSerie(serie);
        
    }
    
    /**
     * Este método actualiza un serie
     * @param id
     * @param serieDetails
     * @return respuesta con el serie
     * RequestMapping(method=PUT)
    */
    @Secured("ROLE_ADMIN")
    @PutMapping("series/{id}")
    public ResponseEntity<Serie> updateSerie(@PathVariable(value = "id") Integer id, @Valid @RequestBody Serie serieDetails) throws ResourceNotFoundException{
       
        return this.serieService.modificarSerie(serieDetails, id);
        
    }
    
    /**
     * Este método elimina un serie
     * @param id
     * @return respuesta deleted:true o error
     * RequestMapping(method=PUT)
    */    
    @Secured("ROLE_ADMIN")
    @DeleteMapping("series/{id}")
    public Map<String, Boolean> deleteSerie(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException{
        
        return this.serieService.eliminarSerie(id);
        
    }
 
    /**
     * Este método busca en la base de datos series que cumplan unos criterios.El método es POST para poder recibir los parametros de busqueda en el formato correcto.
     * @param datos
     * @return lista de series
     * RequestMapping(method=POST)
    */    
    @PostMapping("series/buscar")
    public List<Serie> buscarSeries(@RequestBody String datos) throws JSONException{

        return this.serieService.buscarConFiltros(datos);
        
    }
}