package com.cg.drinkdelight.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.drinkdelight.entity.RawMaterialStock;

public interface RawMaterialDAO extends JpaRepository<RawMaterialStock, Integer> {

}

