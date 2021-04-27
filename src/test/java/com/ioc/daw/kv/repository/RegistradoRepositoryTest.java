/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ioc.daw.kv.repository;

import com.ioc.daw.kv.model.Registrado;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

/**
 *
 * @author Xavi
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RegistradoRepositoryTest {
    
    @Autowired
    private RegistradoRepository repo;
       
    @Test
    @Rollback(false)
    @Order(1)
    public void testAddRegistrado() {
        Registrado registrado = repo.save(new Registrado("User@kvemos.com", "User123", null));     
        assertThat(registrado.getId()).isGreaterThan(0);
    }
    
    @Test
    @Order(2)
    public void testFindByEmailAndPasswd() {
        Optional<Registrado> registrado = repo.findByEmailAndPasswd("User@kvemos.com", "User123");
        assertThat(registrado.get().getEmail()).isEqualTo("User@kvemos.com");
        assertThat(registrado.get().getPasswd()).isEqualTo("User123");
    }
    
    @Test
    public void testNoEcontradoFindByEmailAndPasswd() {
        Optional<Registrado> registrado = repo.findByEmailAndPasswd("dasd@kvemos.com", "User123"); 
        assertThat(registrado.isEmpty()).isTrue();
    }
    
    @Test
    public void testFindByEmail() {
        Optional<Registrado> registrado = repo.findByEmail("User@kvemos.com");    
        assertThat(registrado.get().getEmail()).isEqualTo("User@kvemos.com");
    }
    
    @Test
    public void testNoEcontradoFindByEmail() {
        Optional<Registrado> registrado = repo.findByEmail("dasd@kvemos.com"); 
        assertThat(registrado.isEmpty()).isTrue();
    }
    
}
