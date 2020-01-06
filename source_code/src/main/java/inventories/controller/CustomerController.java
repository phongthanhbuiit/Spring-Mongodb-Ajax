package inventories.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import inventories.model.Customer;
import inventories.service.CustomerService;

@Controller
@RequestMapping("customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	//redirect in customer.jsp
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String tocustomer() {
		return "redirect:/customer/";
	}
	
	//redirect in customerRegister.jsp
	@RequestMapping(value = {"/add/back", "/edit/back"}, method = RequestMethod.GET)
	public String backsCustomer() {
		return "redirect:/customer/";
	}
	
	@RequestMapping(value = {"/add/home", "/edit/home"}, method = RequestMethod.GET)
	public String backHome() {
		return "redirect:/";
	}
	
	//use Ajax in customer.jsp
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String customer() {
		return "customer";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addCustomer() {
		return "redirect:/customer/add/";
	}
	
	@RequestMapping(value = "/add/", method = RequestMethod.GET)
	public String getCustomer() {
		return "customerRegister";
	}
	
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editCustomer(@PathVariable("id") String id) {
		if (!customerService.checkIdExist(id)) {
			return "404";
		} 
		return "customerEdit";			
	}
	
	@GetMapping(value = "/getAll",  produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Customer> getAllCustomers() {
		return customerService.findAll();
	}
	
	@GetMapping(value = "/edit/{id}/find", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Customer getById(@PathVariable("id") String id) {
		return customerService.find(id);
	}
	
	@PutMapping(value = "/edit/{id}/update", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Customer update(@PathVariable("id") String id, @RequestBody  Customer customer) {
		customerService.update(customer);
		return customer;
	}
	
	@PostMapping(value = "add/create", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Customer create(@RequestBody Customer customer) {
		customerService.create(customer);
		return customer;
	}
	
	@DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Customer delete(@PathVariable("id") String id, @RequestBody Customer customer) {
		customerService.delete(customer); 
		return customer;
	}

	
}
