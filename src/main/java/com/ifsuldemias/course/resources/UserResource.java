package com.ifsuldemias.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ifsuldemias.course.entities.Users;
import com.ifsuldemias.course.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	/*AutoWired injeta automaticamente e importa as dependencia do services*/
	@Autowired
	private UserService services;

	@GetMapping
	public ResponseEntity<List<Users>> findall(){
		return ResponseEntity.ok().body(services.findAll());
	}
	
	
	@GetMapping(value ="/{id}")//Passa um id como parametro na url
	public ResponseEntity<Users> findById(@PathVariable Long id){//@PathVariable pega o id na url 
		return ResponseEntity.ok().body(services.findById(id));//Retorna o JSON do id
	}
}
