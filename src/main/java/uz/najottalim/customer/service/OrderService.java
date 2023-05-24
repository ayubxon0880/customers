package uz.najottalim.customer.service;

import org.springframework.http.ResponseEntity;
import uz.najottalim.customer.dto.OrderDTO;

public interface OrderService {
    ResponseEntity<?> findAll();

    ResponseEntity<?> findById(Long id);

    ResponseEntity<?> save(OrderDTO orderDTO);

    ResponseEntity<?> updateCustomer(Long id, OrderDTO orderDTO);

    ResponseEntity<?> delete(Long id);
}
