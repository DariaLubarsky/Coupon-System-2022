package app.core.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = { "company", "customers" })
@EqualsAndHashCode(of = "id")
public class Coupon {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn
	private Company company;
	@Enumerated(EnumType.STRING)
	private Category category;
	private String title;
	private String description;
	private LocalDate startDate;
	private LocalDate endDate;
	private int amount;
	private double price;
	private String image;
//	int customerID;

	@ManyToMany
	@JoinTable(name = "customer_coupons", joinColumns = @JoinColumn(name = "customers_id"), inverseJoinColumns = @JoinColumn(name = "coupon_id"))
	private List<Customer> customers;

	public enum Category {
		FOOD, ELECTRICITY, SOFTWARES, TOURS, SERVICE, FORNITURE, ACCESSORIES, INTERNET, CELLULAR, CARS, BOOKS;

	}
}
