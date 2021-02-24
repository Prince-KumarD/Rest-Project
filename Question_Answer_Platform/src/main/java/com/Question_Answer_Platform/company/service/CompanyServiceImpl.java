package com.Question_Answer_Platform.company.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Question_Answer_Platform.company.dao.CompanyRepo;
import com.Question_Answer_Platform.company.model.Company;
import com.Question_Answer_Platform.exception.CompanyNotFoundException;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyRepo repo;
	
	@Override
	public Company addCompany(Company company) {
		
		return repo.save(company);
	}

	@Override
	public List<Company> findAllCompany() {
		return repo.findAll();
	}

	@Override
	public Company updateCompany(Company company) {
		
		return repo.save(company);
	}

	@Override
	public Company findCompanyByName(String Name) {
		Company company = null;
		company = repo.findByCompanyName(Name);
		if(company==null) {
			throw new CompanyNotFoundException("Company By Name "+Name+"was not found"); 
		}
		return company;
	}

	@Override
	public void deleteCompanyByName(String companyName) {
		repo.deleteByCompanyName(companyName);
		
	}

	@Override
	public Company findCompanyByCompanyId(Integer companyId) {
		return repo.findCompanyByCompanyId(companyId);
	}

	@Override
	public void deleteCompanyById(Integer companyId) {
		repo.deleteCompanyByCompanyId(companyId);
		
	}

	
}
