package inventories.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

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

import com.google.zxing.WriterException;

import inventories.model.Customer;
import inventories.model.Input;
import inventories.model.OutputInfo;
import inventories.model.Product;
import inventories.service.OutputInfoService;
import inventories.service.ProductService;
import inventories.service.CustomerService;

@Controller
@RequestMapping("outputInfo")
public class OutputInfoController {
	

	@Autowired
	OutputInfoService outputInfoService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CustomerService customerService;
	
	//redirect in outputInfo.jsp
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String tooutputInfo() {
		return "redirect:/outputInfo/";
	}
	
	//redirect in outputInfoRegister.jsp
	@RequestMapping(value = {"/add/back", "/detail/back"}, method = RequestMethod.GET)
	public String backsOutputInfo() {
		return "redirect:/outputInfo/";
	}
	
	@RequestMapping(value = {"/add/home", "/detail/home"}, method = RequestMethod.GET)
	public String backHome() {
		return "redirect:/";
	}
	
	//use Ajax in outputInfo.jsp
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String outputInfo() {
		return "outputInfo";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addOutputInfo() {
		return "redirect:/outputInfo/add/";
	}
	
	@RequestMapping(value = "/add/", method = RequestMethod.GET)
	public String getOutputInfo() {
		return "outputInfoRegister";
	}
	
	
	@RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
	public String detailOutputInfo(@PathVariable("id") String id) {
		if (!outputInfoService.checkIdExist(id)) {
			return "404";
		} 
		return "outputInfoDetail";			
	}
	
	@GetMapping(value = "/getAll",  produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<OutputInfo> getAllOutputInfos() {
		List<OutputInfo> outputInfos = outputInfoService.findAll();
		Collections.reverse(outputInfos);
		return outputInfos;
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
		
	@PostMapping(value = "/detail/getAllProducts",  produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Product> getEditProducts() {
		List<Product> products = productService.findAll();
		Collections.reverse(products);
		return products;
	}
	
	@PostMapping(value = "/detail/findProduct/{id}",  produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Product findEditProductById(@PathVariable("id") String id) {
		return productService.find(id);
	}
	
	@PostMapping(value = "/detail/findInputInfo/{id}",  produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Product findEditInputInfoById(@PathVariable("id") String id) {
		return productService.find(id);
	}
	
	@PostMapping(value = "/add/getAllCustomers",  produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Customer> getAllCustomers() {
		List<Customer> customers = customerService.findAll();
		Collections.reverse(customers);
		return customers;
	}
	
	@PostMapping(value = "/add/{id}/findCustomer",  produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Customer findCustomerById(@PathVariable("id") String id) {
		return customerService.find(id);
	}
	
	@PostMapping(value = "/detail/findCustomer/{id}",  produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Customer findEditCustomerById(@PathVariable("id") String id) {
		return customerService.find(id);
	}
	
	
	@PostMapping(value = "/detail/getAllCustomers",  produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Customer> getListCustomers() {
		List<Customer> customers = customerService.findAll();
		Collections.reverse(customers);
		return customers;
	}
	
	@GetMapping(value = "/detail/{id}/findInput", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Input> getInputById(@PathVariable("id") String id) {
		OutputInfo outputInfos = outputInfoService.find(id);
		return outputInfos.getInput();
		
	}
	
	@GetMapping(value = "/detail/{id}/find", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public OutputInfo getById(@PathVariable("id") String id) {
		return outputInfoService.find(id);
	}
	
	@PutMapping(value = "/detail/{id}/update", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public OutputInfo update(@PathVariable("id") String id, @RequestBody  OutputInfo outputInfo) {
		outputInfoService.update(outputInfo);
		return outputInfo;
	}
	
	@PostMapping(value = "add/create", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public OutputInfo create(@RequestBody OutputInfo outputInfo, HttpServletResponse response) throws WriterException, IOException {
		outputInfoService.create(outputInfo);
		return outputInfo;
	}
	
	@RequestMapping(value = "/qrcode/{id}", method = RequestMethod.GET)
	public void qrcode(@PathVariable("id") String id, HttpServletResponse response) throws Exception {
		response.setContentType("image/png");
		OutputStream outputStream = response.getOutputStream();
		outputStream.write(outputInfoService.generateQRCodeImage(id));
		outputStream.flush();
		outputStream.close();
	}

	
	@DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public OutputInfo delete(@PathVariable("id") String id, @RequestBody OutputInfo outputInfo) {
		outputInfoService.delete(outputInfo); 
		return outputInfo;
	}
}
