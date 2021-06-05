package com.example.hrmsSpringBoot.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cvs")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CV {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@ManyToOne()
	@JoinColumn(name = "job_seeker_id")
	private JobSeeker jobSeeker;

	@OneToMany(mappedBy = "cv")
	private List<School> schools;
	
	@OneToMany(mappedBy = "cv")
	private List<Language> languages;
	
	@OneToMany(mappedBy = "cv")
	private List<Knowledge> knowledges;
	
	@OneToMany(mappedBy = "cv")
	private List<SocialMedia> socialMedia;
	
	@OneToMany(mappedBy = "cv")
	private List<JobExperience> jobExperiences;
	
	@OneToMany(mappedBy = "cv")
	private List<CoverLetter> coverLetters;

	public CV() {
		super();
	}

	public CV(int id, JobSeeker jobSeeker, List<School> schools, List<Language> languages, List<Knowledge> knowledges,
			List<SocialMedia> socialMedia, List<JobExperience> jobExperiences, List<CoverLetter> coverLetters) {
		super();
		this.id = id;
		this.jobSeeker = jobSeeker;
		this.schools = schools;
		this.languages = languages;
		this.knowledges = knowledges;
		this.socialMedia = socialMedia;
		this.jobExperiences = jobExperiences;
		this.coverLetters = coverLetters;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public JobSeeker getJobSeeker() {
		return jobSeeker;
	}

	public void setJobSeeker(JobSeeker jobSeeker) {
		this.jobSeeker = jobSeeker;
	}

	public List<School> getSchools() {
		return schools;
	}

	public void setSchools(List<School> schools) {
		this.schools = schools;
	}

	public List<Language> getLanguages() {
		return languages;
	}

	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}

	public List<Knowledge> getKnowledges() {
		return knowledges;
	}

	public void setKnowledges(List<Knowledge> knowledges) {
		this.knowledges = knowledges;
	}

	public List<SocialMedia> getSocialMedia() {
		return socialMedia;
	}

	public void setSocialMedia(List<SocialMedia> socialMedia) {
		this.socialMedia = socialMedia;
	}

	public List<JobExperience> getJobExperiences() {
		return jobExperiences;
	}

	public void setJobExperiences(List<JobExperience> jobExperiences) {
		this.jobExperiences = jobExperiences;
	}

	public List<CoverLetter> getCoverLetters() {
		return coverLetters;
	}

	public void setCoverLetters(List<CoverLetter> coverLetters) {
		this.coverLetters = coverLetters;
	}
	
	
	
	
}
