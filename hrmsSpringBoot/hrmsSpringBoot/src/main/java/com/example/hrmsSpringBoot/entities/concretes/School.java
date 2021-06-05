package com.example.hrmsSpringBoot.entities.concretes;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "schools")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class School {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "school_name")
	@NotNull
	@NotBlank
	private String schoolName;
	
	@Column(name = "year_of_beginning")
	@NotNull
	@NotBlank
	private int yearOfBeginning;
	
	@Column(name = "year_of_graduation")
	private int yearOfGraduation;
	
	@ManyToOne
	@JoinColumn(name = "cv_id")
	private CV cv;
	
	public School() {
		super();
	}

	public School(int id, String schoolName, int yearOfBeginning, int yearOfGraduation, CV cv) {
		super();
		this.id = id;
		this.schoolName = schoolName;
		this.yearOfBeginning = yearOfBeginning;
		this.yearOfGraduation = yearOfGraduation;
		this.cv = cv;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public int getYearOfBeginning() {
		return yearOfBeginning;
	}

	public void setYearOfBeginning(int yearOfBeginning) {
		this.yearOfBeginning = yearOfBeginning;
	}

	public int getYearOfGraduation() {
		return yearOfGraduation;
	}

	public void setYearOfGraduation(int yearOfGraduation) {
		this.yearOfGraduation = yearOfGraduation;
	}
	
	
	
	
}
