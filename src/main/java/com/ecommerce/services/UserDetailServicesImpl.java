package com.ecommerce.services;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecommerce.models.Usuario;

import jakarta.servlet.http.HttpSession;

@Service
public class UserDetailServicesImpl implements UserDetailsService{
	
	@Autowired
	private IUserServices userServices;
	
	@Autowired
	private BCryptPasswordEncoder bCrypt;
	
	@Autowired
	HttpSession session;
	
	private Logger log = LoggerFactory.getLogger(UserDetailServicesImpl.class);

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		log.info("Esto es el username: {}", username);
		Optional<Usuario> optionalUser = userServices.findByEmail(username);
		if(optionalUser.isPresent()) {
			log.info("id de usuario: {}",optionalUser.get().getId());
			session.setAttribute("iduser", optionalUser.get().getId());
			Usuario usuario = optionalUser.get();
			return User.builder().username(usuario.getName()).password(usuario.getPassword()).roles(usuario.getType()).build();
		}else {
			throw new UsernameNotFoundException("Usuario no encontrado");
		}
	}

}
