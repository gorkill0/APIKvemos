
package com.ioc.daw.kv.service.impl;

import com.ioc.daw.kv.exception.ResourceNotFoundException;
import com.ioc.daw.kv.model.Documental;
import com.ioc.daw.kv.repository.DocumentalRepository;
import com.ioc.daw.kv.service.DocumentalService;

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
 * Clase para realizar acciones con objetos Documental
 * @author Xavi
 */
@Service
public class DocumentalServiceImpl implements DocumentalService{
    
    @Autowired
    private DocumentalRepository documentalRepository;
    
    @Autowired
    private EntityManager em;

    /**
     * Método que devuelve una lista con todos los documentales
     * @return lista de documentales
     */
    @Override
    public List<Documental> listaDocumentales() {
       return this.documentalRepository.findAll();
    }

    /**
     * Método que guarda un Documental en la base de datos
     * @param documental
     * @return la respuesta con el Documental 
     */
    @Override
    public ResponseEntity<Documental> agregarDocumental(Documental documental) {
        return ResponseEntity.ok(this.documentalRepository.save(documental));
    }

    /**
     * Método para modificar un Documental de la base de datos
     * @param documentalDetails
     * @param id
     * @return la respuesta con el Documental
     * @throws ResourceNotFoundException
     */
    @Override
    public ResponseEntity<Documental> modificarDocumental(Documental documentalDetails, Integer id)throws ResourceNotFoundException {
        Documental documental = documentalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Documental no encontrado :: " + id));
        documental.setTitulo(documentalDetails.getTitulo());
        documental.setTituloOriginal(documentalDetails.getTituloOriginal());
        documental.setDuracion(documentalDetails.getDuracion());
        documental.setEstreno(documentalDetails.getEstreno());
        documental.setEdadMinima(documentalDetails.getEdadMinima());
        documental.setSinopsis(documentalDetails.getSinopsis());
        documental.setCaratula(documentalDetails.getCaratula());
        documental.setGenero(documentalDetails.getGenero());
        documental.setPais(documentalDetails.getPais());
        documental.setPlataformas(documentalDetails.getPlataformas());
   
        return ResponseEntity.ok(this.documentalRepository.save(documental));
    }

    /**
     * Método que eliminaun Documental de la base de datos
     * @param id
     * @return un Map con deteled : true o error
     * @throws ResourceNotFoundException 
     */
    @Override
    public Map<String, Boolean> eliminarDocumental(Integer id) throws ResourceNotFoundException {
        Documental documental = documentalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Documental no encontrado :: " + id));

        this.documentalRepository.delete(documental);

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
     * @return lista de documentales 
     * @throws JSONException 
     */
    @Override
    public List<Documental> buscarConFiltros(String filtros) throws JSONException {
        JSONObject objetoJson = new JSONObject(filtros);
        JSONArray generos = objetoJson.getJSONArray("genero"); // Almacenamos en un array los géneros
        JSONArray plataformas = objetoJson.getJSONArray("plataforma"); // Almacenamos en un array las plataformas
                
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Documental> criteriaQuery = criteriaBuilder.createQuery(Documental.class);
        Root<Documental> documentalRoot = criteriaQuery.from(Documental.class);
        //Devolvera los resultados únicos por orden de puntuación descendente
        criteriaQuery.select(documentalRoot).distinct(true).orderBy(criteriaBuilder.desc(documentalRoot.get("puntuacion")));
        
        //Creamos las listas de los Predicate para los parametros
        List<Predicate> predicateListGeneros = new LinkedList<>();
        List<Predicate> predicateListPlataformas = new LinkedList<>();

        //Recorremos los arrays y genereamos y agregamos los Predicate correspondientes
        for (int i = 0; i < generos.length(); i++) {
            Predicate predicateGeneros = criteriaBuilder.equal(documentalRoot.get("genero"), generos.getString(i));
            predicateListGeneros.add(predicateGeneros);
        }
        
        for (int i = 0; i < plataformas.length(); i++) {
            Predicate predicatePlataformas = criteriaBuilder.equal(documentalRoot.join("plataformas").get("id"), plataformas.getString(i));
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
        List<Documental> documentales = em.createQuery(criteriaQuery).getResultList();

        return documentales;
    }
    
}
