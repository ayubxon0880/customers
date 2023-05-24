package uz.najottalim.customer.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import uz.najottalim.customer.dto.CustomerDTO;
import uz.najottalim.customer.exceptions.NoResourceFoundException;
import uz.najottalim.customer.service.CustomerService;

@RestController
@RequestMapping("customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return customerService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return customerService.getById(id);
    }

    @PostMapping
    public ResponseEntity<?> addCustomer(@Valid @RequestBody CustomerDTO customerDTO) {
        return customerService.addCustomer(customerDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCustomer(@Valid @RequestBody CustomerDTO customerDTO, @PathVariable Long id) {
        return customerService.updateCustomer(id, customerDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
        return customerService.deleteCustomer(id);
    }

    @GetMapping("/{customerId}/orders")
    public ResponseEntity<?> getCustomerOrders(@PathVariable Long customerId) {
//        throw new NoResourceFoundException("adsa");
                return customerService.getCustomerOrders(customerId);
    }
}
