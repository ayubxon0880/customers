package uz.najottalim.customer.service;

import org.springframework.http.ResponseEntity;
import uz.najottalim.customer.dto.CustomerDTO;

public interface CustomerService {

    ResponseEntity<?> getAll();

    ResponseEntity<?> getById(Long id);

    ResponseEntity<?> addCustomer(CustomerDTO customerDTO);

    ResponseEntity<?> deleteCustomer(Long id);

    ResponseEntity<?> updateCustomer(Long id, CustomerDTO customerDTO);

    ResponseEntity<?> getCustomerProducts(Long customerId);

    ResponseEntity<?> getCustomerOrders(Long customerId);
}
