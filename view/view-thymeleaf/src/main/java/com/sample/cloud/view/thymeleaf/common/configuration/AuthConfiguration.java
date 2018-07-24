package com.sample.cloud.view.thymeleaf.common.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

@Configuration
public class AuthConfiguration {
	
	private static final String RESOURCE_ID = "order";
	

	
	@Configuration
	public static class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

		@Override
		public void configure(HttpSecurity http) throws Exception {
			
			
	           http
               .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
               .and()
               .requestMatchers().anyRequest()
               .and()
               .anonymous()
               .and()
               .authorizeRequests()
               .antMatchers("/**/order/**").authenticated();//配置order访问控制，必须认证过后才可以访问
			// TODO Auto-generated method stub
			super.configure(http);
		}

		@Override
		public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
			
			resources.resourceId(RESOURCE_ID).stateless(true);
			
			// TODO Auto-generated method stub
			super.configure(resources);
		}
		
	}
	
	
	
	@Configuration
	public static class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {
		
		
        @Autowired
        AuthenticationManager authenticationManager;
        @Autowired
        RedisConnectionFactory redisConnectionFactory;
		

		@Override
		public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
			
			security.allowFormAuthenticationForClients();
			
			// TODO Auto-generated method stub
			super.configure(security);
			
			
			
		}

		@Override
		public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
			
	           //配置两个客户端,一个用于password认证一个用于client认证
            clients.inMemory().withClient("client_1")
                    .resourceIds(RESOURCE_ID)
                    .authorizedGrantTypes("client_credentials", "refresh_token")
                    .scopes("select")
                    .authorities("client")
                    .secret("123456")
                    .and().withClient("client_2")
                    .resourceIds(RESOURCE_ID)
                    .authorizedGrantTypes("password", "refresh_token")
                    .scopes("select")
                    .authorities("client")
                    .secret("123456");

			
			// TODO Auto-generated method stub
			super.configure(clients);
		}

		@Override
		public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {

            endpoints
            .tokenStore(new RedisTokenStore(redisConnectionFactory))
            .authenticationManager(authenticationManager);
			
			// TODO Auto-generated method stub
			super.configure(endpoints);
		}
	}
	

}
