package com.cg.drinkdelight.service;


import com.cg.drinkdelight.dto.UserDetailsDTO;
import com.cg.drinkdelight.entity.UserDetails;

public interface CustomerService {

	UserDetails register(UserDetails uDetails);

	UserDetails findByName(UserDetailsDTO userDetails);

	UserDetails findByName(String uName);

	UserDetails register1(UserDetails uDetails);

}
