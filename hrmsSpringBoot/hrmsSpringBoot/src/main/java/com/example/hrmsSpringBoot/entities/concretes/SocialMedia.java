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
@Table(name = "social_media")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SocialMedia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "github_address")
	private String githubAddress;
	
	@Column(name = "linkedin_address")
	private String linkedInAddress;
	
	@ManyToOne
	@JoinColumn(name = "cv_id")
	private CV cv;

	public SocialMedia() {
		super();
	}

	public SocialMedia(int id, String githubAddress, String linkedInAddress) {
		super();
		this.id = id;
		this.githubAddress = githubAddress;
		this.linkedInAddress = linkedInAddress;
		this.cv = cv;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGithubAddress() {
		return githubAddress;
	}

	public void setGithubAddress(String githubAddress) {
		this.githubAddress = githubAddress;
	}

	public String getLinkedInAddress() {
		return linkedInAddress;
	}

	public void setLinkedInAddress(String linkedInAddress) {
		this.linkedInAddress = linkedInAddress;
	}
	
	

}
