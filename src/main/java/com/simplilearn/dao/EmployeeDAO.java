package com.simplilearn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.simplilearn.model.Employees;

@Repository
public class EmployeeDAO {
	
	  
	// checks do we have JDBCTEMPLATE in IOC? if no, it creates and put it in IOC.
	// wire it on EmplyeeDAO
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	public List<Employees> getEmployees() {
		
		return jdbcTemplate.query("select * from Employees", new RowMapper<Employees>() {

			@Override
			public Employees mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Employees emp = new Employees();
				emp.setEmpId(rs.getLong(1));
				emp.setDept(rs.getString(2));
				emp.setFirstName(rs.getString(3));
				emp.setLastName(rs.getString(4));
				emp.setSalary(rs.getLong(5));
		
				return emp;	
			
			}
			}
		);
			
		
	}
	
	
	
	
	
	
	
	
}
