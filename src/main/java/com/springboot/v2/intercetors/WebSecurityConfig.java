package com.springboot.v2.intercetors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Configure Spring Security.
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    Environment env;


    /**
     * Configure security filters.
     * Place filter chain
     */
    @Override
    protected void configure(final HttpSecurity http) throws Exception {

     /*   http.addFilterBefore(keyServletFilter(), AbstractPreAuthenticatedProcessingFilter.class)
                .addFilterBefore(null, AbstractPreAuthenticatedProcessingFilter.class);
      */  //http.antMatcher("/springbootv2/**");
        http.csrf()
                .disable()
                .authorizeRequests()
                //designate url patterns requiring authentication
                .antMatchers("/*")
                .access("isAuthenticated()");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
       /* auth.authenticationProvider(idmAuthenticationProvider)
                .authenticationProvider(wskeyAuthenticationProvider());*/
    }

    /*private Filter keyServletFilter() {
        KeyConfig config = new KeyConfig();
        config.setService(env.getProperty("serviceName"));
        config.setWskeyBaseUrl(env.getProperty("hostAndPort"));
        config.setWskeyFlavorsAllowed("HMAC,AccessToken");
        ServletFilter f = new KeyServletFilter();
        f.setConfig(config);
        return f;
    }*/

   /* @Bean
    public  sAuthenticationFilter() throws Exception {

        return filter;
    }*/

}
