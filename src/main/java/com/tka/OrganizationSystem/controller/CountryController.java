package com.tka.OrganizationSystem.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tka.OrganizationSystem.entity.Country;
import com.tka.OrganizationSystem.entity.Employee;
import com.tka.OrganizationSystem.service.CountryService;

@RestController
@RequestMapping("api")
public class CountryController {
	
	@Autowired
	CountryService service;
	
	@PostMapping("addcountry")
	public String addCountry(@RequestBody Country c) {
		//System.out.println(c);
		
		String msg= service.addCountry(c);
		return msg;
		
	}
	
	@PutMapping("updatecountry/{id}")
	public String updateCountry(@PathVariable int id,@RequestBody Country c) {
	 String msg=service.updateCountry(id,c);
     return msg;
}
	
	@DeleteMapping("deletecountry/{id}")
	public String deleteCountry(@PathVariable int id) {
	String msg=	service.deleteCountry(id);
		return msg;
		
	}
	
	
	@GetMapping("getparticularCountry/{id}")
	public Country getParticularountryById(@PathVariable int id) {
		
		Country country= service.getParticularCountryByID(id);
		return country;
	}
	
	
	@GetMapping("getallcountry")
	public List<Country> getAllCountry() {
		List<Country> list= service.getAllCountry();
		return list;
		
	}
	
	@PostMapping("addemployee")
	public String addEmployee(@RequestBody Employee emp) {
		String msg=service.addEmployee(emp);
		return msg;
	}
	
	@PutMapping("upadteemployee")
	public String upadteEmployee(@RequestBody Employee emp) {
		String msg=service.upadteEmployee(emp);
		return msg;
		}
	
	@DeleteMapping("deleteemployee/{id}")
	public String deletEmplpoyee(@PathVariable int id) {
	String msg=service.deletEmplpoyee(id);
	return msg;
	}
	

	@GetMapping("getallemployee")
	public List<Employee> getAllEmployee(){
	List<Employee> list=service.getAllEmployee();
		return list;
		
	}
	
	@GetMapping("getbypatricularid/{id}")
	public Employee getByParticlarId(@PathVariable int id) {
		Employee employee=service.getEmployeeByParticlarId(id);
		return employee;
		
	}
	
	@GetMapping("getemployeebystatus/{status}")
	public List<Employee> getEmployeeByStatus(@PathVariable String status){
		List<Employee> list=service.getEmployeeByStatus(status);
		return list;
	}
	
	@PostMapping("logincheck")
	public HashMap loginCheck(@RequestBody Employee emp) {
		HashMap map=service.loginCheck(emp);
			return	map;
	}
	@GetMapping ("getemployeesalarygreatorthan/{salary}")
	public List<Employee>getEmployeeSalaryGreatorThan(@PathVariable double salary){
		List<Employee>list=service.getemployeesalarygreatorthan(salary);
		return list;
	}
	
}