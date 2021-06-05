package com.example.hrmsSpringBoot.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrmsSpringBoot.business.abstracts.CVService;
import com.example.hrmsSpringBoot.core.utilities.results.DataResult;
import com.example.hrmsSpringBoot.core.utilities.results.Result;
import com.example.hrmsSpringBoot.core.utilities.results.SuccessDataResult;
import com.example.hrmsSpringBoot.dataAccess.abstracts.CVDao;
import com.example.hrmsSpringBoot.entities.concretes.CV;

@Service
public class CVManager implements CVService {
	
	private CVDao cvDao;
	
	@Autowired
	public CVManager(CVDao cvDao) {
		super();
		this.cvDao = cvDao;
	}

	@Override
	public Result add(CV cv) {
		this.cvDao.save(cv);
		return new SuccessDataResult("CV başarıyla eklendi!");
	}


	@Override
	public DataResult<List<CV>> findByJobSeekerId(int id) {
		return new SuccessDataResult<List<CV>>(this.cvDao.findByJobSeeker_Id(id), "CV listelendi!");
	}
	
	

	
}
