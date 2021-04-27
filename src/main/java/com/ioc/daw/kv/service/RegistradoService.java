
package com.ioc.daw.kv.service;

import com.ioc.daw.kv.exception.ResourceNotFoundException;
import com.ioc.daw.kv.model.Producto;
import com.ioc.daw.kv.model.Registrado;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Xavi
 */
public interface RegistradoService {
    
    public List<Registrado> listaRegistrados();
    public ResponseEntity<Registrado> mostrarRegistrado(Integer id) throws ResourceNotFoundException;
    public ResponseEntity<Registrado> agregarRegistrado(Registrado registrado);
    public ResponseEntity<Registrado> modificarRegistrado(Registrado registrado, Integer id) throws ResourceNotFoundException;
    public Map<String, Boolean> eliminarRegistrado(Integer id) throws ResourceNotFoundException;
    public Map<String, Boolean> bajaRegistrado(String email, String passwd) throws ResourceNotFoundException;
    public Registrado login(String email, String passwd) throws ResourceNotFoundException;
    public Map<String, Boolean> recuperar(String email) throws ResourceNotFoundException, JSONException;
    public Map<String, Boolean> eliminarProductoGuardado(Integer idProducto, String email) throws ResourceNotFoundException;
    public Map<String, Boolean> guardarProducto(String datos) throws ResourceNotFoundException, JSONException;
    public List<Integer> productosGuardados(String email) throws ResourceNotFoundException;
    public List<Producto> listaProductosGuardados(String email) throws ResourceNotFoundException;
    
}
