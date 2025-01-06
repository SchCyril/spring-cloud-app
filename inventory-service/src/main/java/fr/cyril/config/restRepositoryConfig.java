package fr.cyril.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import fr.cyril.entities.Product;

@Configuration
public class restRepositoryConfig implements RepositoryRestConfigurer {

	// Personalise the configuration of spring data rest
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
		config.exposeIdsFor(Product.class);
	}

}
