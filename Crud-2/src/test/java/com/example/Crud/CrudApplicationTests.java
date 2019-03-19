package com.example.Crud;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


/*MockMvc*/
//@RunWith(SpringRunner.class) ,Mockito @RunWith -MockitoJUnitRunner.class

/* For both MockMvc/Mockito SpringJunit4Runner.class*/

/*Mockito*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CrudApplicationTests {


	@Test
	public void contextLoads() throws Exception {
	}

	@Autowired
	private MockMvc mockMvc;

	/* Mockito */

	@Mock
	private UserRepository userRepository;

	@InjectMocks
	private UserController userController;

	@Test
	public void testRepository(){
		List<User> usersList = new ArrayList<User>();
		usersList.add(new User(1l,"Pragathi","Country"));
		Mockito.when(userRepository.findAll()).thenReturn(new ArrayList<>(usersList));
		Assert.assertEquals(usersList,userController.getAll());

	}

	/*  MockMvc to test the Rest endpoints*/
	@Test
	public void getAllUsers() throws Exception{
		User user =new User((long) 1,"Pragathi","USA");
		userRepository.save(user);

		this.mockMvc.perform(get("/api/users")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));



	}

}