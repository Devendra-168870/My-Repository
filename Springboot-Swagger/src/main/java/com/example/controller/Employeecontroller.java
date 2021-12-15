package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Employee;
import com.example.service.Employeeservice;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/emp")
public class Employeecontroller {

	@Autowired
	Employeeservice employeeService;

	@PostMapping(value = "/save")
	@ApiOperation(value = "enter a new value record")
	public String save(@RequestBody Employee emp) {
		employeeService.saveemployee(emp);
		return "Employee information stored successfully";
	}

	@GetMapping(value = "getemployees")
	@ApiOperation(value = "Fetch all employees records")
	public List<Employee> getemp() {
		return employeeService.getallemployees();
	}
	

	@GetMapping(value = "/getempbyid/{id}")
	@ApiOperation(value = "Fetch particular employee details by id")
	public Optional<Employee> getempbyid(@PathVariable int id) {
		return employeeService.getempbyid(id);
	}
	
	@DeleteMapping(value="/delete/{id}")
	@ApiOperation(value = "delete a particular employee by id")

	public void deleteemp(@PathVariable int id) {
		employeeService.deleteemployee(id);
	//	return "Employee information stored successfully";
	}

	@PutMapping(value = "/update/{id}")
	@ApiOperation(value = "update a particular employee information by id")
	public String updateemp(@RequestBody @PathVariable int id,Employee emp) {
		Employee e=employeeService.updateemployee(id);
		e.setName(emp.getName());
		e.setDesignation(emp.getDesignation());
		employeeService.saveemployee(e);
		return "employee Information Updated Successfully";
	}
}
