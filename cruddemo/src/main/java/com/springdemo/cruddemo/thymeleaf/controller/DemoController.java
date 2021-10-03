package com.springdemo.cruddemo.thymeleaf.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springdemo.cruddemo.entity.Employee;
import com.springdemo.cruddemo.service.EmployeeService;

@Controller
public class DemoController {
	
	private EmployeeService employeeService;
	
	public DemoController(EmployeeService employeeService) {
		this.employeeService=employeeService;
	}
	
	/*List<Employee> theEmployees;
	
	@PostConstruct
	public void LoadData() {
		theEmployees = new ArrayList<>();
		
		Employee emp1= new Employee(1,"mary","public","mary@gmail.com");
		Employee emp2= new Employee(1,"sanjana","podduturi","sanjana@gmail.com");
		
		theEmployees.add(emp1);
		theEmployees.add(emp2);
	}*/

	@GetMapping("/hello")
	public String sayHello(Model theModel) {
		theModel.addAttribute("theDate", new java.util.Date());
		return "helloworld";
	}
	
	@GetMapping("/employees/list")
	public String getEmployees(Model theModel) {
		
		List<Employee> theEmployees = employeeService.findAll();
		theModel.addAttribute("employees",theEmployees);
		return "list-employees";
		
	}
	
	@GetMapping("/employees/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		Employee theEmployee = new Employee();
		
		theModel.addAttribute("employee",theEmployee);
		return "employee-form";
		
	}
	
	@GetMapping("/employees/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId,Model theModel) {
		
		Employee theEmployee = employeeService.findById(theId);
		
		theModel.addAttribute("employee",theEmployee);
		return "employee-form";
		
	}
	
	
	@PostMapping("/employees/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
		
		employeeService.save(theEmployee);
		
		return "redirect:/employees/list";
	}
	
	@GetMapping("/employees/delete")
	public String delete(@RequestParam("employeeId") int theId) {
		employeeService.deleteById(theId);
		return "redirect:/employees/list";
	}
}
