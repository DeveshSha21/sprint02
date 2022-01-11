package com.cg.drinkdelight.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.drinkdelight.dao.CustomerRegisterDAO;
import com.cg.drinkdelight.dto.UserDetailsDTO;
import com.cg.drinkdelight.entity.UserDetails;
import com.cg.drinkdelight.exception.PasswordAuthenticationFailedException;
//import com.cg.drinkdelight.exception.PasswordAuthenticationFailedException;
import com.cg.drinkdelight.exception.UserNameAlreadyExistsException;
import com.cg.drinkdelight.exception.UserRegistrationException;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRegisterDAO dao;
	
	@Override
	public UserDetails register(UserDetails uDetails) {
		List<UserDetails> uDetailsList = dao.findAll();
		for (UserDetails user : uDetailsList) {
			if(user.getUsername().equals(uDetails.getUsername())) {
				throw new UserNameAlreadyExistsException("Username : " + uDetails.getUsername() + " alreday exists");
			}
		}
		UserDetails details = dao.save(uDetails); 
		return details;
	}

	@Override
	public UserDetails findByName(UserDetailsDTO details) {
		Optional<UserDetails> detailsOpt = dao.findById(details.getUsername());
		if(!detailsOpt.isPresent()) {
			throw new UserRegistrationException("User with username : " + details.getUsername() + " not registered");
		}
		UserDetails uDetails = detailsOpt.get();
		if(!details.getPassword().equals(uDetails.getPassword())) {
			throw new PasswordAuthenticationFailedException("Invalid credentials");
		}
		return uDetails;
	}

	@Override
	public UserDetails findByName(String uName) {
		Optional<UserDetails> opt = dao.findById(uName);
		return opt.get();
	}

	@Override
	public UserDetails register1(UserDetails uDetails) {
		UserDetails details = dao.save(uDetails); 
		return details;
	}

}
