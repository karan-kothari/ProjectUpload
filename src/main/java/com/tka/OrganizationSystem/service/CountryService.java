package com.tka.OrganizationSystem.service;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.tka.OrganizationSystem.dao.CountryDao;
import com.tka.OrganizationSystem.entity.Country;
import com.tka.OrganizationSystem.entity.Employee;

@Service
public class CountryService {
	
	@Autowired
	CountryDao dao;



public String addCountry(Country c) {
	String msg= dao.addCountry(c);

if(Objects.isNull(msg)) {
	msg="Country is not addedd...";
}

return msg;

}

public String updateCountry( int id,Country c) {
	String msg= dao.updateCountry(id, c);

if(Objects.isNull(msg)) {
	msg="Country is not addedd...";
}

return msg;

}

public String deleteCountry(int id) {
	String msg=dao.deleteCountry(id);
	
	if(Objects.isNull(msg)) {
		msg="Country is not deleteted....";
	}
	return msg;
}


public List<Country> getAllCountry() {
	List<Country>list=dao.getAllCountry();
	return list;
}



public Country getParticularCountryByID(int id) {
Country country=dao.getParticularCountryByID(id);
	
	if(Objects.isNull(country)) {
		country=null;
	}
	return country;

}

public String addEmployee(Employee emp) {
	String msg=dao.addEmployee(emp);
	if(Objects.isNull(msg)) {
		msg="Record is not added.....";
	}
	return msg;
}

public String upadteEmployee(Employee emp) {
    String msg= dao.upadteEmployee(emp);
    
    if(Objects.isNull(msg)) {
    	msg="Employee record is not Upadtedted....";
    }
	return msg;
}



public String deletEmplpoyee(int id) {
	String msg=dao.deletEmplpoyee(id);
	
	if(Objects.isNull(msg)) {
		msg="Employee record is not deleted....";
	}
	return msg;
}

public List<Employee> getAllEmployee() {
	List<Employee> list= dao.getAllEmployee();
	return list;
}

public Employee getEmployeeByParticlarId(int id) {
	Employee employee=dao.getEmployeeByParticlarId(id);
	return employee;
}

public List<Employee> getEmployeeByStatus(String status) {
	List<Employee> list=dao.getEmployeeByStatus(status);
	if(Objects.isNull(list)) {
		list=null;
	}
	return list;
}



public HashMap loginCheck(Employee emp) {
Employee e=dao.loginCheck(emp);
	
	HashMap map=new HashMap();
	
	if(Objects.isNull(e)) {
	map.put("msg", "Invalid user");
	map.put("user", e);
	}else {
		map.put("msg", "Valid user");
		map.put("user", e);
	}
	return map;
}

public List<Employee> getemployeesalarygreatorthan(double salary) {
	List<Employee>list=dao.getemployeesalarygreatorthan(salary);
	if(Objects.isNull(list)) {
		list=null;
	}
	return list;
	
}


}