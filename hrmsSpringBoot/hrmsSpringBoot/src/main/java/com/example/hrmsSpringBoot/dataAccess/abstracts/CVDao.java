package com.example.hrmsSpringBoot.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hrmsSpringBoot.entities.concretes.CV;

public interface CVDao extends JpaRepository<CV, Integer> {

	List<CV> findByJobSeeker_Id(int id);
	
}
