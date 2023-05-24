package uz.najottalim.customer.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.najottalim.customer.dto.ErrorDTO;
import uz.najottalim.customer.dto.OrderDTO;
import uz.najottalim.customer.entity.Order;
import uz.najottalim.customer.mapping.OrderMapping;
import uz.najottalim.customer.repository.OrderRepository;
import uz.najottalim.customer.service.OrderService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Override
    public ResponseEntity<?> findAll() {
        List<Order> all = orderRepository.findAll();
        if (all.isEmpty()){
            return ResponseEntity.status(404).body(ErrorDTO.builder().errors("orders not found").build());
        }
        return ResponseEntity.ok(all);
    }

    @Override
    public ResponseEntity<?> findById(Long id) {
        Optional<Order> byId = orderRepository.findById(id);
        if (byId.isPresent()) {
            return ResponseEntity.ok(byId.get());
        }
        return ResponseEntity.status(404).body(ErrorDTO.builder().errors("order not found"));
    }

    @Override
    public ResponseEntity<?> save(OrderDTO orderDTO) {
        Order entity = OrderMapping.toEntity(orderDTO);
        if (entity == null) {
            return ResponseEntity.status(403).body(ErrorDTO.builder().errors("Order is null"));
        }

        try {
            Order save = orderRepository.save(entity);
            orderDTO = OrderMapping.toDto(save);
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok(orderDTO);

    }

    @Override
    public ResponseEntity<?> updateCustomer(Long id, OrderDTO orderDTO) {
        Order entity = OrderMapping.toEntity(orderDTO);

        assert entity != null;
        entity.setId(id);

        return ResponseEntity.ok(OrderMapping.toDto(orderRepository.save(entity)));
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        Optional<Order> byId = orderRepository.findById(id);
        if (byId.isPresent()){
            Order order = byId.get();
            orderRepository.delete(order);
            return ResponseEntity.ok(order);
        }
        return ResponseEntity.status(404).body("Order not found");
    }
}
