package fr.cyril.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import fr.cyril.model.Customer;


//Communicate with cutomer-service using OpenFeign 
@FeignClient(name = "customer-service")
public interface CustomerRestClient {
	
	@GetMapping("/api/customers/{id}")
	public Customer getCustomerById(@PathVariable Long id);
	
	@GetMapping("/api/customers")
	PagedModel<Customer> getAllCustomers();

}
