/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ioc.daw.kv.service.impl.informes;

import com.ioc.daw.kv.model.informes.SeriesMedia;
import com.ioc.daw.kv.repository.informes.SeriesMediaRepository;
import com.ioc.daw.kv.service.informes.SeriesMediaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Xavi
 */
@Service
public class SeriesMediaServiceImpl implements SeriesMediaService{

    @Autowired
    private SeriesMediaRepository seriesMediaRepository;
    
    @Override
    public List<SeriesMedia> mostrarInforme() {
        return this.seriesMediaRepository.findAll();
    }
    
}
