package com.atwo.dscommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atwo.dscommerce.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
