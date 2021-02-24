package com.Question_Answer_Platform.company.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Question_Answer_Platform.company.model.Company;

public interface CompanyRepo extends JpaRepository<Company, Integer> {
	
	public Company findByCompanyName(String Name);
	
	public Company findCompanyByCompanyId(Integer companyId);
	public void deleteByCompanyName(String companyName);
	public void deleteCompanyByCompanyId(Integer companyId);

}
