package com.ifsuldemias.course.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifsuldemias.course.entities.Product;
import com.ifsuldemias.course.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository service;
	
	public List<Product> findAll(){
		return service.findAll();
	}
	public Product findById(Long id) {
		return service.findById(id).get();
	}
}
