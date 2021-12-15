package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.Employeerepository;
import com.example.model.Employee;

@Service
public class Employeeservice {
	
	@Autowired
	Employeerepository employeeRepository;

	public String saveemployee(Employee emp) {
		
		employeeRepository.save(emp);
		return "Employee information saved successfully";
	}
	
	public List<Employee> getallemployees(){
		return employeeRepository.findAll();	
	}
	
	public Optional<Employee> getempbyid(int id){
		return employeeRepository.findById(id);	
	}
	
	public void deleteemployee(int id) {
		employeeRepository.deleteById(id);	
	}
	
	public Employee updateemployee(int id) {
		return employeeRepository.getOne(id);
		
	}
	
}
