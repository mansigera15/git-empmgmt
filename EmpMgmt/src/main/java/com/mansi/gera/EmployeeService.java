package com.mansi.gera;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeDao empDao;
	public long createEmp(Employee emp) {
		return empDao.createEmp(emp);
	}
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return empDao.getAllEmployees();
	}
	public Employee getEmployeeById(long id) {
		// TODO Auto-generated method stub
		return empDao.getEmployeeById(id);
	}
	public List<Employee> getEmpRecordsByPagination(int offset) {
		return empDao.getEmpRecordsByPagination(offset);
	}
	public void updateEmp(Employee emp) {
		empDao.updateEmp(emp);
		
	}

}
