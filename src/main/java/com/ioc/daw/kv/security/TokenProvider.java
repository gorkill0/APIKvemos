
package com.ioc.daw.kv.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

/**
 * Clase que genera un token de autorización
 * @author Xavi
 */
@Component
public class TokenProvider {
    public String getJWTToken(String email,String rol) {
        
		System.out.println("DENTRO DE GETTOKEN");
                String secretKey = "kevemosProyectoFinaldaw2020Grupo5";
      		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList(rol);
		
		String token = Jwts
				.builder()
				.setId("tokenkJWT")
				.setSubject(email)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000000))
                                .signWith(SignatureAlgorithm.HS256,secretKey.getBytes()).compact();
                

		return "Bearer " + token;
	}
}
