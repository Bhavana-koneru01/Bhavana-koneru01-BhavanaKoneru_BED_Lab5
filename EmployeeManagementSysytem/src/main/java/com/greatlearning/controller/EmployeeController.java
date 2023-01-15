package com.greatlearning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.greatlearning.model.Employee;
import com.greatlearning.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeServiceImpl;

	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("allemplist", employeeServiceImpl.getAllEmployee());
		return "index";
	}

	@GetMapping("/addnew")
	public String showNewEmployeeForm(Model model) {

		model.addAttribute("employees", new Employee());
		return "newemployee";
	}

	@PostMapping("/saveEmployee")
	public String createEmployee(Employee employee) {
		employeeServiceImpl.saveEmployee(employee);
		return "redirect:/";
	}

	@GetMapping("/update/{id}")
	public String updateForm(Model model, @PathVariable(value = "id") long id) {

		model.addAttribute("Employee", employeeServiceImpl.getById(id));

		return "updateemployee";
	}

	@PostMapping("/updateEmployee")
	public String updateEmployee(Employee employee) {
		employeeServiceImpl.updateEmployee(employee);
		return "redirect:/";
	}

	@GetMapping("/deleteEmployee/{id}")
	public String deleteThroughId(@PathVariable(value = "id") long id) {
		this.employeeServiceImpl.deleteViaId(id);
		return "redirect:/";

	}

}
