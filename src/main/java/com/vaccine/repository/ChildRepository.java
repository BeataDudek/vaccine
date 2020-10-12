package com.vaccine.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.vaccine.model.Child;
import com.vaccine.model.User;

public interface ChildRepository extends CrudRepository<Child,String> {

	List<Child> findAll();

	List<Child> findAllByUser(User user);

	Child findById(Integer id);

}