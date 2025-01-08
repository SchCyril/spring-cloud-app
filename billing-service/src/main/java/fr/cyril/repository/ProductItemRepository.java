package fr.cyril.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.cyril.entities.ProductItem;

public interface ProductItemRepository extends JpaRepository<ProductItem, Long>{

}
