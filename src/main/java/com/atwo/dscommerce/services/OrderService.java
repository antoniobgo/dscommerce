package com.atwo.dscommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atwo.dscommerce.dto.OrderDTO;
import com.atwo.dscommerce.entities.Order;
import com.atwo.dscommerce.repositories.OrderRepository;
import com.atwo.dscommerce.services.exceptions.ResourceNotFoundException;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Transactional(readOnly = true)
    public OrderDTO findOrderById(Long id) {
        Order order = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource not found"));
        return new OrderDTO(order);
    }
}
