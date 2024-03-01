package com.employee.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.model.EmployeeModel;

@Repository("IEmployeeDao")
public interface IEmployeeDao extends JpaRepository<EmployeeModel, Integer> {

}
