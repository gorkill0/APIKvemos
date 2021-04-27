
package com.ioc.daw.kv.controller;

import com.ioc.daw.kv.exception.ResourceNotFoundException;
import com.ioc.daw.kv.model.Producto;
import com.ioc.daw.kv.model.Registrado;
import com.ioc.daw.kv.service.RegistradoService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Kvemos grupo 5 DAW
 * @version 1.0
 * 
 */
@RestController
@RequestMapping("/api/v1/")
@CrossOrigin
public class RegistradoController {
    
    @Autowired
    private RegistradoService registradoService;
    

    /**
     * Este método lista todos los usuarios registrados
     * @return List de Registrado
     * RequestMapping(method=GET)
    */
    @Secured("ROLE_ADMIN")
    @GetMapping("registrados")
    public List<Registrado> getAllRegistrado(){
        
        return this.registradoService.listaRegistrados();
        
    }

    /**
     * Este método devuelve un usuario REGISTRADO especificado con un id
     * @param registradoId 
     * @return Usuario
     * @throws com.ioc.daw.kv.exception.ResourceNotFoundException
     * RequestMapping(method=GET)
    */
    @Secured("ROLE_ADMIN")
    @GetMapping("/registrados/{id}")
    public ResponseEntity<Registrado> getUsuarioById(@PathVariable(value = "id") Integer registradoId ) throws ResourceNotFoundException {
        
        return this.registradoService.mostrarRegistrado(registradoId);
        
    }

    /**
     * Este método guarda un nuevo usuario REGISTRADO 
     * @param registrado JSON con email y passwd
     * @return Usuario
     * RequestMapping(method=POST)
    */
   
    @PostMapping("registrados")
    public ResponseEntity<Registrado> createRegistrado(@RequestBody Registrado registrado){
        
        return this.registradoService.agregarRegistrado(registrado);

    }

    /**
     * Este método actualiza un usuario REGISTRADO especificado con un id
     * @param registradoId
     * @param registradoDetails
     * @return Usuario
     * @throws com.ioc.daw.kv.exception.ResourceNotFoundException
     * RequestMapping(method=PUT)
    */
    @Secured("ROLE_USER")
    @PutMapping("registrados/{id}")
    public ResponseEntity<Registrado> updateRegistrado(@PathVariable(value = "id") Integer registradoId, @Valid @RequestBody Registrado registradoDetails) throws ResourceNotFoundException{
        
        return this.registradoService.modificarRegistrado(registradoDetails, registradoId);
        
    }

    /**
     * Este método elimina un usuario REGISTRADO especificado con un id
     * @param registradoId
     * @return respuesta deleted:true o error
     * @throws com.ioc.daw.kv.exception.ResourceNotFoundException 
     * RequestMapping(method=DELETE)
    */
    @Secured("ROLE_ADMIN")
    @DeleteMapping("registrados/{id}")
    public Map<String, Boolean> deleteRegistrado(@PathVariable(value = "id") Integer registradoId) throws ResourceNotFoundException{
       
        return this.registradoService.eliminarRegistrado(registradoId);
        
    }
    
    /**
     * Este método elimina un usuario REGISTRADO mediante credenciales
     * @param email
     * @param passwd
     * @return respuesta deleted:true o error
     * @throws com.ioc.daw.kv.exception.ResourceNotFoundException 
     * RequestMapping(method=DELETE)
    */
    @Secured("ROLE_USER")
    @DeleteMapping("registrados/baja")
    public Map<String, Boolean> darseBaja(@RequestParam("email") String email, @RequestParam("passwd") String passwd) throws ResourceNotFoundException{
        
        return this.registradoService.bajaRegistrado(email, passwd);
        
    }
    
    /**
     * Este método elimina un producto guardado de la lista de guardados de un usuario
     * @param id
     * @param email
     * @return respuesta eliminado
     * @throws com.ioc.daw.kv.exception.ResourceNotFoundException
     * RequestMapping(method=PUT)
    */   
    @Secured("ROLE_USER")
    @PutMapping("guardados/{idProducto}")
    public Map<String, Boolean> deleteProductoGuardado(@PathVariable(value = "idProducto") Integer id, @RequestParam("email") String email) throws ResourceNotFoundException{
       
        return this.registradoService.eliminarProductoGuardado(id, email);
       
    }  
    
        /**
     * Este método añade un Producto a la lista de guardados de un usuario
     * @param datos
     * @return una respuesta con Puntuado : True o error
     * @throws com.ioc.daw.kv.exception.ResourceNotFoundException
     * @throws org.json.JSONException
     * RequestMapping(method=POST)
    */    
    @Secured("ROLE_USER")
    @PostMapping("prod/guardar")
    public Map<String, Boolean> guardarProducto(@RequestBody String datos) throws ResourceNotFoundException, JSONException{
        
        return this.registradoService.guardarProducto(datos);
        
    }
    
    /**
     * Este método lista todos los id de los productos puntuados por un usuario 
     * @param email
     * @return lista de ids
     * @throws com.ioc.daw.kv.exception.ResourceNotFoundException
     * RequestMapping(method=GET)
    */
    @Secured("ROLE_USER")
    @GetMapping("prod/guardados")
    public List<Integer> listaIdsProductosGuardados (@RequestParam("email") String email) throws ResourceNotFoundException{
        
        return this.registradoService.productosGuardados(email);
    }
    
    
    /**
     * Este método lista todos los productos guardados por un usuario 
     * @param email
     * @return lista de productos
     * @throws com.ioc.daw.kv.exception.ResourceNotFoundException
     * RequestMapping(method=GET)
    */
    @Secured("ROLE_USER")
    @GetMapping("prod/listaguardados")
    public List<Producto> listaProductosGuardados (@RequestParam("email") String email) throws ResourceNotFoundException{
        
        return this.registradoService.listaProductosGuardados(email);
    }
    
}
