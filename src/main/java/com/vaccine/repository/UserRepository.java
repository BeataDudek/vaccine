package com.vaccine.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.vaccine.model.User;

public interface UserRepository extends CrudRepository<User, String> {

	User findById(Integer id);

	List<User> findAll();

	User findByUsernameAndPassword(String username, String password);

}
