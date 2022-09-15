package com.ifsuldemias.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ifsuldemias.course.entities.Users;

public interface UserRepository extends JpaRepository<Users, Long>{
	
}
