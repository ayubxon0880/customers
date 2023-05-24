package uz.najottalim.customer.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.najottalim.customer.dto.CustomerDTO;
import uz.najottalim.customer.dto.OrderDTO;
import uz.najottalim.customer.entity.Order;
import uz.najottalim.customer.service.OrderService;

@RestController
@RequestMapping("order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/all")
    public ResponseEntity<?> getAll(){
        return orderService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return orderService.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody OrderDTO orderDTO){
        return orderService.save(orderDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody OrderDTO orderDTO, @PathVariable Long id) {
        return orderService.updateCustomer(id, orderDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return orderService.delete(id);
    }

}
