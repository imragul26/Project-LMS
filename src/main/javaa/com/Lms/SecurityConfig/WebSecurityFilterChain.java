package com.Lms.SecurityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class WebSecurityFilterChain extends  WebSecurityConfigurerAdapter {
	
	@Autowired
	private PasswordEncoder encoder;
	
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.inMemoryAuthentication()
		.withUser("ragul")
		.password("$2a$10$4hgW7dI.fIlLulcyWe/Xfua2wEvJzmsUpPchiT8uHQ9VTHlJv6Q.G")
		.roles("user")
		.and()
		.withUser("Admin")
		.password("$2a$10$5tuDKge/dlKDO.jAigvumumt7vtjMGtjTzl6oF0YYnLGB35mstOT2")
		.roles("user")
		.and()
		.passwordEncoder(encoder);
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
		.authorizeRequests()
		.antMatchers("/openLesson","/add-lesson","/add-instructor","/add-course").authenticated()
		.anyRequest().permitAll()
		.and()
		.formLogin()
		.and()
		.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/home");
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
	}
	

}
