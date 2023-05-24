package uz.najottalim.customer.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.najottalim.customer.dto.CustomerDTO;
import uz.najottalim.customer.dto.ErrorDTO;
import uz.najottalim.customer.entity.Customer;
import uz.najottalim.customer.exceptions.NoResourceFoundException;
import uz.najottalim.customer.mapping.CustomerMapping;
import uz.najottalim.customer.repository.CustomerRepository;
import uz.najottalim.customer.service.CustomerService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public ResponseEntity<?> getAll() {
        List<Customer> customers = customerRepository.findAll();
        if (customers.isEmpty()) {
            return ResponseEntity.status(404)
                    .body(
                            ErrorDTO.builder()
                                    .errors("Not found")
                                    .build()
                    );
        }
        return ResponseEntity.ok(customers);
    }

    @Override
    public ResponseEntity<?> getById(Long id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isPresent()) {
            return ResponseEntity.ok(
                    CustomerMapping.toDto(
                            optionalCustomer.get()
                    )
            );
        }
        return ResponseEntity.status(404)
                .body(
                        ErrorDTO.builder()
                                .errors("Not found")
                                .build()
                );
    }

    @Override
    public ResponseEntity<?> addCustomer(CustomerDTO customerDTO) {
        Customer customer = CustomerMapping.toEntity(customerDTO);
        try {
            customer = customerRepository.save(customer);
            customerDTO = CustomerMapping.toDto(customer);
            return ResponseEntity.ok(customerDTO);
        } catch (Exception e) {
            return ResponseEntity.status(404)
                    .body(ErrorDTO.builder().errors(e.getMessage()).build());
        }
    }

    @Override
    public ResponseEntity<?> deleteCustomer(Long id) {
        CustomerDTO customerDTO = CustomerMapping.toDto(customerRepository.findById(id).get());
        customerRepository.deleteById(id);
        return ResponseEntity.ok(customerDTO);
    }

    @Override
    public ResponseEntity<?> updateCustomer(Long id, CustomerDTO customerDTO) {
        Customer customer = CustomerMapping.toEntity(customerDTO);
        customer.setId(id);
        return ResponseEntity.ok(CustomerMapping.toDto(customerRepository.save(customer)));
    }

    @Override
    public ResponseEntity<?> getCustomerProducts(Long customerId) {
        return null;
    }

    @Override
    public ResponseEntity<?> getCustomerOrders(Long customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isPresent()) {
            return ResponseEntity.ok(CustomerMapping.toDto(customer.get()));
        }
        throw new NoResourceFoundException("Customer not found");
    }
}
