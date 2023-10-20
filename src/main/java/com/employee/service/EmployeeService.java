package com.employee.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.dao.EmployeeDao;
import com.employee.entity.Employee;
import com.employee.idnotfoundexception.IdNotFoundException;
import com.employee.salarynotvalidexception.SalaryNotValidException;


@Service
public class EmployeeService {
	@Autowired
	EmployeeDao ed;
	
	public String setEmp(Employee e) {
		return ed.setEmp(e);
	}
	public String setEmps(List<Employee> e) {
		return ed.setEmps(e);
	}
	public String delEmp(int a) {
		return ed.delEmp(a);
	}
	public List<Employee> getEmps() {
		return ed.getEmps();
	}
	public String setSal(List<Employee> e) throws SalaryNotValidException {
		List<Employee> a = e.stream().filter(x->x.getSalary()<35000).collect(Collectors.toList());
		if(a.isEmpty()) {
			return ed.setEmps(a);
		}
		else {
			throw new SalaryNotValidException("Not a Valid Salaryy...");
		}
	}
	public Employee getId(int e) throws IdNotFoundException {
		return ed.getId(e);
	
		
	}

}
