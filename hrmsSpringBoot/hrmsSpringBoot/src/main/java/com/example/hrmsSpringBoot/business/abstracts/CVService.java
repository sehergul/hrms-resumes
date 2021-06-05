package com.example.hrmsSpringBoot.business.abstracts;

import java.util.List;

import com.example.hrmsSpringBoot.core.utilities.results.DataResult;
import com.example.hrmsSpringBoot.core.utilities.results.Result;
import com.example.hrmsSpringBoot.entities.concretes.CV;

public interface CVService {
	
	Result add(CV cv);
		
	DataResult<List<CV>> findByJobSeekerId(int id);

	DataResult<List<CV>> getAll();
}
