package inventories.controller;

import java.util.Collections;
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

import inventories.model.Product;
import inventories.model.Supplier;
import inventories.model.InputInfo;
import inventories.service.InputInfoService;
import inventories.service.ProductService;
import inventories.service.SupplierService;

@Controller
@RequestMapping("inputInfo")
public class InputInfoController {
	@Autowired
	InputInfoService inputInfoService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	SupplierService supplierService;
	
	//redirect in inputInfo.jsp
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String toinputInfo() {
		return "redirect:/inputInfo/";
	}
	
	//redirect in inputInfoRegister.jsp
	@RequestMapping(value = {"/add/back", "/edit/back"}, method = RequestMethod.GET)
	public String backsInputInfo() {
		return "redirect:/inputInfo/";
	}
	
	@RequestMapping(value = {"/add/home", "/edit/home"}, method = RequestMethod.GET)
	public String backHome() {
		return "redirect:/";
	}
	
	//use Ajax in inputInfo.jsp
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String inputInfo() {
		return "inputInfo";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addInputInfo() {
		return "redirect:/inputInfo/add/";
	}
	
	@RequestMapping(value = "/add/", method = RequestMethod.GET)
	public String getInputInfo() {
		return "inputInfoRegister";
	}
	
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editInputInfo(@PathVariable("id") String id) {
		if (!inputInfoService.checkIdExist(id)) {
			return "404";
		} 
		return "inputInfoEdit";			
	}
	
	@GetMapping(value = "/getAll",  produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<InputInfo> getAllInputInfos() {
		return inputInfoService.findAll();
	}
	
	@PostMapping(value = "/add/getAllProducts",  produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Product> getAllProducts() {		
		List<Product> products = productService.findAll();
		Collections.reverse(products);
		return products;
	}
	
	@PostMapping(value = "/add/{id}/findProduct",  produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Product findProductById(@PathVariable("id") String id) {
		return productService.find(id);
	}
	
	@PostMapping(value = "/edit/getAllProducts",  produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Product> getEditProducts() {
		List<Product> products = productService.findAll();
		Collections.reverse(products);
		return products;
	}
	
	@PostMapping(value = "/edit/findProduct/{id}",  produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Product findEditProductById(@PathVariable("id") String id) {
		return productService.find(id);
	}
	
	@PostMapping(value = "/add/getAllSuppliers",  produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Supplier> getAllSuppliers() {
		List<Supplier> suppliers = supplierService.findAll();
		Collections.reverse(suppliers);
		return suppliers;
	}
	
	@PostMapping(value = "/add/{id}/findSupplier",  produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Supplier findSupplierById(@PathVariable("id") String id) {
		return supplierService.find(id);
	}
	
	@PostMapping(value = "/edit/findSupplier/{id}",  produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Supplier findEditSupplierById(@PathVariable("id") String id) {
		return supplierService.find(id);
	}
	
	
	@PostMapping(value = "/edit/getAllSuppliers",  produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Supplier> getListSuppliers() {
		return supplierService.findAll();
	}
	
	@GetMapping(value = "/edit/{id}/find", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public InputInfo getById(@PathVariable("id") String id) {
		return inputInfoService.find(id);
	}
	
	@PutMapping(value = "/edit/{id}/update", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public InputInfo update(@PathVariable("id") String id, @RequestBody  InputInfo inputInfo) {
		inputInfoService.update(inputInfo);
		return inputInfo;
	}
	
	@PostMapping(value = "add/create", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public InputInfo create(@RequestBody InputInfo inputInfo) {
		inputInfoService.create(inputInfo);
		return inputInfo;
	}
	
	@DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public InputInfo delete(@PathVariable("id") String id, @RequestBody InputInfo inputInfo) {
		inputInfoService.delete(inputInfo); 
		return inputInfo;
	}
}
