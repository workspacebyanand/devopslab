package com.empmgmt.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.empmgmt.model.Employee;
import com.empmgmt.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	@GetMapping("/")
	public String homePage(Model model) {
		List<Employee> emps = empService.getAllEmployees(); 
		model.addAttribute("emp",emps);
		return "index";
	}
	
	@GetMapping("/addemployee")
	public String addEmpPage() {
		return "add_employee";
	}
	
	@PostMapping("/register")
	public String empRegister(@ModelAttribute Employee emp, HttpSession session) {	
		empService.addEmployee(emp);
		session.setAttribute("msg", "Employee added successfully...");
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String editEmployee(@PathVariable int id,Model m) {
		Employee e = empService.getEmpById(id);
		m.addAttribute("emp",e);
		return "edit";
	}
	
	@PostMapping("/update")
	public String updateEmployee(@ModelAttribute Employee emp, HttpSession session) {
		empService.addEmployee(emp);
		session.setAttribute("msg","employee data updated successfully...");
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable int id,HttpSession session) {
		empService.deleteEmployeeById(id);
		session.setAttribute("msg","employee data deleted successfully...");
		return "redirect:/";
	}
}
