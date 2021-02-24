package com.Question_Answer_Platform.company.service;


import java.util.List;

import com.Question_Answer_Platform.company.model.Company;

public interface CompanyService {

	public Company addCompany(Company company);
	public List<Company> findAllCompany();
	public Company updateCompany(Company company);
	public Company findCompanyByName(String Name);
	public Company findCompanyByCompanyId(Integer companyId);
	public void deleteCompanyByName(String companyName);
	public void deleteCompanyById(Integer companyId);
}
