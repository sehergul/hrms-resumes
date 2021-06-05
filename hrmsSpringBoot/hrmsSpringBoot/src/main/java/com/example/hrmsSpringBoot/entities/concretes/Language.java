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
@Table(name = "languages")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Language {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "language_name")
	@NotNull
	@NotBlank
	private String languageName;
	
	@Column(name = "level_of_language")
	@NotNull
	@NotBlank
	private double levelOfLanguage;
	
	@ManyToOne
	@JoinColumn(name = "cv_id")
	private CV cv;

	public Language() {
		super();
	}

	public Language(int id, @NotBlank String languageName, @NotBlank double levelOfLanguage, CV cv) {
		super();
		this.id = id;
		this.languageName = languageName;
		this.levelOfLanguage = levelOfLanguage;
		this.cv = cv;
	}

	public CV getCv() {
		return cv;
	}

	public void setCv(CV cv) {
		this.cv = cv;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLanguageName() {
		return languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}

	public double getLevelOfLanguage() {
		return levelOfLanguage;
	}

	public void setLevelOfLanguage(double levelOfLanguage) {
		this.levelOfLanguage = levelOfLanguage;
	}
	
	
}
