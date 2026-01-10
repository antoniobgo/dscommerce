package com.atwo.dscommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atwo.dscommerce.dto.OrderDTO;
import com.atwo.dscommerce.dto.UserDTO;
import com.atwo.dscommerce.entities.Order;
import com.atwo.dscommerce.entities.Role;
import com.atwo.dscommerce.entities.User;
import com.atwo.dscommerce.projections.UserDetailsProjection;
import com.atwo.dscommerce.repositories.OrderRepository;
import com.atwo.dscommerce.repositories.UserRepository;
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
