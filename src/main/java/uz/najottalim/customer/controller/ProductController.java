package uz.najottalim.customer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.najottalim.customer.dto.ProductDTO;
import uz.najottalim.customer.service.ProductService;

@RestController
@RequestMapping("product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/all")
    public ResponseEntity<?> getAll(){
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return productService.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody ProductDTO productDTO){
        return productService.save(productDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody ProductDTO productDTO, @PathVariable Long id){
        return productService.update(productDTO, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return productService.delete(id);
    }
}
