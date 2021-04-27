/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ioc.daw.kv.controller;

import com.ioc.daw.kv.exception.ResourceNotFoundException;
import com.ioc.daw.kv.model.Producto;
import com.ioc.daw.kv.service.ProductoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Xavi
 */
@RestController
@RequestMapping("/api/v1/prod/")
@CrossOrigin
public class ProductoController {
    
    @Autowired
    private ProductoService productoService;
    
    
    /**
     * Este método busca los productos que coincidan con la variable titulo (barra buscador)
     * @param titulo
     * @return lista Productos
     * @throws com.ioc.daw.kv.exception.ResourceNotFoundException
     * RequestMapping(method=GET)
    */    
    @GetMapping("/buscador/{titulo}")
    public List<Producto> getProductosByTitulo(@PathVariable(value = "titulo") String titulo ) throws ResourceNotFoundException{
          
        List<Producto> listadoProductos = productoService.buscarBuscador(titulo);
        return listadoProductos;
                
    }
    

            
}
