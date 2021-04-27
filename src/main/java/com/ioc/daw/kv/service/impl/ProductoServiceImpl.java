
package com.ioc.daw.kv.service.impl;

import com.ioc.daw.kv.model.Producto;
import com.ioc.daw.kv.service.ProductoService;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Clase para realizar acciones con objetos Producto
 * @author Xavi
 */
@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private EntityManager em;
    
    
     /**
      * Método que busca productos en la base de datos cuyo título o título original
      * coincidan con el parámetro
      * @param titulo
      * @return la respuesta con los productos
     */
    @Override
    public List<Producto> buscarBuscador(String titulo) {
        
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Producto> criteriaQuery = criteriaBuilder.createQuery(Producto.class);
        Root<Producto> productoRoot = criteriaQuery.from(Producto.class);
        criteriaQuery.select(productoRoot).distinct(true).orderBy(criteriaBuilder.desc(productoRoot.get("puntuacion")));
        
        Predicate predicateTitulo = criteriaBuilder.like(productoRoot.get("titulo").as(String.class), "%" + titulo + "%" );
        Predicate predicateTituloOriginal = criteriaBuilder.like(productoRoot.get("tituloOriginal").as(String.class), "%" + titulo + "%" );
        Predicate finalPredicate = criteriaBuilder.or(predicateTitulo, predicateTituloOriginal);

        criteriaQuery.where(finalPredicate);
        
        List<Producto> productos = em.createQuery(criteriaQuery).getResultList();
        return productos;
    }
 
        
}
