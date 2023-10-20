package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.Employee;
import com.employee.idnotfoundexception.IdNotFoundException;
import com.employee.salarynotvalidexception.SalaryNotValidException;
import com.employee.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService es;
	@PostMapping(path="/setEmpData")
	public String setEmp(@RequestBody Employee e) {
		return es.setEmp(e);
	}
	@PostMapping(path="/setEmps")
	public String setEmps(@RequestBody List<Employee> e) {
		return es.setEmps(e);
	}
	@DeleteMapping(path="/del/{a}")
	public String delEmp(@PathVariable int a) {
		return es.delEmp(a);
	}
	@GetMapping(path="/getEmps")
	public List<Employee> getEmps() {
		return es.getEmps();
	}
	@PostMapping(path="/setSalss")
	public String setSal(@RequestBody List<Employee> e) throws SalaryNotValidException {
		return es.setSal(e);
	}
	@GetMapping(path="/getId/{e}")
	public Employee getId(@PathVariable int e) throws IdNotFoundException {
		return es.getId(e);
	}

}
