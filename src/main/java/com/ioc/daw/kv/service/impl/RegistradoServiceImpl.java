
package com.ioc.daw.kv.service.impl;

import com.ioc.daw.kv.exception.ResourceNotFoundException;
import com.ioc.daw.kv.model.Producto;
import com.ioc.daw.kv.model.Registrado;
import com.ioc.daw.kv.repository.ProductoRepository;
import com.ioc.daw.kv.repository.RegistradoRepository;
import com.ioc.daw.kv.security.TokenProvider;
import com.ioc.daw.kv.service.RegistradoService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Clase para trabajar con objetos Registrado (usuarios)
 * @author Xavi
 */
@Service
public class RegistradoServiceImpl implements RegistradoService {
    
    @Autowired
    private RegistradoRepository registradoRepository;
    
    @Autowired
    private ProductoRepository productoRepository;
    
    @Autowired
    private TokenProvider tokenProvider;

    /**
     * Método que devuelve una lista con todos los usuarios registrados de la base de datos
     * @return lista de documentales
     */
    @Override
    public List<Registrado> listaRegistrados() {
        return this.registradoRepository.findAll();
    }

    /**
     * Método que devuelve los datos de un usuarios registrados de la base de datos
     * @return respuesta con un Registrado
     */
    @Override
    public ResponseEntity<Registrado> mostrarRegistrado(Integer id) throws ResourceNotFoundException {
        
        Registrado registrado = this.registradoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario registrado no encontrado :: " + id));
        return ResponseEntity.ok().body(registrado);   
        
    }

    /**
     * Método para guardar un usuario registrado en la base de datos
     * @return respuesta con el usuario Registrado
     */
    @Override
    public ResponseEntity<Registrado> agregarRegistrado(Registrado registrado) {
        
        return ResponseEntity.ok(this.registradoRepository.save(registrado));
        
    }

    /**
     * Método que permite modificar un usuario Registrado en la base de datos
     * @param registradoDetails
     * @param id
     * @return respuesta con el Registrado
     * @throws ResourceNotFoundException 
     */
    @Override
    public ResponseEntity<Registrado> modificarRegistrado(Registrado registradoDetails, Integer id) throws ResourceNotFoundException {
        
        Registrado registrado = registradoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario registrado no encontrado :: " + id));
        registrado.setEmail(registradoDetails.getEmail());
        registrado.setPasswd(registradoDetails.getPasswd());

        return ResponseEntity.ok(this.registradoRepository.save(registrado));
        
    }

    /**
      * Método que elimina una Registrado de la base de datos
      * @param id
      * @return un Map con deteled : true o error
      * @throws ResourceNotFoundException 
      */
    @Override
    public Map<String, Boolean> eliminarRegistrado(Integer id) throws ResourceNotFoundException {
        
        Registrado registrado = registradoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario registrado no encontrado:: " + id));

        this.registradoRepository.delete(registrado);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;
    }

    /**
      * Método que elimina un Registrado de la base de datos mediante la comprobación 
      * de sus credenciales.
      * @param email
      * @param passwd
      * @return un Map con deteled : true o error
      * @throws ResourceNotFoundException 
      */
    @Override
    public Map<String, Boolean> bajaRegistrado(String email, String passwd) throws ResourceNotFoundException {
        
        Registrado usuario = registradoRepository.findByEmailAndPasswd(email, passwd)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario registrado no encontrado:: " ));
        this.registradoRepository.delete(usuario);
        
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;
        
    }

    /**
     * Método que autentica un usuario Registrado contra la base de datos y genera un
     * token de acceso
     * @param email
     * @param passwd
     * @return Administrador con el token generado
     * @throws ResourceNotFoundException 
     */
    @Override
    public Registrado login(String email, String passwd) throws ResourceNotFoundException {
        
        Registrado usuario = registradoRepository.findByEmailAndPasswd(email, passwd)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario registrado no encontrado:: " ));
        System.out.println("DESPUES DE BUSCAR");
        String token = tokenProvider.getJWTToken(email,"ROLE_USER");
        usuario.setToken(token);
        this.registradoRepository.save(usuario);
        return usuario;
    
    }

