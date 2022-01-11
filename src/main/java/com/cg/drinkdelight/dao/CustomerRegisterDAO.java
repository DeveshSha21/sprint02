package com.cg.drinkdelight.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.drinkdelight.dto.UserDetailsDTO;
import com.cg.drinkdelight.entity.UserDetails;

@Repository
public interface CustomerRegisterDAO extends JpaRepository<UserDetails, String> {
	
}
