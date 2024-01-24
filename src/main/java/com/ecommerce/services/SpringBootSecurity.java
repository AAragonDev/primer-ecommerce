package com.ecommerce.services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SpringBootSecurity{

	@Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
	
		  http
          .csrf(csrf -> csrf.disable()) 
          .authorizeHttpRequests(authorizeRequests ->
              authorizeRequests
                  .requestMatchers("/admin/**").hasRole("ADMIN")
                  .requestMatchers("/products/**").hasRole("ADMIN")
                  .anyRequest().authenticated()
          )
          .formLogin(login->login.loginPage("/user/login").permitAll().defaultSuccessUrl("/user/access"));

      return http.build();
  }
		
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
	    return authenticationConfiguration.getAuthenticationManager();
	}
	
	

}

