package com.Question_Answer_Platform.company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Question_Answer_Platform.company.model.Company;
import com.Question_Answer_Platform.company.service.CompanyService;

@RestController
@RequestMapping("/company")
public class CompanyRestController {

	@Autowired
	private CompanyService companyService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Company>> getAllCompany(){
		List<Company> company =  companyService.findAllCompany();
		return new ResponseEntity<>(company, HttpStatus.OK);
	}
	
	@GetMapping("/findCompanyByName/{name}")
	public ResponseEntity<Company> getCompanyByName(@PathVariable("name") String name){
		Company company = companyService.findCompanyByName(name);
		return new ResponseEntity<>(company, HttpStatus.OK);
	}
	
	@GetMapping("/find/{companyId}")
	public ResponseEntity<Company> getCompanyByCompanyId(@PathVariable("companyId") Integer companyId){
		Company company = companyService.findCompanyByCompanyId(companyId);
		return new ResponseEntity<>(company, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Company> addCompany(@RequestBody Company company){
		Company newCompany = companyService.addCompany(company);
		return new ResponseEntity<>(newCompany, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Company> updateCompany(@RequestBody Company company){
		Company updateCompany = companyService.updateCompany(company);
		return new ResponseEntity<>(updateCompany, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{name}")
	public ResponseEntity<?> deleteCompany(@PathVariable("name") String name){
		companyService.deleteCompanyByName(name);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteById/{companyId}")
	public ResponseEntity<?> deleteCompanyById(@PathVariable("companyId") Integer companyId){
		companyService.deleteCompanyById(companyId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
