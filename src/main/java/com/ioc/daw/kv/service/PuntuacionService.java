
package com.ioc.daw.kv.service;

import com.ioc.daw.kv.exception.ResourceNotFoundException;
import com.ioc.daw.kv.model.Puntuacion;
import java.util.List;
import java.util.Map;
import org.json.JSONException;

/**
 *
 * @author Xavi
 */
public interface PuntuacionService {
    
    public Map<String, Boolean> puntuarProducto(String datos) throws ResourceNotFoundException, JSONException;
    public List<Integer> productosPuntuados(String email) throws ResourceNotFoundException;
    public List<Puntuacion> listaProdutosPuntuados(String email) throws ResourceNotFoundException;
}
