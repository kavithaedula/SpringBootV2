package com.springboot.v2.intercetors;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

/**
 * A configuration class to wire in the Nubiquity provided property files (or local files if those don't exist
 * and make the properties available throughout the rest of the application in order to prevent each class having
 * to do it.
 */
@Configuration
@PropertySources({
        @PropertySource("classpath:/local-ubiquity/environment.properties"),
        @PropertySource("classpath:/local-ubiquity/application.properties"),
        @PropertySource(value = "${appPropertiesPath}/application.properties", ignoreResourceNotFound = true),
        @PropertySource(value = "${appPropertiesPath}/environment.properties", ignoreResourceNotFound = true),
        })
class PropertyConfig {
    // This class is intentionally empty. The annotations above do everything we need to access these properties
    // elsewhere in the application
}
