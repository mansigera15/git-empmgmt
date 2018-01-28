package com.mansi.gera;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.metadata.GenericTableMetaDataProvider;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
	
	@Autowired
	EmployeeService empService;
	private int offset;
	
	@RequestMapping(value="/addemployee", method=RequestMethod.POST,consumes="application/json")
	public long createEmp(@RequestBody Employee emp){
		return empService.createEmp(emp);
	}
	
	
	@RequestMapping(value="/employee/{id}")
	public Employee getEmployeeById(long id){
		return empService.getEmployeeById(id);
	}
	@RequestMapping(value="/employees")

	public List<Employee> getEmpRecordsByPagination(@RequestParam(name="offset", required=false,defaultValue="0") int offset) {
		System.out.println(offset);
		return empService.getEmpRecordsByPagination(offset);
	}
	@RequestMapping(value="/addemployee", method=RequestMethod.PUT)
	public void updateEmp(@RequestBody Employee emp){
		empService.updateEmp(emp);
		
	}
}
