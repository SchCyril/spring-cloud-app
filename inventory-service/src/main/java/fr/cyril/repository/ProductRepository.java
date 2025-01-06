package fr.cyril.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.cyril.entities.Product;

public interface ProductRepository extends JpaRepository<Product, String>{

}
