
package com.ioc.daw.kv.controller;

import com.ioc.daw.kv.exception.ResourceNotFoundException;
import com.ioc.daw.kv.model.Documental;
import com.ioc.daw.kv.service.DocumentalService;

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
public class DocumentalController {
    
    @Autowired
    private DocumentalService documentalService;
    
    /**
     * Este método lista todos los documentales
     * @return lista de documentales
     * RequestMapping(method=GET)
    */
    @GetMapping("documentales")
    public List<Documental> getAllDocumental(){
        return this.documentalService.listaDocumentales();
    }
    
    /**
     * Este método guarda un nuevo Documental
     * @param documental
     * @return respuesta con el documental 
     * RequestMapping(method=POST)
    */
    @Secured("ROLE_ADMIN")
    @PostMapping("documentales")
    public ResponseEntity<Documental> createDocumental(@RequestBody Documental documental){
        
        return this.documentalService.agregarDocumental(documental);
        
    }
    
    /**
     * Este método actualiza un documental
     * @param id
     * @param documentalDetails
     * @return respuesta con el documental
     * @throws com.ioc.daw.kv.exception.ResourceNotFoundException
     * RequestMapping(method=PUT)
    */
    @Secured("ROLE_ADMIN")
    @PutMapping("documentales/{id}")
    public ResponseEntity<Documental> updateDocumental(@PathVariable(value = "id") Integer id, @Valid @RequestBody Documental documentalDetails) throws ResourceNotFoundException{
        
        return this.documentalService.modificarDocumental(documentalDetails, id);
        
    }
    
    /**
     * Este método elimina un documental
     * @param id
     * @return respuesta deleted:true o error
     * @throws com.ioc.daw.kv.exception.ResourceNotFoundException
     * RequestMapping(method=PUT)
    */
    @Secured("ROLE_ADMIN")
    @DeleteMapping("documentales/{id}")
    public Map<String, Boolean> deleteDocumental(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException{
        
        return this.documentalService.eliminarDocumental(id);
        
    }
    
    /**
     * Este método busca en la base de datos documentales que cumplan unos criterios.El método es POST para poder recibir los parametros de busqueda en el formato correcto.
     * @param datos
     * @return lista de documentales
     * @throws org.json.JSONException
     * RequestMapping(method=POST)
    */
    @PostMapping("documentales/buscar")
    public List<Documental> buscarDocumentales(@RequestBody String datos) throws JSONException{

        return this.documentalService.buscarConFiltros(datos);
        
    }
}
