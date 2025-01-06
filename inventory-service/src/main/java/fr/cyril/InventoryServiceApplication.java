package fr.cyril;

import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fr.cyril.entities.Product;
import fr.cyril.repository.ProductRepository;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(ProductRepository productRepository) {

		return args -> {
			productRepository.save(
					Product.builder()
						   .id(UUID.randomUUID().toString())
					       .name("PC")
					       .price(999.90)
					       .quantity(5)
					       .build());
			
			productRepository.save(
					Product.builder()
						   .id(UUID.randomUUID().toString())
					       .name("Printer")
					       .price(76.99)
					       .quantity(49)
					       .build());
			
			productRepository.save(
					Product.builder()
						   .id(UUID.randomUUID().toString())
					       .name("Phone")
					       .price(9999.90)
					       .quantity(35)
					       .build());
			
			
			productRepository.findAll().forEach(p -> {
				System.out.println(p.toString());
			});

		};
		
		
	}

}
