package com.spm.erp.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.spm.erp.model.Employee;
import com.spm.erp.repository.EmployeeRepository;
import com.spm.erp.service.EmployeeService;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class EmployeeController {

	@Autowired
	EmployeeRepository repository;
	@Autowired
	EmployeeService service;

	@GetMapping("/employee")
	public List<Employee> getEmployeeList() {
		return service.getAllEmployee();
	}
	
	@GetMapping("/employee/{id}")
	public Employee getEmployeeDetail(@PathVariable Integer id) {
		return service.getEmployeeDetail(id);
	}
	
	@PostMapping("/employee")
    private ResponseEntity<Void> addEmployee(@RequestBody Employee employee) {
        try {
            service.create(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
	
	@PutMapping("/employee/{id}")
    private ResponseEntity<Void> updateEmployee(@PathVariable Integer id) {
        try {
            service.updateEmployee(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
	
	
	@DeleteMapping("/employee/{id}")
    private ResponseEntity<Void> deleteEmployee(@PathVariable Integer id) {
        try {
            service.deleteEmployee(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
