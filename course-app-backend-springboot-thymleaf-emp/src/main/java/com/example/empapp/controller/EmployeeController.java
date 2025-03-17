package com.example.empapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.empapp.model.Employee;
import com.example.empapp.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listEmployees",employeeService.getAllEmployees() );
		return "index";
	}
	
	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model) {
		Employee emp = new Employee();
		model.addAttribute("employee", emp);
		
		return "new_employee";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee")Employee employee ) {
		employeeService.saveEmployee(employee);
		return "redirect:/";
	}

	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable("id") int id , Model model) {
		Employee emp = employeeService.getEmployeeById(id);
		model.addAttribute("employee", emp);
		return "update-employee";
	}
	
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmpbyId(@PathVariable("id") int id) {
		employeeService.deleteEmployeeById(id);
		return "redirect:/";
	}
	
}
