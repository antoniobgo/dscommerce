package com.atwo.dscommerce.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.atwo.dscommerce.dto.OrderDTO;
import com.atwo.dscommerce.dto.ProductDTO;
import com.atwo.dscommerce.services.OrderService;

import jakarta.validation.Valid;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
@RestController
@RequestMapping(path = "/orders")
public class OrderController {

    @Autowired
    private OrderService service;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(path = "/{id}")
    public ResponseEntity<OrderDTO> findById(@PathVariable Long id) {
        OrderDTO orderDTO = service.findOrderById(id);
        return ResponseEntity.ok(orderDTO);
    }

    @PreAuthorize("hasRole('ROLE_CLIENT')")
    @PostMapping
    public ResponseEntity<OrderDTO> insert(@RequestBody @Valid OrderDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

}
