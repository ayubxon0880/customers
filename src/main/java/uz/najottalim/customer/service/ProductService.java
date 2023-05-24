package uz.najottalim.customer.service;

import org.springframework.http.ResponseEntity;
import uz.najottalim.customer.dto.ProductDTO;

public interface ProductService {
    ResponseEntity<?> findAll();

    ResponseEntity<?> findById(Long id);

    ResponseEntity<?> save(ProductDTO productDTO);

    ResponseEntity<?> update(ProductDTO productDTO, Long id);

    ResponseEntity<?> delete(Long id);
}