    /**
     * Método para recuperar la contaseña de un usuario Registrado, si el email 
     * existe devuelve un true para que se le pueda enviar un email para recuperar
     * la contraseña.
     * @param email
     * @return respuesta existe : True o error
     * @throws ResourceNotFoundException
     * @throws JSONException
     */
    @Override
    public Map<String, Boolean> recuperar(String email) throws ResourceNotFoundException, JSONException {

        Registrado usuario = this.registradoRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario registrado no encontrado:: " ));
        
       Map<String, Boolean> response = new HashMap<>();
       response.put("existe", Boolean.TRUE);
       return response;
    }

    /**
     * Método que elimina un producto de la lista de guardados de un Usuario
     * @param idProducto
     * @param email
     * @return respuesta Eliminado : True o error
     * @throws ResourceNotFoundException 
     */
    @Override
    public Map<String, Boolean> eliminarProductoGuardado(Integer idProducto, String email) throws ResourceNotFoundException {
        Registrado usuario = this.registradoRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario registrado no encontrado:: " ));
        
        Producto producto= this.productoRepository.findById(idProducto)
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado:: " ));
        
        if (usuario.getGuardados().contains(producto)){
            System.out.println("ESTA PRODUCTO");
            usuario.deleteGuardado(producto);
            this.registradoRepository.save(usuario);
        } else {
            System.out.println("DENTRO DEL ELSE");
            throw new ResourceNotFoundException("Producto no encontrado:: " );
        }
                
        Map<String, Boolean> response = new HashMap<>();
        response.put("Eliminado", Boolean.TRUE);
         return response;
    }
    
    /**
     * Método para agregar un producto a la lista de productos guardados de un usuario
     * @param datos con el email del usuario y el id del productoa guardar
     * @return respuesta con Agregado:True o error
     * @throws ResourceNotFoundException
     * @throws JSONException 
     */
    @Override
    public Map<String, Boolean> guardarProducto(String datos) throws ResourceNotFoundException, JSONException {
       
        JSONObject objetoJson = new JSONObject(datos);
        
        String email = objetoJson.getString("email");
        int idProducto = objetoJson.getInt("id");
        Registrado usuario = this.registradoRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario registrado no encontrado:: " + email));
        Producto producto = this.productoRepository.findById(idProducto)
                .orElseThrow(() -> new ResourceNotFoundException("Producto con el no encontrado, id :: " + idProducto));
        usuario.addGuardado(producto);
        this.registradoRepository.save(usuario);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Agregado", Boolean.TRUE);
        return response;
    }

    /**
     * Método que devuelve un listado con los productos guardados por un determinado usuario
     * @param email
     * @return lista con productos
     * @throws ResourceNotFoundException 
     */
    @Override
    public List<Integer> productosGuardados(String email) throws ResourceNotFoundException{
        
        Registrado usuario = this.registradoRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario registrado no encontrado:: " + email));
        List<Integer> listaIdsProductos = new ArrayList<Integer>();
        Iterator iterador = usuario.getGuardados().iterator();
        while (iterador.hasNext()){
            Producto productoGuardado = (Producto) iterador.next();
            listaIdsProductos.add(productoGuardado.getId());
        }
        
        return listaIdsProductos;
    }

    /**
     * Método que devuelve un listado con los id de productos guardados por un determinado usuario
     * @param email
     * @return lista con productos id
     * @throws ResourceNotFoundException 
     */
    @Override
    public List<Producto> listaProductosGuardados(String email) throws ResourceNotFoundException {
        
        Registrado usuario = this.registradoRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario registrado no encontrado:: " + email));
        
        return usuario.getGuardados();
        
    }
    
}
