package fr.cyril.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.cyril.entities.Bill;

public interface BillRepository extends JpaRepository<Bill, Long>{

}
