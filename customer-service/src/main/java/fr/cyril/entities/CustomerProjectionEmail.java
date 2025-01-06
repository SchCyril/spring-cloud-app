package fr.cyril.entities;

import org.springframework.data.rest.core.config.Projection;


// To Personnalise the attributes
@Projection(name = "email", types = Customer.class)
public interface CustomerProjectionEmail {
	
	String getEmail();

}
