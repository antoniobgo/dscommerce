package com.atwo.dscommerce.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atwo.dscommerce.dto.ProductDTO;
import com.atwo.dscommerce.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping(path = "/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping(path = "/{id}")
    public ProductDTO findById(@PathVariable Long id) {
        ProductDTO productDTO = service.findById(id);
        return productDTO;
    }
}
