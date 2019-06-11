package com.springboot.v2.intercetors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import javax.annotation.Resource;


@Configuration
public class AuthorizationConfig {



    /*@Bean
    public DefaultPermissionEvaluator defaultPermissionEvaluator() {
        DefaultPermissionEvaluator permissionEvaluator = new DefaultPermissionEvaluator();
        permissionEvaluator.setContextInstitutionResolver(contextInstitutionResolver);
        permissionEvaluator.setPermissionsServiceClient(permissionsServiceClient());
        permissionEvaluator.setSecurityContextProvider(securityContextProvider());
        permissionEvaluator.setDomainFilter("CATALOG");
        return permissionEvaluator;
    }*/

    /**
     * Configure's method-level security using EIDM's authorization infrastructure.
     */
    @Configuration
    @EnableGlobalMethodSecurity(prePostEnabled = true)
    public static class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {

      //  @Resource(name = "defaultPermissionEvaluator")
        private PermissionEvaluator permissionEvaluator;


        @Override
        protected MethodSecurityExpressionHandler createExpressionHandler() {
            DefaultMethodSecurityExpressionHandler expressionHandler = new DefaultMethodSecurityExpressionHandler();
            expressionHandler.setPermissionEvaluator(permissionEvaluator);
            return expressionHandler;
        }
    }

    @Order(200)
    @Configuration
    public static class WebSecurityConfig extends WebSecurityConfigurerAdapter {

       // @Resource(name = "defaultPermissionEvaluator")
        private PermissionEvaluator permissionEvaluator;


        @Override
        public void configure(WebSecurity web) throws Exception {
            //web.expressionHandler(customWebSecurityExpressionHandler());
        }

      /*  @Bean
        public DefaultWebSecurityExpressionHandler customWebSecurityExpressionHandler() {
            DefaultWebSecurityExpressionHandler expressionHandler = new DefaultWebSecurityExpressionHandler();
            expressionHandler.setPermissionEvaluator(permissionEvaluator);
            return expressionHandler;
        }*/

    }
}