
package com.ioc.daw.kv.service;

import com.ioc.daw.kv.exception.ResourceNotFoundException;
import com.ioc.daw.kv.model.Documental;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Xavi
 */
public interface DocumentalService {
    
    public List<Documental> listaDocumentales();
    public ResponseEntity<Documental> agregarDocumental(Documental documental);
    public ResponseEntity<Documental> modificarDocumental(Documental documental, Integer id) throws ResourceNotFoundException;
    public Map<String, Boolean> eliminarDocumental(Integer id) throws ResourceNotFoundException;
    public List<Documental> buscarConFiltros(String filtros) throws JSONException;
    
}
