package com.cg.oma.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import com.cg.oma.beans.User;
import com.cg.oma.response.ResponseInfo;

@RestController
public class Controller {

	@Autowired
	RestTemplate rt;



	String endPoint = "http://localhost:8082/users";
	
	@PostMapping("/userConsumers/users")
	ResponseEntity<ResponseInfo> addingUser(@RequestBody User user) {
	return rt.postForEntity(endPoint, user, ResponseInfo.class);
	}
	
	@PutMapping("/userConsumers/users")
	String updateUser(@RequestBody User user) {
		rt.postForEntity(endPoint, user, ResponseInfo.class);
		return "Updated Successfully";
	}
	
	
	@DeleteMapping("/userConsumers/users/byUserName/{userName}")
	String deleteUser( @PathVariable("userName") String userName) {
		rt.delete(endPoint + "/" + userName);
		return "Deleted Successfully";
	}
	
	@GetMapping("/userConsumers")
	List<User> getUser() {
	List<User> list = Arrays.asList(rt.getForObject(endPoint, User[].class));
	return list;
	}
	


	
	
	
}
