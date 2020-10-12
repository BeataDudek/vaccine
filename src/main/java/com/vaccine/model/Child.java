package com.vaccine.model;


import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Child {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String firstName;
	private String lastName;
	private LocalDate birth;
	@OneToMany(mappedBy = "child", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	List<Vaccine> vaccineList;

	@ManyToOne
	private User user;

	public Child(String firstName, String lastName, LocalDate birth, List<Vaccine> vaccineList, User user) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birth = birth;
		this.vaccineList = vaccineList;
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getBirth() {
		return birth;
	}

	public void setBirth(LocalDate birth) {
		this.birth = birth;
	}

	public List<Vaccine> getVaccineList() {
		return vaccineList;
	}

	public void setVaccineList(List<Vaccine> vaccineList) {
		this.vaccineList = vaccineList;
	}
}
