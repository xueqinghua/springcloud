package com.sample.cloud.view.thymeleaf.common.configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.inMemoryAuthentication()
        .withUser("user1").password("123456").authorities("USER")
        .and()
        .withUser("user2").password("123456").authorities("USER");
		
		
		// TODO Auto-generated method stub
		super.configure(auth);
	}
	
	
    @Bean
    @Override
    protected UserDetailsService userDetailsService(){
    	
    	Collection<UserDetails> users = new ArrayList<UserDetails>();
    	
    	User user1 = new User("user1","123456",Arrays.asList(new SimpleGrantedAuthority("USER")));
    	User user2 = new User("user2","123456",Arrays.asList(new SimpleGrantedAuthority("USER")));

    	users.add(user1);
    	users.add(user2);
    	
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager(users);
        return manager;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http
            .requestMatchers().anyRequest()
            .and()
                .authorizeRequests()
                .antMatchers("/**/oauth/*").permitAll();
        // @formatter:on
    }

}
