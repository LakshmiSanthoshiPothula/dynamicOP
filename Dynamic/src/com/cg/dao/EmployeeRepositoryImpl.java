package com.cg.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.hibernate.annotations.Persister;
import org.hibernate.engine.spi.PersistenceContext;
import org.springframework.stereotype.Repository;

import com.cg.entities.Employee;
@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
     
@javax.persistence.PersistenceContext //to auto create em from emf
 private EntityManager em;
	
	@Override
	public Employee save(Employee employee) {
	     em.persist(employee);
	     em.flush();
		return employee;
	}

	@Override
	public List<Employee> loadAll() {
		
		
		TypedQuery<Employee> resultList= em.createQuery("SELECT e FROM Employee e", Employee.class);
		return resultList.getResultList();
	}

}
