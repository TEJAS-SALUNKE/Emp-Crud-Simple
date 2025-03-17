package com.example.empapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.empapp.model.Employee;
import com.example.empapp.repository.EmployeeRepository;

@Service
public class EmployeeService implements IEmpService{
	
	@Autowired
	EmployeeRepository employeeRepository;

	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}

	@Override
	public void saveEmployee(Employee employee) {
		
		employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployeeById(int id) {
		Optional<Employee> emp = employeeRepository.findById(id);
		Employee employee = null;
		if(emp.isPresent()) {
				employee = emp.get();
			}else {
				throw new RuntimeException("emp not found with id "+ id);
			}
		return employee;
	}

	@Override
	public void deleteEmployeeById(int id) {
		this.employeeRepository.deleteById(id);
	}
	
	
}
