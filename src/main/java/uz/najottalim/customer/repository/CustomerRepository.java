package uz.najottalim.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.najottalim.customer.entity.Customer;
import uz.najottalim.customer.entity.Order;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}

