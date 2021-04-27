/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ioc.daw.kv.repository;

import com.ioc.daw.kv.model.Documental;
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
public class DocumentalRepositoryTest {
    
    @Autowired
    private DocumentalRepository repo;
    
    @Test
    @Rollback(false)
    @Order(1)
    public void testAddDocumental(){
        Documental nuevaDocumental = repo.save(new Documental("tituloDocumental", "tituloOriginal", 120, 2011,16, "documental de prueba para test", "caratula", 1, 1,null));
        assertThat(nuevaDocumental.getId()).isGreaterThan(0);
    }
    
  
    @Test
    @Order(2)
    public void testFindDocumentalById(){      
     
        Optional<Documental> documental = repo.findById(1);
        assertThat(documental.get().getId()).isEqualTo(1);        
    }
    
    @Test
    @Rollback(false)
    @Order(3)
    public void testModificarDocumental(){
        Optional<Documental> documental = repo.findById(1);
        documental.get().setTitulo("pruebaTestDocumental");
        repo.save(documental.get());
        
        Optional<Documental> updatedDocumental = repo.findById(1);
        assertThat(updatedDocumental.get().getTitulo()).isEqualTo("pruebaTestDocumental");
    }
    
    @Test
    @Rollback(false)
    @Order(4)
    public void testEliminarDocumental(){
        Optional<Documental> documental = repo.findById(1);
        repo.delete(documental.get());
        assertThat(repo.findById(1)).isEmpty();        
    }
}
