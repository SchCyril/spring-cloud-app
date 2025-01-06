package fr.cyril.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import fr.cyril.entities.Customer;


@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
