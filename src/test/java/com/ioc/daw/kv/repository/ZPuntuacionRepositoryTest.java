/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ioc.daw.kv.repository;

import com.ioc.daw.kv.model.Pelicula;
import com.ioc.daw.kv.model.Producto;
import com.ioc.daw.kv.model.Puntuacion;
import com.ioc.daw.kv.model.Registrado;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
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
public class ZPuntuacionRepositoryTest {
    
    @Autowired
    private PuntuacionRepository repo;
    @Autowired
    private ProductoRepository repoProducto;
    @Autowired
    private RegistradoRepository repoRegistrado;
    
    @Test
    @Rollback(false)
    public void testAddPuntacion(){
        Registrado registrado = repoRegistrado.save(new Registrado("UserPuntuacionkvemos.com", "User123", null));
        Pelicula producto = repoProducto.save(new Pelicula("tituloPuntuacion", "tituloOriginal", 120, 2011,16, "película de prueba para test", "caratula", 1, 1,null));
        Puntuacion puntuacion = new Puntuacion();
        puntuacion.setRegistrado(registrado);
        puntuacion.setProducto(producto);
        puntuacion.setPuntuacion(5);
        repo.save(puntuacion);
        
        assertThat(puntuacion.getProducto().getTitulo()).isEqualTo("tituloPuntuacion");
        assertThat(puntuacion.getPuntuacion()).isEqualTo(5);
    }
}
