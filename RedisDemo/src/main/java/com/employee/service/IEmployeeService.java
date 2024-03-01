package com.employee.service;

import java.util.List;

import com.employee.model.EmployeeModel;

public interface IEmployeeService {

	List<EmployeeModel> getAllEmployee();

	EmployeeModel addEmployee(EmployeeModel employeeModel);

	EmployeeModel updateEmployee(EmployeeModel employeeModel);

	void deleteEmployee(Integer id);

	EmployeeModel getEmployeeById(int id);

}
