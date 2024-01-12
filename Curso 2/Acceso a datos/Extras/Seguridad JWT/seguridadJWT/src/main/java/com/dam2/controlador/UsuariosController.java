package com.dam2.controlador;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


import com.dam2.modelo.Mensaje;
import com.dam2.modelo.User;


@RestController
public class UsuariosController {
	
	
	private final String secret = "mySecretKey";
	
	private final long tiempo = 600000;

    @GetMapping(value = "/mensajes")
    public List<Mensaje> getMensajes(){
    	
    	System.out.println("controlador /mensajes");
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	
    	System.out.println(auth.getName());
        return Arrays.asList(new Mensaje(1,"Paco"), new Mensaje(2,"Pedro"), new Mensaje(3, "Juan"));
    }
    
    @PostMapping(value="/mensajes/post")
    public ResponseEntity<String> createMensaje(@RequestBody Mensaje mensaje) 
	{
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	
    	System.out.println(auth.getPrincipal());
    	
    	System.out.println(auth.getName());
	    System.out.println(mensaje);
		
	    return new ResponseEntity(HttpStatus.CREATED);
	}
    
    @PostMapping("/token")
	public String login(@RequestParam("user") String username, @RequestParam("password") String pwd) {
		
    	
    	String token = ""; 
    	
    	if (username.equals("client") && pwd.equals("client"))
    		token = getJWTToken(username);
			
		return token;
		
	}

    @GetMapping(value = "/token/mensajes")
    public List<Mensaje> getMensajesToken(){
    	
    	
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	
        return Arrays.asList(new Mensaje(1,"Paco"), new Mensaje(2,"Pedro"), new Mensaje(3, "Juan"));
    }
    
	private String getJWTToken(String username) {


		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("CLIENT");
		
		String token = Jwts
				.builder()
				.setId("MiguelSutil")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + tiempo))
				.signWith(SignatureAlgorithm.HS512,
						secret.getBytes()).compact();

		return "Bearer " + token;
	}
    
}