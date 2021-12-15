package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.model.Employee;


public interface Employeerepository extends JpaRepository<Employee,Integer> {

}
