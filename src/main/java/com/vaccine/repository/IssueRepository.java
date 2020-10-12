package com.vaccine.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.vaccine.model.Issue;

public interface IssueRepository extends CrudRepository<Issue,String> {

	List<Issue> findAll();

}