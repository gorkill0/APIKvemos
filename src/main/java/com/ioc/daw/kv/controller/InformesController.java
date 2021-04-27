
package com.ioc.daw.kv.controller;

import com.ioc.daw.kv.model.informes.DocumentalesMedia;
import com.ioc.daw.kv.model.informes.DocumentalesNumVotos;
import com.ioc.daw.kv.model.informes.InformeUsuarios;
import com.ioc.daw.kv.model.informes.PeliculasMedia;
import com.ioc.daw.kv.model.informes.PeliculasNumVotos;
import com.ioc.daw.kv.model.informes.SeriesMedia;
import com.ioc.daw.kv.model.informes.SeriesNumVotos;
import com.ioc.daw.kv.service.informes.DocumentalesMediaService;
import com.ioc.daw.kv.service.informes.DocumentalesNumVotosService;
import com.ioc.daw.kv.service.informes.InformesUsuariosService;
import com.ioc.daw.kv.service.informes.PeliculasMediaService;
import com.ioc.daw.kv.service.informes.PeliculasNumVotosService;
import com.ioc.daw.kv.service.informes.SeriesMediaService;
import com.ioc.daw.kv.service.informes.SeriesNumVotosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Xavi
 */
@RestController
@RequestMapping("/api/v1/informes/")
@CrossOrigin
public class InformesController {
        @Autowired
        private InformesUsuariosService informeUsuariosService;
        
        @Autowired
        private PeliculasMediaService peliculasMediaService;
        
        @Autowired
        private SeriesMediaService seriesMediaService;
        
        @Autowired
        private DocumentalesMediaService documentalesMediaService;
        
        @Autowired
        private PeliculasNumVotosService peliculasNumVotosService;
        
        @Autowired
        private SeriesNumVotosService seriesNumVotosService;
        
        @Autowired
        private DocumentalesNumVotosService documentalesNumVotosService;
        
        @Secured("ROLE_ADMIN")
        @GetMapping("usuarios")
        public List<InformeUsuarios> mostrarInformeUsuarios() {
            return this.informeUsuariosService.mostrarInforme();
        }
        
        @Secured("ROLE_ADMIN")
        @GetMapping("peliculas")
        public List<PeliculasMedia> mostrarInformePeliculas(){
            return this.peliculasMediaService.mostrarInforme();
        }
        
        @Secured("ROLE_ADMIN")
        @GetMapping("series")
        public List<SeriesMedia> mostrarInformeSerie(){
            return this.seriesMediaService.mostrarInforme();
        }
        
        @Secured("ROLE_ADMIN")
        @GetMapping("documentales")
        public List<DocumentalesMedia> mostrarInformeDocumentales(){
            return this.documentalesMediaService.mostrarInforme();
        }
        
        @Secured("ROLE_ADMIN")
        @GetMapping("votospeliculas")
        public List<PeliculasNumVotos> mostrarInformePeliculasVotos(){
            return this.peliculasNumVotosService.mostrarInforme();
        }
        
        @Secured("ROLE_ADMIN")
        @GetMapping("votosseries")
        public List<SeriesNumVotos> mostrarInformeSeriesVotos(){
            return this.seriesNumVotosService.mostrarInforme();
        }
        
        @Secured("ROLE_ADMIN")
        @GetMapping("votosdocumentales")
        public List<DocumentalesNumVotos> mostrarInformeDocumentalesVotos(){
            return this.documentalesNumVotosService.mostrarInforme();
        }
}
