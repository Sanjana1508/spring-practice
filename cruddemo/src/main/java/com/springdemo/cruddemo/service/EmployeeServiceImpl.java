package com.springdemo.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdemo.cruddemo.dao.EmployeeRepository;
import com.springdemo.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	/*private EmployeeDAO employeeDAO;
	
	@Autowired
	public EmployeeServiceImpl(@Qualifier("employeeDAOJpaImpl") EmployeeDAO employeeDAO) {
		this.employeeDAO=employeeDAO;
	}*/
	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository=employeeRepository;
	}
	
	@Override
	public List<Employee> findAll() {
		
		//return employeeDAO.findAll();
		//return employeeRepository.findAll();
		return employeeRepository.findAllByOrderByLastNameAsc();
	}

	@Override
	public Employee findById(int theId) {
		
		//return employeeDAO.findById(theId);
		Optional<Employee> result = employeeRepository.findById(theId);
		Employee theEmployee = null;
		if(result.isPresent()) {
			theEmployee= result.get();
		}
		else {
			throw new RuntimeException("Employee id not found : "+theId);
		}
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		//employeeDAO.save(theEmployee);
		employeeRepository.save(theEmployee);
	}

	@Override
	public void deleteById(int theId) {
	
		//employeeDAO.deleteById(theId);
		employeeRepository.deleteById(theId);
	}

}
