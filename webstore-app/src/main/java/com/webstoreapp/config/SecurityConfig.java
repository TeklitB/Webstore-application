package com.webstoreapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@ComponentScan("com.webstoreapp")
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("john").password("{noop}pa55word").roles("USER");
		auth.inMemoryAuthentication().withUser("admin").password("{noop}root123").roles("USER", "ADMIN");
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.formLogin().loginPage("/webstore/login").usernameParameter("userId").passwordParameter("password");
		httpSecurity.formLogin().defaultSuccessUrl("/webstore/market/products/add").failureUrl("/webstore/login?error");
		httpSecurity.logout().logoutSuccessUrl("/webstore/login?logout");
		httpSecurity.exceptionHandling().accessDeniedPage("/webstore/login?accessDenied");
		httpSecurity.authorizeRequests().antMatchers("/").permitAll().antMatchers("/**/add").access("hasRole('ADMIN')")
				.antMatchers("/**/market/**").access("hasRole('USER')");
		httpSecurity.csrf().disable();
	}
}