package it.eng.comuneroma.serviziDipendentiReload.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsByNameServiceWrapper;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationProvider;
import org.springframework.security.web.authentication.preauth.RequestHeaderAuthenticationFilter;



@Configuration
@EnableWebSecurity
public class SecurityConfigDemo extends WebSecurityConfigurerAdapter {
        
	
	@Autowired
	UserDetailsService  customUserDetailsService;
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {

      http.authorizeRequests()
        .antMatchers("/dirigente/**").hasRole("DIRIGENTE")
        .antMatchers("/dipendente/**").hasRole("DIPENDENTE")       
        //.anyRequest().authenticated()        
        .and()
        .addFilterBefore(requestHeaderAuthenticationFilter(), RequestHeaderAuthenticationFilter.class);
        
    }
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(preauthAuthProvider());
    }  
    
	@Bean
	public PreAuthenticatedAuthenticationProvider preauthAuthProvider() {
		final PreAuthenticatedAuthenticationProvider provider = new PreAuthenticatedAuthenticationProvider();
		provider.setPreAuthenticatedUserDetailsService( new UserDetailsByNameServiceWrapper<>(customUserDetailsService));
		return provider;
	}
    
	private RequestHeaderAuthenticationFilter requestHeaderAuthenticationFilter() throws Exception {
	    RequestHeaderAuthenticationFilter requestFilter = new RequestHeaderAuthenticationFilter();
	    requestFilter.setPrincipalRequestHeader("iv-user");
	    requestFilter.setExceptionIfHeaderMissing(false);
	    //requestFilter.setCheckForPrincipalChanges(true);
	    try {
	        requestFilter.setAuthenticationManager(this.authenticationManagerBean());
	    } catch (Exception e) {
	        e.printStackTrace();
	        //throw new InstantiationException("Error creating authentication manager", WebSecurityConfig.class, e);
	        throw new Exception();
	    }
	    return requestFilter;
	} 
	

    

}