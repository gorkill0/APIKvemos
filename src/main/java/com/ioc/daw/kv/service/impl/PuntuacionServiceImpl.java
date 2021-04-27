
package com.ioc.daw.kv.service.impl;

import com.ioc.daw.kv.exception.ResourceNotFoundException;
import com.ioc.daw.kv.model.Producto;
import com.ioc.daw.kv.model.Puntuacion;
import com.ioc.daw.kv.model.Registrado;
import com.ioc.daw.kv.repository.ProductoRepository;
import com.ioc.daw.kv.repository.PuntuacionRepository;
import com.ioc.daw.kv.repository.RegistradoRepository;
import com.ioc.daw.kv.service.PuntuacionService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Clase para trabajar con objetos Puntuacion
 * @author Xavi
 */
@Service
public class PuntuacionServiceImpl implements PuntuacionService{
    
    @Autowired
    private PuntuacionRepository puntuacionRepository;

    @Autowired
    private ProductoRepository productoRepository;
    
    @Autowired
    private RegistradoRepository registradoRepository;
    
    /**
     * Método que permite agregar una puntuación nueva sobre un producto y guardarla 
     * en la tabla puntuar.
     * @param datos
     * @return una respuesta con Puntuado : True|False
     * @throws ResourceNotFoundException
     * @throws JSONException 
     */
    @Override
    public Map<String, Boolean> puntuarProducto(String datos) throws ResourceNotFoundException, JSONException{
       JSONObject objetoJson = new JSONObject(datos);
        
        String email = objetoJson.getString("email");
        int idProducto = objetoJson.getInt("idProducto");
        int puntuacion = objetoJson.getInt("puntuacion");
        Registrado usuario = this.registradoRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario registrado no encontrado:: " + email));
        Producto producto = this.productoRepository.findById(idProducto)
                .orElseThrow(() -> new ResourceNotFoundException("Producto con el no encontrado, id :: " + idProducto));
        
       Puntuacion puntuacionNueva = new Puntuacion();
       puntuacionNueva.setProducto(producto);
       puntuacionNueva.setRegistrado(usuario);
       puntuacionNueva.setPuntuacion(puntuacion);
       
       this.puntuacionRepository.save(puntuacionNueva);
       // comprobar si el producto votado esta en los productos guardados y eliminarlo de la lista de productos guardados
//       if (usuario.getGuardados().contains(producto)){
//           usuario.deleteGuardado(producto);
//           this.registradoRepository.save(usuario);
//       }
       Map<String, Boolean> response = new HashMap<>();
       response.put("Puntuado", Boolean.TRUE);
       return response;
    }
    
    /**
     * Método que devuelve un listado con los productos puntuados por un determinado usuario
     * @param email
     * @return lista de productos 
     * @throws ResourceNotFoundException 
     */
    @Override
    public List<Integer> productosPuntuados(String email) throws ResourceNotFoundException{
        Registrado usuario = this.registradoRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario registrado no encontrado:: " + email));
        List<Integer> listaIdsProductos = new ArrayList<Integer>();
        Iterator iterador = usuario.getPuntuaciones().iterator();
        while (iterador.hasNext()){
            Puntuacion puntuacion = (Puntuacion) iterador.next();
            listaIdsProductos.add(puntuacion.getProducto().getId());
        }
        
        return listaIdsProductos; 
    }

    /**
     * Método que devuelve un listado con los id de productos puntuados por un determinado usuario
     * @param email
     * @return lista de ids
     * @throws ResourceNotFoundException 
     */
    @Override
    public List<Puntuacion> listaProdutosPuntuados(String email) throws ResourceNotFoundException {
        Registrado usuario = this.registradoRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario registrado no encontrado:: " + email));

       
        return usuario.getPuntuaciones();
    }
    
}
