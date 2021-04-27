/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ioc.daw.kv.repository;

import com.ioc.daw.kv.model.Pelicula;
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
public class PeliculaRepositoryTest {
    
    @Autowired
    private PeliculaRepository repo;
    
    @Test
    @Rollback(false)
    @Order(1)
    public void testAddPelicula(){
        Pelicula nuevaPelicula = repo.save(new Pelicula("tituloPelicula", "tituloOriginal", 120, 2011,16, "película de prueba para test", "caratula", 1, 1,null));
        assertThat(nuevaPelicula.getId()).isGreaterThan(0);
    }
    
  
    @Test
    @Order(2)
    public void testFindPeliculaById(){      
     
        Optional<Pelicula> pelicula = repo.findById(2);
        assertThat(pelicula.get().getId()).isEqualTo(2);        
    }
    
    @Test
    @Rollback(false)
    @Order(3)
    public void testModificarPelicula(){
        Optional<Pelicula> pelicula = repo.findById(2);
        pelicula.get().setTitulo("pruebaTestPelicula");
        repo.save(pelicula.get());
        
        Optional<Pelicula> updatedPelicula = repo.findById(2);
        assertThat(updatedPelicula.get().getTitulo()).isEqualTo("pruebaTestPelicula");
    }
    
    @Test
    @Rollback(false)
    @Order(4)
    public void testEliminarPelicula(){
        Optional<Pelicula> pelicula = repo.findById(2);
        repo.delete(pelicula.get());
        assertThat(repo.findById(2)).isEmpty();        
    }
}
