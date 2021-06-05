package com.example.hrmsSpringBoot.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hrmsSpringBoot.entities.concretes.CoverLetter;

public interface CoverLetterDao extends JpaRepository<CoverLetter, Integer>{

}
