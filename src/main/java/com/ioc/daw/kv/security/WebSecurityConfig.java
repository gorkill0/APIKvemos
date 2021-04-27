
package com.ioc.daw.kv.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Clase de configuración, se especicica que primero se tenga en cuenta el cors 
 * y después la autorización mediante token (si se hace al revés da problemas)
 * @author Xavi
 */
    @EnableGlobalMethodSecurity(securedEnabled = true)
    @EnableWebSecurity
    @Configuration
    public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

            @Override
            protected void configure(HttpSecurity http) throws Exception {
                    http.cors().and().csrf().disable()
                            .addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
                            .authorizeRequests()
                            .anyRequest().permitAll();
                   
            }
            
    }
    
