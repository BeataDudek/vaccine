package com.vaccine.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.vaccine.model.Vaccine;

public interface VaccineRepository extends CrudRepository<Vaccine,String> {

	List<Vaccine> findAll();

	Vaccine findById(Integer id);

}