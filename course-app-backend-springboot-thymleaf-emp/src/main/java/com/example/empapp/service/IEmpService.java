package com.example.empapp.service;

import java.util.List;

import com.example.empapp.model.Employee;

public interface IEmpService {
		public List<Employee> getAllEmployees();
		public void saveEmployee(Employee employee);
		public Employee getEmployeeById(int id);
		public void deleteEmployeeById(int id);
}
