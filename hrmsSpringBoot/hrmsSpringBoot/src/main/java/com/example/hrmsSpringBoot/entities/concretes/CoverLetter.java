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
@Table(name = "cover_letters")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CoverLetter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "text")
	@NotNull
	@NotBlank
	private String text;
	
	@ManyToOne
	@JoinColumn(name = "cv_id")
	private CV cv;
		
	public CoverLetter() {
		super();
	}

	public CoverLetter(int id, @NotNull @NotBlank String text, CV cv) {
		super();
		this.id = id;
		this.text = text;
		this.cv = cv;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
	
	
}
