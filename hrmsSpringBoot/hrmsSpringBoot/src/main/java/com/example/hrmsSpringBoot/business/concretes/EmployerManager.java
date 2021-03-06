package com.example.hrmsSpringBoot.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrmsSpringBoot.business.abstracts.EmailVerificationService;
import com.example.hrmsSpringBoot.business.abstracts.EmployerService;
import com.example.hrmsSpringBoot.business.abstracts.EmployerValidationService;
import com.example.hrmsSpringBoot.business.abstracts.JobAdvertisementValidationService;
import com.example.hrmsSpringBoot.business.abstracts.VerificationBySystemStaff;
import com.example.hrmsSpringBoot.core.utilities.results.DataResult;
import com.example.hrmsSpringBoot.core.utilities.results.ErrorDataResult;
import com.example.hrmsSpringBoot.core.utilities.results.Result;
import com.example.hrmsSpringBoot.core.utilities.results.SuccessDataResult;
import com.example.hrmsSpringBoot.dataAccess.abstracts.EmployerDao;
import com.example.hrmsSpringBoot.dataAccess.abstracts.JobAdvertisementDao;
import com.example.hrmsSpringBoot.entities.concretes.Employer;
import com.example.hrmsSpringBoot.entities.concretes.JobAdvertisement;

@Service
public class EmployerManager implements EmployerService{

	private EmployerDao employerDao;
	private EmployerValidationService employerValidationService;
	private VerificationBySystemStaff verificationBySystemStaff;
	private EmailVerificationService emailVerificationService;
	private JobAdvertisementValidationService jobAdvertisementValidationService;
	private JobAdvertisementDao jobAdvertisementDao;
	


	@Autowired
	public EmployerManager(EmployerDao employerDao, EmployerValidationService employerValidationService, 
			EmailVerificationService emailVerificationService, VerificationBySystemStaff verificationBySystemStaff,
			JobAdvertisementValidationService jobAdvertisementValidationService, JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.employerDao = employerDao;
		this.employerValidationService = employerValidationService;
		this.emailVerificationService = emailVerificationService;
		this.verificationBySystemStaff = verificationBySystemStaff;
		this.jobAdvertisementValidationService = jobAdvertisementValidationService;
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>
				(this.employerDao.findAll(), "???? verenler listelendi!");
	}

	@Override
	public Result register(Employer employer) {
		if(this.employerValidationService.totalCheck(this.employerDao.findAll(), employer)==true
				&& this.emailVerificationService.verifyEmail(employer)==true 
				&& this.verificationBySystemStaff.verify()==true) {
			this.employerDao.save(employer);
			return new SuccessDataResult("???? veren kay??t oldu!");}
		else {
			return new ErrorDataResult("???? veren kay??t olamad??!");}
		}

	@Override
	public Result addJobAdvertisement(JobAdvertisement jobAdvertisement) {
		if(this.jobAdvertisementValidationService.totalCheck(jobAdvertisement)==true) {
			this.jobAdvertisementDao.save(jobAdvertisement);
			return new SuccessDataResult("???? ilan?? eklendi!");
		}
		else {
			return new ErrorDataResult("???? ilan?? eklenemedi!");
		}
			
	}
	
	@Override
	public Result closeJobAdvertisement(JobAdvertisement jobAdvertisement) {
		if(this.jobAdvertisementValidationService.totalCheck(jobAdvertisement)==true
				&& jobAdvertisement.isActive()==true) {
			jobAdvertisement.setActive(false);
			return new SuccessDataResult("???? ilan??, i?? veren taraf??ndan kapat??ld??!");
		}
		else if(jobAdvertisement.isActive()==false){
			return new ErrorDataResult("???? ilan?? zaten aktif de??il!");
		}
		else {
			return new ErrorDataResult();
		}
	}
	

}
