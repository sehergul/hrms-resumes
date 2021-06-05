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
@Table(name = "knowledges")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Knowledge {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "programming_language_or_technology")
	@NotNull
	@NotBlank
	private String programmingLanguageOrTechnology;

	@ManyToOne
	@JoinColumn(name = "cv_id")
	private CV cv;
	
	public Knowledge() {
		super();
	}

	public Knowledge(int id, @NotNull @NotBlank String programmingLanguageOrTechnology, CV cv) {
		super();
		this.id = id;
		this.programmingLanguageOrTechnology = programmingLanguageOrTechnology;
		this.cv = cv;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProgrammingLanguageOrTechnology() {
		return programmingLanguageOrTechnology;
	}

	public void setProgrammingLanguageOrTechnology(String programmingLanguageOrTechnology) {
		this.programmingLanguageOrTechnology = programmingLanguageOrTechnology;
	}

	public CV getCv() {
		return cv;
	}

	public void setCv(CV cv) {
		this.cv = cv;
	}
	
	
	
	
	
	
}
