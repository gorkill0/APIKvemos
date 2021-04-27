
package com.ioc.daw.kv.service.impl;

import com.ioc.daw.kv.exception.ResourceNotFoundException;
import com.ioc.daw.kv.model.Pelicula;
import com.ioc.daw.kv.repository.PeliculaRepository;
import com.ioc.daw.kv.service.PeliculaService;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Clase para realizar acciones con objetos Pelicula
 * @author Xavi
 */
@Service
public class PeliculaServiceImpl implements PeliculaService{
    
    @Autowired
    private PeliculaRepository peliculaRepository;
    
    @Autowired
    private EntityManager em;

    /**
     * Método que devuelve una lista con todas peliculas de la base de datos
     * @return lista de documentales
     */
    @Override
    public List<Pelicula> listaPeliculas() {
       return this.peliculaRepository.findAll();
    }

    /**
     * Método que guarda una Pelicula en la base de datos
     * @param serie
     * @return la respuesta con el Pelicula
     */
    @Override
    public ResponseEntity<Pelicula> agregarPelicula(Pelicula pelicula) {
        return ResponseEntity.ok(this.peliculaRepository.save(pelicula));
    }

    /**
     * Método para modificar un Pelicula de la base de datos
     * @param peliculaDetails
     * @param id
     * @return la respuesta con el Pelicula
     * @throws ResourceNotFoundException
     */
    @Override
    public ResponseEntity<Pelicula> modificarPelicula(Pelicula peliculaDetails, Integer id)throws ResourceNotFoundException {
        Pelicula pelicula = peliculaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pelicula no encontrada :: " + id));
        pelicula.setTitulo(peliculaDetails.getTitulo());
        pelicula.setTituloOriginal(peliculaDetails.getTituloOriginal());
        pelicula.setDuracion(peliculaDetails.getDuracion());
        pelicula.setEstreno(peliculaDetails.getEstreno());
        pelicula.setEdadMinima(peliculaDetails.getEdadMinima());
        pelicula.setSinopsis(peliculaDetails.getSinopsis());
        pelicula.setCaratula(peliculaDetails.getCaratula());
        pelicula.setGenero(peliculaDetails.getGenero());
        pelicula.setPais(peliculaDetails.getPais());
        pelicula.setPlataformas(peliculaDetails.getPlataformas());
   
        return ResponseEntity.ok(this.peliculaRepository.save(pelicula));
    }

     /**
      * Método que elimina una Pelicula de la base de datos
      * @param id
      * @return un Map con deteled : true o error
      * @throws ResourceNotFoundException 
      */
    @Override
    public Map<String, Boolean> eliminarPelicula(Integer id) throws ResourceNotFoundException {
        Pelicula pelicula = peliculaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pelicula no encontrada :: " + id));

        this.peliculaRepository.delete(pelicula);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;
    }
    
    /**
     * Método que recibe un conjunto de filtros(géneros y plataformas) realiza
     * una busqueda y devuelve los resultados que coincidan con estos filtros.
     * El critério de busqueda tendrá en cuenta que pertenezca a los diferentes
     * géneros y plataformas
     * @param filtros
     * @return lista de peliculas 
     * @throws JSONException 
     */
    @Override
    public List<Pelicula> buscarConFiltros(String filtros) throws JSONException {
        JSONObject objetoJson = new JSONObject(filtros);
        JSONArray generos = objetoJson.getJSONArray("genero");
        JSONArray plataformas = objetoJson.getJSONArray("plataforma");
                
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Pelicula> criteriaQuery = criteriaBuilder.createQuery(Pelicula.class);
        Root<Pelicula> peliculaRoot = criteriaQuery.from(Pelicula.class);
        //Devolvera los resultados únicos por orden de puntuación descendente
        criteriaQuery.select(peliculaRoot).distinct(true).orderBy(criteriaBuilder.desc(peliculaRoot.get("puntuacion")));
        
        //Creamos las listas de los Predicate para los parametros
        List<Predicate> predicateListGeneros = new LinkedList<>();
        List<Predicate> predicateListPlataformas = new LinkedList<>();

        //Recorremos los arrays y genereamos y agregamos los Predicate correspondientes
        for (int i = 0; i < generos.length(); i++) {
            Predicate predicateGeneros = criteriaBuilder.equal(peliculaRoot.get("genero"), generos.getString(i));
            predicateListGeneros.add(predicateGeneros);
        }
        
        for (int i = 0; i < plataformas.length(); i++) {
            Predicate predicatePlataformas = criteriaBuilder.equal(peliculaRoot.join("plataformas").get("id"), plataformas.getString(i));
            predicateListPlataformas.add(predicatePlataformas);
        }
       
        //Generamos los Predicate finales con una sentencia OR entre todos los Géneros y entre todas las plataformas     
        Predicate predicateGenerosFinal = criteriaBuilder.or(predicateListGeneros.toArray(new Predicate[0]));
        Predicate predicatePlataformasFinal = criteriaBuilder.or(predicateListPlataformas.toArray(new Predicate[0]));
        
        //Generamos la sentencia final uniendo con un AND los géneros y las plataformas
        Predicate finalPredicate = criteriaBuilder.and(predicateGenerosFinal, predicatePlataformasFinal);

        // En caso de ausencia de algún criterio se realiza la consulta con unos u otros criterios
        if (generos.length()>0 && plataformas.length()>0) {
            criteriaQuery.where(finalPredicate);
        } else if (generos.length()>0){
            criteriaQuery.where(predicateGenerosFinal);
        } else if (plataformas.length()>0){
            criteriaQuery.where(predicatePlataformasFinal);
        } 
        
        //Se obtiene el resultado
        List<Pelicula> peliculas = em.createQuery(criteriaQuery).getResultList();

        return peliculas;
    }

   

}
