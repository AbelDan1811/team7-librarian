package com.team7.librarian.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
//import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
//import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private UserDetailsService userDetailsService;
//	@Autowired
//	private PersistentTokenRepository tokenRepository;
	@Autowired
	private AuthenticationFailureHandler authenticationFailureHandler;
	@Autowired
	private AuthenticationSuccessHandler authenticationSuccessHandler;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailsService)
			.passwordEncoder(bCryptPasswordEncoder);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
		.csrf().disable()
		.authorizeRequests()
			.antMatchers("/registration").permitAll()
			.antMatchers("/login").permitAll()
			.antMatchers("/librarian/**").hasAuthority("ADMIN")
			.antMatchers("/user/**").hasAuthority("USER")
			.anyRequest().authenticated()
			.and()
		.formLogin()
			.loginPage("/login")
//			.successHandler(authenticationSuccessHandler)
//			.failureHandler(authenticationFailureHandler)
			.defaultSuccessUrl("/home")
			.failureUrl("/login?message=error")
			.usernameParameter("email")
			.passwordParameter("password")
			.permitAll()
			.and()
	    .logout()
	    	.deleteCookies("JSESSIONID")
	    	.logoutUrl("/logout")
	    	.logoutSuccessUrl("/login?message=logout")
	    	.permitAll()
	    	.and()
	    .exceptionHandling()
	    	.accessDeniedPage("/accessDenied")
	    .and()
	    .sessionManagement()
	    	.invalidSessionUrl("/login?message=invalid-session")
		    .maximumSessions(1)
		    .maxSessionsPreventsLogin(false)
		    .expiredUrl("/login?message=expired-session");
	
	}	
		
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception{
		return super.authenticationManagerBean();
	}
	
	
//	@Bean
//	public PersistentTokenBasedRememberMeServices getPersistentTokenBasedRememberMeServices() {
//		PersistentTokenBasedRememberMeServices tokenBasedservice = new PersistentTokenBasedRememberMeServices(
//				"remember-me", userDetailsService, tokenRepository);
//		return tokenBasedservice;
//	}
//	@Bean
//	public AuthenticationTrustResolver getAuthenticationTrustResolver() {
//		return new AuthenticationTrustResolverImpl();
//	}
	
//	@Bean
//	public PersistentTokenRepository persistentTokenRepository() {
//		return new JdbcTokenRepositoryImpl();
//	}
		
}