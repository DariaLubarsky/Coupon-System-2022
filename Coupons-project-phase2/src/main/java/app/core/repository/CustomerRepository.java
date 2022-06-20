package app.core.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import app.core.entities.Customer;
import app.core.util.JwtUtil.Client;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	Optional<Customer> findByEmailAndPassword(String email, String password);

	boolean existsById(int id);

	boolean existsByFirstNameAndLastName(String firstName, String lastName);

	Optional<Customer> findByFirstNameAndLastName(String firstName, String lastName);

	void deleteByFirstNameAndLastName(String firstName, String lastName);

	Client findByEmail(String email);

}
