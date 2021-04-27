/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ioc.daw.kv.repository;

import com.ioc.daw.kv.model.Administrador;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
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
public class AdministradorRepositoryTest {
    
    @Autowired
    private AdministradorRepository repo;
       
    @Test
    @Rollback(false)
    public void testAddAdministrador() {
        
        Administrador administrador = repo.save(new Administrador("Admin@kvemos.com", "Admin123", null));     
        assertThat(administrador.getId()).isGreaterThan(0);
    }
    
    @Test
    public void testFindByEmailAndPasswd() {
        //repo.save(new Administrador("Admin@kvemos.com", "Admin123", null));
        Optional<Administrador> administrador = repo.findByEmailAndPasswd("Admin@kvemos.com", "Admin123");    
        assertThat(administrador.get().getEmail()).isEqualTo("Admin@kvemos.com");
        assertThat(administrador.get().getPasswd()).isEqualTo("Admin123");
    }
    
    @Test
    public void testNoEcontradoFindByNameAndPasswd() {
        //Administrador nuevoAdministrador = repo.save(new Administrador("Admin@kvemos.com", "Admin123", null));
        Optional<Administrador> administrador = repo.findByEmailAndPasswd("Adminf@kvemos.com", "Admin123"); 
        assertThat(administrador.isEmpty()).isTrue();
    }
}
