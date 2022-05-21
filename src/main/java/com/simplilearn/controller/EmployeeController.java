package com.simplilearn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;

import com.simplilearn.model.Employees;
import com.simplilearn.service.EmployeeService;

@Controller
public class EmployeeController {

  @Autowired
  EmployeeService employeeService;
	
  @GetMapping("/listEmployee")
  public String listEmployeeDetails(Model model) {
	
	  List<Employees> employees = employeeService.getEmployees();  
	   model.addAttribute("employees", employees);
	  
	  
	  
	  return "listEmployee";
	
}
}
