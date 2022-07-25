package com.project.ElectricityBillingSystem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.project.ElectricityBillingSystem.Entity.LoginEntity;
import com.project.ElectricityBillingSystem.Exceptions.LoginNotFoundException;
import com.project.ElectricityBillingSystem.Services.LoginServicesImpl;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class LoginTests {

	@Autowired
	private LoginServicesImpl loginServiceImple;
	
	@Test
	void addLoginTest() {
		LoginEntity LoginEntity = new LoginEntity("mahender@gmail.com", "iamfull", "admin");
		LoginEntity result = loginServiceImple.addLogin(LoginEntity);
		assertEquals(LoginEntity.toString(), result.toString());
	}
	
	@Test
	void getLoginTest() {
		LoginEntity LoginEntity = new LoginEntity("prassu@gmail.com","st123", "cust");
		Optional<LoginEntity> result;
		try {
			result = loginServiceImple.getLogin("prassu@gmail.com");
			assertEquals(LoginEntity.toString(), result.get().toString());
		} catch (LoginNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	void updateLoginTest() {
		LoginEntity LoginEntity = new LoginEntity("mahender@gmail.com", "iamnotfull", "admin");
		LoginEntity result = null;
		try {
			result = loginServiceImple.updateLogin("mahender@gmail.com", LoginEntity);
			if(result==null)
				throw  new LoginNotFoundException("no login found");
			assertEquals(LoginEntity.toString(), result.toString());
		} catch (LoginNotFoundException e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	void removeLoginTest() {
		LoginEntity LoginEntity = new LoginEntity("mahender@gmail.com", "iamnotfull", "admin");
		Optional<LoginEntity> result = null;
		try {
			result = loginServiceImple.deleteLogin("mahender@gmail.com");
			if(result==null)
				throw  new LoginNotFoundException("no login found");
			assertEquals(LoginEntity.toString(), result.get().toString());
		} catch (LoginNotFoundException e) {
			e.printStackTrace();
			fail();
		}
	}
	

}
