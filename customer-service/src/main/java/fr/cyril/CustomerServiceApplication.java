package fr.cyril;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fr.cyril.entities.Customer;
import fr.cyril.repository.CustomerRepository;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	

		
	}

	
	
	@Bean
	CommandLineRunner clr(CustomerRepository customerRepository) {
		
		return args-> {
			customerRepository.save(Customer.builder().name("Cyril").email("cyril@gmail.com").build());
			customerRepository.save(Customer.builder().name("Marie").email("marie@gmail.com").build());
			customerRepository.save(Customer.builder().name("Lili").email("lili@gmail.com").build());
			
			customerRepository.findAll().forEach(c -> {
				System.out.println(c.getId());
				System.out.println(c.getName());
				System.out.println(c.getEmail());
			});
		};
		
	}
}
