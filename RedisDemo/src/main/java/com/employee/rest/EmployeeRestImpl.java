package com.employee.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.model.EmployeeModel;
import com.employee.service.IEmployeeService;

@CrossOrigin("*")
@RestController("EmployeeRestImpl")
@RequestMapping("/employee")
public class EmployeeRestImpl implements IEmployeeRest {

	Logger log = LoggerFactory.getLogger(EmployeeRestImpl.class);

	private @Autowired IEmployeeService employeeService;

	@GetMapping("/demo")
	public String demo() {
		log.info("demo method invoked");
		return "Hello";
	}

	@GetMapping("getEmployeeById/{id}")
	@Override
	public EmployeeModel getEmployeeById(@PathVariable("id") Integer id) {
		log.info("@getEmployeeById invoked with employeeId : {}", id);
		return employeeService.getEmployeeById(id);
	}

	@GetMapping("getAllEmployee")
	@Override
	public List<EmployeeModel> getAllEmployee() {
		log.info("@getAllEmployee invoked");
		return employeeService.getAllEmployee();
	}

	@PostMapping("addEmployee")
	@Override
	public EmployeeModel addEmployee(@RequestBody EmployeeModel employeeModel) {
		log.info("@addEmployee invoked with new employeeObject : {}", employeeModel);
		return employeeService.addEmployee(employeeModel);
	}

	@PutMapping("updateEmployee")
	@Override
	public EmployeeModel updateEmployee(@RequestBody EmployeeModel employeeModel) {
		log.info("@updateEmployee invoked with employeeId : {}", employeeModel.getId());
		return employeeService.updateEmployee(employeeModel);
	}

	@DeleteMapping("deleteEmployee/{id}")
	@Override
	public void deleteEmployee(@PathVariable("id") Integer id) {
		log.info("@deleteEmployee invoked with employeeId : {}", id);
		employeeService.deleteEmployee(id);
	}

	@DeleteMapping("deleteDemo/{id}")
	public void deleteDemo(@PathVariable("id") Integer id) {
		log.info("@deleteEmployee invoked with employeeId : {}", id);
		employeeService.deleteEmployee(id);
	}

}
