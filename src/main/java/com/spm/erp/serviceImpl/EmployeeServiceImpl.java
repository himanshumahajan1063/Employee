package com.spm.erp.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spm.erp.exception.CustomException;
import com.spm.erp.model.Employee;
import com.spm.erp.repository.EmployeeRepository;
import com.spm.erp.service.EmployeeService;
import com.spm.erp.serviceImpl.utility.Util;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployee() {

		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeDetail(Integer id) {

		return employeeRepository.getEmployeeById(id);

	}

	@Override
	public void create(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployee(Integer id) {
		try {
			employeeRepository.deleteById(id);
		} catch (Exception e) {
			System.out.println(new CustomException("Problem deleting employee with id : " + id));
		}
	}

	@Override
	public void updateEmployee(Integer id, Employee employee) {
		try {
			Employee emp = employeeRepository.findById(id).get();
			emp = Util.updateProperties(emp, employee);
			emp.setId(id);
			employeeRepository.save(emp);
		} catch (Exception e) {
			System.out.println(new CustomException("Prolems updating employee with id " + id));
		}
	}
}
