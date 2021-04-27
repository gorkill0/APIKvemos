
package com.ioc.daw.kv.service;

import com.ioc.daw.kv.model.Producto;
import java.util.List;

/**
 *
 * @author Xavi
 */
public interface ProductoService {
    
    public List<Producto> buscarBuscador(String titulo);
}
