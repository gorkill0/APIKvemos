
package com.ioc.daw.kv.service;

import com.ioc.daw.kv.exception.ResourceNotFoundException;
import com.ioc.daw.kv.model.Serie;

import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Xavi
 */
public interface SerieService {
    
    public List<Serie> listaSeries();
    public ResponseEntity<Serie> agregarSerie(Serie serie);
    public ResponseEntity<Serie> modificarSerie(Serie serie, Integer id) throws ResourceNotFoundException;
    public Map<String, Boolean> eliminarSerie(Integer id) throws ResourceNotFoundException;
    public List<Serie> buscarConFiltros(String filtros) throws JSONException;    
    
}