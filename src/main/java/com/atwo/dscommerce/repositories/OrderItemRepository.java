package com.atwo.dscommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atwo.dscommerce.entities.OrderItem;
import com.atwo.dscommerce.entities.OrderItemPK;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}
