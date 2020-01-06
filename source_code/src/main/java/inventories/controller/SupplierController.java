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

import inventories.model.Supplier;
import inventories.service.SupplierService;

@Controller
@RequestMapping("supplier")
public class SupplierController {
	@Autowired
	SupplierService supplierService;
	
	//redirect in supplier.jsp
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String tosupplier() {
		return "redirect:/supplier/";
	}
	
	//redirect in supplierRegister.jsp
	@RequestMapping(value = {"/add/back", "/edit/back"}, method = RequestMethod.GET)
	public String backsSupplier() {
		return "redirect:/supplier/";
	}
	
	@RequestMapping(value = {"/add/home", "/edit/home"}, method = RequestMethod.GET)
	public String backHome() {
		return "redirect:/";
	}
	
	//use Ajax in supplier.jsp
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String supplier() {
		return "supplier";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addSupplier() {
		return "redirect:/supplier/add/";
	}
	
	@RequestMapping(value = "/add/", method = RequestMethod.GET)
	public String getSupplier() {
		return "supplierRegister";
	}
	
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editSupplier(@PathVariable("id") String id) {
		if (!supplierService.checkIdExist(id)) {
			return "404";
		} 
		return "supplierEdit";			
	}
	
	@GetMapping(value = "/getAll",  produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Supplier> getAllSuppliers() {
		return supplierService.findAll();
	}
	
	@GetMapping(value = "/edit/{id}/find", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Supplier getById(@PathVariable("id") String id) {
		return supplierService.find(id);
	}
	
	@PutMapping(value = "/edit/{id}/update", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Supplier update(@PathVariable("id") String id, @RequestBody  Supplier supplier) {
		supplierService.update(supplier);
		return supplier;
	}
	
	@PostMapping(value = "add/create", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Supplier create(@RequestBody Supplier supplier) {
		supplierService.create(supplier);
		return supplier;
	}
	
	@DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Supplier delete(@PathVariable("id") String id, @RequestBody Supplier supplier) {
		supplierService.delete(supplier); 
		return supplier;
	}

}
