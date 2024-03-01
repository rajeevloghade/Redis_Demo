package com.employee.rest;

import java.util.List;

import com.employee.model.EmployeeModel;

public interface IEmployeeRest {

	List<EmployeeModel> getAllEmployee();

	EmployeeModel addEmployee(EmployeeModel employeeModel);

	EmployeeModel updateEmployee(EmployeeModel employeeModel);

	void deleteEmployee(Integer id);

	EmployeeModel getEmployeeById(Integer id);

}
