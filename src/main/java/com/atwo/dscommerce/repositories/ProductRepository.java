package com.atwo.dscommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atwo.dscommerce.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
