package com.project.ElectricityBillingSystem.Services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ElectricityBillingSystem.Entity.LoginEntity;
import com.project.ElectricityBillingSystem.Exceptions.LoginNotFoundException;
import com.project.ElectricityBillingSystem.Repository.LoginRepo;
import com.project.ElectricityBillingSystem.Services.LoginServices;
import com.project.ElectricityBillingSystem.dto.LoginDto;
import com.project.ElectricityBillingSystem.dto.LoginRespDto;

@Service
public class LoginServicesImpl implements LoginServices {
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	@Autowired
	public LoginRepo loginRepo;
	
	@Override
	public List<LoginEntity> getAllLogin() {
		LOGGER.error("inside get method");
		return loginRepo.findAll();
	}

	@Override
	public Optional<LoginEntity> getLogin(String email) throws LoginNotFoundException {

		LOGGER.error("inside getLogin method");
		try {
			Optional<LoginEntity> loginData = loginRepo.findById(email);
			if(loginData!=null) {
				return loginRepo.findById(email);
			}
			else {
				throw new LoginNotFoundException("login Data not found");
			}
		}
		catch(Exception e){
			throw new LoginNotFoundException("login Data not found");
		}
	}

	@Override
	public LoginEntity addLogin(LoginEntity loginEntity) {
		LOGGER.error("inside addLogin method");
		// TODO Auto-generated method stub
		return loginRepo.save(loginEntity);
	}

	@Override
	public Optional<LoginEntity> deleteLogin(String email) throws LoginNotFoundException {
		LOGGER.error("inside deleteLogin method");
		try {
			Optional<LoginEntity> loginData = loginRepo.findById(email);
			if(loginData!=null) {
				loginRepo.deleteById(email);
				return loginData;
			}
			else {
				throw new LoginNotFoundException("login Data not found");
			}
		}
		catch(Exception e){
			throw new LoginNotFoundException("login Data not found");
		}
	}

	@Override
	public LoginEntity updateLogin(String email, LoginEntity loginEntity) throws LoginNotFoundException {
		LOGGER.error("inside updateLogin method");
		try {
			Optional<LoginEntity> loginData = loginRepo.findById(email);
			if(loginData!=null) {
				loginEntity.setEmail(email);
				return loginRepo.save(loginEntity);
			}
			else {
				throw new LoginNotFoundException("login Data not found");
			}
		}
		catch(Exception e){
			throw new LoginNotFoundException("login Data not found");
		}
	}

	@Override
	public LoginRespDto login(@Valid LoginDto loginDto) {
		LOGGER.error("inside login method");
		// TODO Auto-generated method stub
		return null;
	}
	
}
