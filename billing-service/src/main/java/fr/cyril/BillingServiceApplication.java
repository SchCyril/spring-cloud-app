package fr.cyril;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.LinkRelation;

import fr.cyril.entities.Bill;
import fr.cyril.entities.ProductItem;
import fr.cyril.feign.CustomerRestClient;
import fr.cyril.feign.ProductRestClient;
import fr.cyril.model.Customer;
import fr.cyril.model.Product;
import fr.cyril.repository.BillRepository;
import fr.cyril.repository.ProductItemRepository;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(BillRepository billRepository, ProductItemRepository productItemRepository,
			CustomerRestClient customerRestClient, ProductRestClient productRestClient) {

		return args -> {
			Collection<Customer> customers = customerRestClient.getAllCustomers().getContent();
			Collection<Product> products = productRestClient.getAllProducts().getContent();

			customers.forEach(customer -> {
				Bill bill = Bill.builder().billingDate(new Date()).customerId(customer.getId()).build();
				billRepository.save(bill);

				products.forEach(product -> {
					ProductItem productItem = ProductItem.builder().productId(product.getId()).bill(bill)
							.quantity(1 + new Random().nextInt(10)).unitPrice(product.getPrice()).build();

					productItemRepository.save(productItem);
				});
			});

		};

	}
}
