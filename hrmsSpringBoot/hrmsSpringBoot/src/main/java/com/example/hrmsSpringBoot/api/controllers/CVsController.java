package com.example.hrmsSpringBoot.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hrmsSpringBoot.business.abstracts.CVService;
import com.example.hrmsSpringBoot.core.utilities.results.DataResult;
import com.example.hrmsSpringBoot.core.utilities.results.Result;
import com.example.hrmsSpringBoot.entities.concretes.CV;

@RestController
@RequestMapping("/api/cvs")
public class CVsController {
	
	private CVService cvService;

	@Autowired
	public CVsController(CVService cvService) {
		super();
		this.cvService = cvService;
	}
	
	@GetMapping("/findByJobSeekerId")
	public DataResult<List<CV>> findByJobSeekerId(@RequestParam ("jobSeeker") int id){
		return this.cvService.findByJobSeekerId(id);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CV cv) {
		return this.cvService.add(cv);
	}

}
