
package com.ioc.daw.kv.service.impl;

import com.ioc.daw.kv.exception.ResourceNotFoundException;
import com.ioc.daw.kv.model.Serie;
import com.ioc.daw.kv.repository.SerieRepository;
import com.ioc.daw.kv.service.SerieService;

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
 * Clase para realizar acciones con objetos Serie
 * @author Xavi
 */
@Service
public class SerieServiceImpl implements SerieService{
    
    @Autowired
    private SerieRepository serieRepository;
    
    @Autowired
    private EntityManager em;

    /**
     * Método que devuelve una lista con todas las series de la base de datos
     * @return lista de documentales
     */
    @Override
    public List<Serie> listaSeries() {
       return this.serieRepository.findAll();
    }

    /**
     * Método que guarda un Serie en la base de datos
     * @param serie
     * @return la respuesta con el Serie 
     */
    @Override
    public ResponseEntity<Serie> agregarSerie(Serie serie) {
        return ResponseEntity.ok(this.serieRepository.save(serie));
    }

    /**
     * Método para modificar un Serie de la base de datos
     * @param serieDetails
     * @param id
     * @return la respuesta con el Serie
     * @throws ResourceNotFoundException
     */
    @Override
    public ResponseEntity<Serie> modificarSerie(Serie serieDetails, Integer id)throws ResourceNotFoundException {
        Serie serie = serieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Serie no encontrada :: " + id));
        serie.setTitulo(serieDetails.getTitulo());
        serie.setTituloOriginal(serieDetails.getTituloOriginal());
        serie.setDuracion(serieDetails.getDuracion());
        serie.setEstreno(serieDetails.getEstreno());
        serie.setEdadMinima(serieDetails.getEdadMinima());
        serie.setSinopsis(serieDetails.getSinopsis());
        serie.setCaratula(serieDetails.getCaratula());
        serie.setGenero(serieDetails.getGenero());
        serie.setPais(serieDetails.getPais());
        serie.setPlataformas(serieDetails.getPlataformas());
        serie.setCapitulos(serieDetails.getCapitulos());
        serie.setTemporadas(serieDetails.getTemporadas());
   
        return ResponseEntity.ok(this.serieRepository.save(serie));
    }

    /**
     * Método que elimina una Serie de la base de datos
     * @param id
     * @return un Map con deteled : true o error
     * @throws ResourceNotFoundException  
     */
    @Override
    public Map<String, Boolean> eliminarSerie(Integer id) throws ResourceNotFoundException {
        Serie serie = serieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Serie no encontrada :: " + id));

        this.serieRepository.delete(serie);

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
     * @return lista de series 
     * @throws JSONException 
     */
    @Override
    public List<Serie> buscarConFiltros(String filtros) throws JSONException {
        JSONObject objetoJson = new JSONObject(filtros);
        JSONArray generos = objetoJson.getJSONArray("genero");
        JSONArray plataformas = objetoJson.getJSONArray("plataforma");
                
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Serie> criteriaQuery = criteriaBuilder.createQuery(Serie.class);
        Root<Serie> serieRoot = criteriaQuery.from(Serie.class);
        //Devolvera los resultados únicos por orden de puntuación descendente
        criteriaQuery.select(serieRoot).distinct(true).orderBy(criteriaBuilder.desc(serieRoot.get("puntuacion")));
        
        //Creamos las listas de los Predicate para los parametros
        List<Predicate> predicateListGeneros = new LinkedList<>();
        List<Predicate> predicateListPlataformas = new LinkedList<>();

        //Recorremos los arrays y genereamos y agregamos los Predicate correspondientes
        for (int i = 0; i < generos.length(); i++) {
            Predicate predicateGeneros = criteriaBuilder.equal(serieRoot.get("genero"), generos.getString(i));
            predicateListGeneros.add(predicateGeneros);
        }
        
        for (int i = 0; i < plataformas.length(); i++) {
            Predicate predicatePlataformas = criteriaBuilder.equal(serieRoot.join("plataformas").get("id"), plataformas.getString(i));
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
        List<Serie> series = em.createQuery(criteriaQuery).getResultList();

        return series;
    }
}