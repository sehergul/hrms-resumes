package com.example.hrmsSpringBoot.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "job_experiences")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class JobExperience {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "worked_company_name")
	@NotNull
	@NotBlank
	private String workedCompanyName;
	
	@Column(name = "worked_job_position")
	@NotNull
	@NotBlank
	private String workedJobPosition;
	
	@Column(name = "year_of_beginning")
	@NotNull
	@NotBlank
	private int yearOfBeginning;
	
	@Column(name = "year_of_leaving")
	private int yearOfLeaving;
	
	@ManyToOne
	@JoinColumn(name = "cv_id")
	private CV cv;

	public JobExperience() {
		super();
	}

	public JobExperience(int id, @NotBlank String workedCompanyName, @NotBlank String workedJobPosition,
			@NotBlank int yearOfBeginning, int yearOfLeaving, CV cv) {
		super();
		this.id = id;
		this.workedCompanyName = workedCompanyName;
		this.workedJobPosition = workedJobPosition;
		this.yearOfBeginning = yearOfBeginning;
		this.yearOfLeaving = yearOfLeaving;
		this.cv = cv;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWorkedCompanyName() {
		return workedCompanyName;
	}

	public void setWorkedCompanyName(String workedCompanyName) {
		this.workedCompanyName = workedCompanyName;
	}

	public String getWorkedJobPosition() {
		return workedJobPosition;
	}

	public void setWorkedJobPosition(String workedJobPosition) {
		this.workedJobPosition = workedJobPosition;
	}

	public int getYearOfBeginning() {
		return yearOfBeginning;
	}

	public void setYearOfBeginning(int yearOfBeginning) {
		this.yearOfBeginning = yearOfBeginning;
	}

	public int getYearOfLeaving() {
		return yearOfLeaving;
	}

	public void setYearOfLeaving(int yearOfLeaving) {
		this.yearOfLeaving = yearOfLeaving;
	}
	
	

}
