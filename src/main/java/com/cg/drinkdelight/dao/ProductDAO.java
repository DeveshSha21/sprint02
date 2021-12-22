package com.cg.drinkdelight.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.drinkdelight.entity.ProductStock;

public interface ProductDAO extends JpaRepository<ProductStock, Integer> {

}
