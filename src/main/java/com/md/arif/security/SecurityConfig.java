package com.md.arif.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@SuppressWarnings("deprecation")
@Configuration
public class SecurityConfig  extends WebSecurityConfigurerAdapter 
{


protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.inMemoryAuthentication().passwordEncoder( NoOpPasswordEncoder.getInstance()).withUser("mdarif").password("secret")
				.roles("USER").and().withUser("admin").password("secret")
				.roles("USER", "ADMIN");
	}


	protected void configure(HttpSecurity http) throws Exception {
		
		http.httpBasic().and().authorizeRequests().antMatchers("/h2-console/**","/actuator/**","/explorer/**")
		.hasRole("USER").antMatchers("/orders/**","/products/**").hasRole("USER")
		.antMatchers("/**").hasRole("ADMIN").and().csrf().disable()
		.headers().frameOptions().disable();


	}
}
