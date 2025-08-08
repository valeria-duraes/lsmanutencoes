package lsmanut_system.modules.customers.repository;

import lsmanut_system.modules.customers.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    // Here we need to utilize JPA because this interface provides us the principals methods ready to use! Like DELETE,
    // UPDATE, GET or PUT all them ready to use...
}
