package fr.cyril.entities;

import org.springframework.data.rest.core.config.Projection;


// To Personnalise the attributes
@Projection(name = "all", types = Customer.class)
public interface CustomerProjection {
	
	String getName();
	String getEmail();

}
