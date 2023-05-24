package uz.najottalim.customer.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.najottalim.customer.dto.ErrorDTO;
import uz.najottalim.customer.dto.ProductDTO;
import uz.najottalim.customer.entity.Product;
import uz.najottalim.customer.repository.ProductRepository;
import uz.najottalim.customer.service.ProductService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public ResponseEntity<?> findAll() {
//        List<Product> all = productRepository.findAll();
//        if (all.isEmpty()){
//            return ResponseEntity.status(404).body(ErrorDTO.builder().errors())
//        }
//        return ;
        return null;
    }

    @Override
    public ResponseEntity<?> findById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<?> save(ProductDTO productDTO) {
        return null;
    }

    @Override
    public ResponseEntity<?> update(ProductDTO productDTO, Long id) {
        return null;
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        return null;
    }
}
