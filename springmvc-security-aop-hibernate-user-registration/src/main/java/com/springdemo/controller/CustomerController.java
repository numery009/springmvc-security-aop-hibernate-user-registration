package com.springdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springdemo.entity.Customer;
import com.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	/*
	 * @GetMapping("/list") public String listCustomer(Model theModel) {
	 * 
	 * List<Customer> theCustomers = customerService.getCustomers();
	 * 
	 * theModel.addAttribute("customers", theCustomers);
	 * System.out.println("Customers " + theCustomers); return "leaders"; }
	 */

	@GetMapping("/showFromForAdd")
	public String showFormForAdd(Model theModel) {

		// Create model attribute to bind form data
		Customer theCustomer = new Customer();
		theModel.addAttribute("customer", theCustomer);
		return "customer-form";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {

		customerService.saveCustomer(theCustomer);
		// return "redirect:/customer/list";
		return "redirect:/leaders";
	}

	@GetMapping("/showFormForUpdate")
	public String showFromForUpdate(@RequestParam("customerId") int theId,
			Model theModel) {
		Customer customer = customerService.getCustomer(theId);

		theModel.addAttribute("customer", customer);

		return "customer-form";
	}

	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId) {

		customerService.deleteCustomer(theId);

		// return "redirect:/customer/list";
		return "redirect:/leaders";
	}

	/*
	 * @GetMapping("/search") public String searchCustomers(
	 * 
	 * @RequestParam("theSearchName") String theSearchName, Model theModel) {
	 * 
	 * // search customers from the service List<Customer> theCustomers =
	 * customerService .searchCustomers(theSearchName);
	 * 
	 * // add the customers to the model theModel.addAttribute("customers",
	 * theCustomers);
	 * 
	 * //return "list-customers";
	 * 
	 * return "leaders"; }
	 */

}
