
package com.ioc.daw.kv.controller;

import com.ioc.daw.kv.exception.ResourceNotFoundException;
import com.ioc.daw.kv.model.Puntuacion;
import com.ioc.daw.kv.service.PuntuacionService;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Xavi
 */
@RestController
@RequestMapping("/api/v1/prod/")
@CrossOrigin
public class PuntuacionController {
    
    @Autowired
    private PuntuacionService puntuacionService;
    
    /**
     * Este método añade una puntuación a un producto
     * @param datos
     * @return una respuesta con Puntuado : True o error
     * @throws com.ioc.daw.kv.exception.ResourceNotFoundException
     * @throws org.json.JSONException
     * RequestMapping(method=POST)
    */    
    @Secured("ROLE_USER")
    @PostMapping("puntuar")
    public Map<String, Boolean> puntuarProducto (@RequestBody String datos) throws ResourceNotFoundException, JSONException{

        return this.puntuacionService.puntuarProducto(datos);
    }
    
    /**
     * Este método lista todos los id de los productos puntuados por un usuario 
     * @param email
     * @return lista de ids
     * @throws com.ioc.daw.kv.exception.ResourceNotFoundException
     * RequestMapping(method=GET)
    */
    @Secured("ROLE_USER")
    @GetMapping("puntuados")
    public List<Integer> listaIdsProductosPuntuados(@RequestParam("email") String email) throws ResourceNotFoundException{
        
        return this.puntuacionService.productosPuntuados(email);
    }

    /**
     * Este método lista todos los productos puntuados de un usuario 
     * @param email
     * @return lista de productos
     * @throws com.ioc.daw.kv.exception.ResourceNotFoundException
     * RequestMapping(method=GET)
    */
    @Secured("ROLE_USER")
    @GetMapping("listapuntuados")
    public List<Puntuacion> listaProductosPuntuados(@RequestParam("email") String email) throws ResourceNotFoundException{
        
        return this.puntuacionService.listaProdutosPuntuados(email);
    }
}
