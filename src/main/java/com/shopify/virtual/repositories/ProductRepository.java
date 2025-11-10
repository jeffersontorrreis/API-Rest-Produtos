package com.shopify.virtual.repositories;

import com.shopify.virtual.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
