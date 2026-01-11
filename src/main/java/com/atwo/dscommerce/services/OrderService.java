package com.atwo.dscommerce.services;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atwo.dscommerce.dto.OrderDTO;
import com.atwo.dscommerce.dto.OrderItemDTO;
import com.atwo.dscommerce.entities.Order;
import com.atwo.dscommerce.entities.OrderItem;
import com.atwo.dscommerce.entities.OrderStatus;
import com.atwo.dscommerce.entities.Product;
import com.atwo.dscommerce.repositories.OrderItemRepository;
import com.atwo.dscommerce.repositories.OrderRepository;
import com.atwo.dscommerce.repositories.ProductRepository;
import com.atwo.dscommerce.services.exceptions.ResourceNotFoundException;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private AuthService authService;

    @Transactional(readOnly = true)
    public OrderDTO findOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resource not found"));
        authService.validateSelfOrAdmin(order.getClient().getId());
        return new OrderDTO(order);
    }

    @Transactional
    public OrderDTO insert(OrderDTO dto) {
        Order entity = new Order();
        entity.setMoment(Instant.now());
        entity.setStatus(OrderStatus.WAITING_PAYMENT);
        entity.setClient(userService.authenticated());

        for (OrderItemDTO ordemItemDTO : dto.getItems()) {
            Product product = productRepository.getReferenceById(ordemItemDTO.getProductId());

            entity.getItems().add(new OrderItem(entity, product,
                ordemItemDTO.getQuantity(), product.getPrice()));
        }

        orderRepository.save(entity);
        orderItemRepository.saveAll(entity.getItems());
        return new OrderDTO(entity);
    }
}
