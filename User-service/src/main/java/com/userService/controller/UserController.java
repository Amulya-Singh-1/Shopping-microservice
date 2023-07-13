package com.userService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.userService.Entity.User;
import com.userService.Service.userServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private userServiceImpl serviceImpl;

	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/getAll")
	public List<User> getAll(){
		return serviceImpl.getAllUsers();
	}

	@GetMapping("/get/{id}")
	public User getUser(@PathVariable Integer id) {

		User user=this.serviceImpl.getUser(id);

		List productList=this.restTemplate.getForObject("http://productService/product/user/" + user.getUId(), List.class);

		user.setProducts(productList);

		return user;
	}
	
	@PostMapping("/add")
	public User add(@RequestBody User u) {
		return serviceImpl.addUser(u);
	}
	
	@PostMapping("/update")
	public User update(@RequestBody User u) {
		return serviceImpl.updateUser(u);
	}
	
	@PostMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		return serviceImpl.deleteUser(id);
	}
	
	
}
