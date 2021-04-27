/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ioc.daw.kv.repository;

import com.ioc.daw.kv.model.Serie;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
 

/**
 *
 * @author Xavi
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@TestMethodOrder(OrderAnnotation.class)
public class SerieRepositoryTest {
    
    @Autowired
    private SerieRepository repo;
    
    @Test
    @Rollback(false)
    @Order(1)
    public void testAddSerie(){
        Serie nuevaSerie = repo.save(new Serie("tituloSerie", "tituloOriginal", 120, 2011,16, "película de prueba para serie", "caratula",1,1,null, 12, 12));
        assertThat(nuevaSerie.getId()).isGreaterThan(0);
    }
    
  
    @Test
    @Order(2)
    public void testFindSerieById(){      
     
        Optional<Serie> serie = repo.findById(3);
        assertThat(serie.get().getId()).isEqualTo(3);        
    }
    
    @Test
    @Rollback(false)
    @Order(3)
    public void testModificarSerie(){
        Optional<Serie> serie = repo.findById(3);
        serie.get().setTitulo("pruebaTestSerie");
        repo.save(serie.get());
        
        Optional<Serie> updatedSerie = repo.findById(3);
        assertThat(updatedSerie.get().getTitulo()).isEqualTo("pruebaTestSerie");
    }
    
    @Test
    @Rollback(false)
    @Order(4)
    public void testEliminarSerie(){
        Optional<Serie> serie = repo.findById(3);
        repo.delete(serie.get());
        assertThat(repo.findById(3)).isEmpty();        
    }
}