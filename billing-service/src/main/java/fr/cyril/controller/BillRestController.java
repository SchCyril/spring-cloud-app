package fr.cyril.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fr.cyril.entities.Bill;
import fr.cyril.feign.CustomerRestClient;
import fr.cyril.feign.ProductRestClient;
import fr.cyril.repository.BillRepository;
import fr.cyril.repository.ProductItemRepository;

@RestController
public class BillRestController {

	
	
	private BillRepository billRepository;
	private ProductItemRepository productItemRepository;

	private CustomerRestClient customerRestClient;
	private ProductRestClient productRestClient;
	
	

	
	public BillRestController(BillRepository billRepository, ProductItemRepository productItemRepository,
			CustomerRestClient customerRestClient, ProductRestClient productRestClient) {
		super();
		this.billRepository = billRepository;
		this.productItemRepository = productItemRepository;
		this.customerRestClient = customerRestClient;
		this.productRestClient = productRestClient;
	}




	@GetMapping("/bills/{id}")
	public Bill getBill(@PathVariable Long id) {
		Bill bill = billRepository.findById(id).get();
		bill.setCustomer(customerRestClient.getCustomerById(bill.getCustomerId()));
		bill.getProductItems().forEach(productItem -> {
			productItem.setProduct(productRestClient.getProductById(productItem.getProductId()));
		});
		return bill;

	}
}
