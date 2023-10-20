package com.employee.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.employee.entity.Employee;
import com.employee.idnotfoundexception.IdNotFoundException;
import com.employee.repository.EmployeeRepository;

@Repository
public class EmployeeDao {
	@Autowired
	EmployeeRepository er;
	
	public String setEmp(Employee e) {
		er.save(e);
		return "Added Successfully...";
	}
	public String setEmps(List<Employee> e) {
		er.saveAll(e);
		return "All Employee Details Added Successfully...";
	}
	public String delEmp(int a) {
		er.deleteById(a);
		return "Emp Details Successfully Deleted...";
	}
	public List<Employee> getEmps() {
		return er.findAll();
	}
	public Employee getId(int e) throws IdNotFoundException {
		return er.findById(e).orElseThrow(()->new IdNotFoundException("Not a Valid Id..."));
	}

}
