package com.sg.empportal.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sg.empportal.entity.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, String>{

	List<Employee> findAll(Sort sort);
}
