package com.vaccine.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.vaccine.model.VaccineCalendar;

public interface VaccineCalendarRepository extends CrudRepository<VaccineCalendar,String> {

	List<VaccineCalendar> findAll();

	VaccineCalendar findById(Integer id);

}
