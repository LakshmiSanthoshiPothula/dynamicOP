package com.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cg.entities.Employee;
import com.cg.service.EmployeeService;
@Controller
public class EmployeeController {
@Autowired
private EmployeeService service;


@RequestMapping("index")
public String getHomePage(Model model){
	
	model.addAttribute("empList", service.loadAll());//passing this to index.jsp
	model.addAttribute("designations", new String[] {"System Associate","Asst Manager", "Dy Manager", "Manager"});
	model.addAttribute("employee",new Employee());
	return "index";
}

@RequestMapping(value="/save" ,method=RequestMethod.POST)
public String saveEmployee(@ModelAttribute("employee") Employee employee,Model model) {
	employee=service.save(employee);
	model.addAttribute("message", "Employee with id"+employee.getEmployeeId()+"added Successfully!");
	
	return "redirect:/index.html";
}



}
