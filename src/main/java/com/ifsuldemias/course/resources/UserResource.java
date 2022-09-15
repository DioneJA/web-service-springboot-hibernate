package com.ifsuldemias.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ifsuldemias.course.entities.Users;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	@GetMapping
	public ResponseEntity<Users> findall(){
		Users u = new Users(1L, "Bruno", "brunoalves2017@gmail.com","(35) - 998640649","12345");
		return ResponseEntity.ok().body(u);
	}
}
