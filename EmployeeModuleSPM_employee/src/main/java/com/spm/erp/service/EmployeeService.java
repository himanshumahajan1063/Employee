package com.spm.erp.service;

import java.util.List;

import com.spm.erp.exception.CustomException;
import com.spm.erp.model.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployee();
	
	Employee getEmployeeDetail(Integer id);
	
	void create(Employee employee);

	void deleteEmployee(Integer id);

	void updateEmployee(Integer id);
	

}
