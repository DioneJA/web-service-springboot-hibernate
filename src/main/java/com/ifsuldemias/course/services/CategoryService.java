package com.ifsuldemias.course.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifsuldemias.course.entities.Category;
import com.ifsuldemias.course.repositories.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository repository;
	
	public List<Category> findAll(){
		return repository.findAll();
	}
	
	public Category finById(Long id) {
		return repository.findById(id).get();
	}
}
