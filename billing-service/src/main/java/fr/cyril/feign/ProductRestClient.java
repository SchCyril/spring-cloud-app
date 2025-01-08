package fr.cyril.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import fr.cyril.model.Customer;
import fr.cyril.model.Product;

@FeignClient(name = "inventory-service")
public interface ProductRestClient {

	@GetMapping("/api/products/{id}")
	public Product getProductById(@PathVariable String id);
	
	@GetMapping("/api/products")
	PagedModel<Product> getAllProducts();
}
