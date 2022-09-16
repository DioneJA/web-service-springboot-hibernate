package com.ifsuldemias.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifsuldemias.course.entities.Users;
import com.ifsuldemias.course.repositories.UserRepository;
@Service
public class UserServices{
	@Autowired
	private UserRepository repository;
	
	public List<Users> findAll(){
		return repository.findAll();
	}
	
	public Users findById(Long id) {
		Optional<Users> op = repository.findById(id);
		return op.get();
	}
}
