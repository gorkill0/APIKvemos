
package com.ioc.daw.kv.service;

import com.ioc.daw.kv.exception.ResourceNotFoundException;
import com.ioc.daw.kv.model.Pelicula;

import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Xavi
 */
public interface PeliculaService {
    
    public List<Pelicula> listaPeliculas();
    public ResponseEntity<Pelicula> agregarPelicula(Pelicula pelicula);
    public ResponseEntity<Pelicula> modificarPelicula(Pelicula pelicula, Integer id) throws ResourceNotFoundException;
    public Map<String, Boolean> eliminarPelicula(Integer id) throws ResourceNotFoundException;
    public List<Pelicula> buscarConFiltros(String filtros) throws JSONException;    
    
}
