package com.mansi.gera;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {
	
	@Autowired 
	MessageSource messageSource;
	
	
	
	@Autowired
	SessionFactory sessionFactory;
	public long createEmp(Employee emp) {
		Session session=sessionFactory.openSession();
		long id= (Long) session.save(emp);
		
		return id;
	}
	public List<Employee> getAllEmployees() {
		Session session=sessionFactory.openSession();
		List<Employee> empList=session.createQuery("from Employee").list();
		return empList;
	}
	public Employee getEmployeeById(long id) {
		Session session=sessionFactory.openSession();
		Employee emp=(Employee) session.get(Employee.class, id);
		return emp;
	}
	public List<Employee> getEmpRecordsByPagination(int offset) {
		
		Session session = sessionFactory.openSession();
		Query q=session.createQuery("from Employee");
		int maxoffset=Integer.parseInt(messageSource.getMessage("maxoffset",null, null, null));
		q.setFirstResult(offset*maxoffset);
		q.setMaxResults(maxoffset);
		return q.list();
	}
	public void updateEmp(Employee emp) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(emp);
		session.getTransaction().commit();
		
	}
}
