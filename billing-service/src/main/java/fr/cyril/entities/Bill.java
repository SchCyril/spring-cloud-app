package fr.cyril.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.cyril.model.Customer;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Bill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date billingDate;
	private long customerId;
	@OneToMany(mappedBy = "bill")
	private List<ProductItem> productItems = new ArrayList<>();

	@Transient
	private Customer customer;
}
