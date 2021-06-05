package com.example.hrmsSpringBoot.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "job_seekers")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "cvs"}) //sonsuz donguye girmesin diye
public class JobSeeker extends User{
	
	@Id
	@Column(name = "id")
	private int id;
	

	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "date_of_birth")
	private int dateOfBirth;
	
	@Column(name = "nationality_id")
	private long nationalityId;
	
	@OneToMany(mappedBy = "jobSeeker")
	List<CV> cvs;
	
	public JobSeeker() {
		super();
	}


	public List<CV> getCvs() {
		return cvs;
	}


	public void setCvs(List<CV> cvs) {
		this.cvs = cvs;
	}



	public JobSeeker(int id, String firstName, String lastName, int dateOfBirth, long nationalityId, List<CV> cvs) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.nationalityId = nationalityId;
		this.cvs = cvs;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public int getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(int dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public long getNationalityId() {
		return nationalityId;
	}

	public void setNationalityId(long nationalityId) {
		this.nationalityId = nationalityId;
	}
	
	
	
	
}