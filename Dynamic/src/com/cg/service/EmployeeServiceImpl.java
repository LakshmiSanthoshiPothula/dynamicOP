package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.dao.EmployeeRepository;
import com.cg.dao.EmployeeRepositoryImpl;
import com.cg.entities.Employee;
@Service
@Transactional // automatic transactions
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
   private EmployeeRepository dao;
	@Override
	public Employee save(Employee employee) {
		// TODO Auto-generated method stub
		return dao.save(employee);
	}

	@Override
	public List<Employee> loadAll() {
		// TODO Auto-generated method stub
		return dao.loadAll();
	}

}
