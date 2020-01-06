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

import inventories.model.Measure;
import inventories.model.Product;
import inventories.service.MeasureService;
import inventories.service.ProductService;

@Controller
@RequestMapping("product")
public class ProductController {
	
	@Autowired
	ProductService productService;
	@Autowired
	MeasureService measureService;
	
	//redirect in product.jsp
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String toproduct() {
		return "redirect:/product/";
	}
	
	//redirect in productRegister.jsp
	@RequestMapping(value = {"/add/back", "/edit/back"}, method = RequestMethod.GET)
	public String backsProduct() {
		return "redirect:/product/";
	}
	
	@RequestMapping(value = {"/add/home", "/edit/home"}, method = RequestMethod.GET)
	public String backHome() {
		return "redirect:/";
	}
	
	//use Ajax in product.jsp
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String product() {
		return "product";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addProduct() {
		return "redirect:/product/add/";
	}
	
	@RequestMapping(value = "/add/", method = RequestMethod.GET)
	public String getProduct() {
		return "productRegister";
	}
	
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editProduct(@PathVariable("id") String id) {
		if (!productService.checkIdExist(id)) {
			return "404";
		} 
		return "productEdit";			
	}
	
	@GetMapping(value = "/getAll",  produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Product> getAllProducts() {
		return productService.findAll();
	}
	
	@PostMapping(value = "/add/getAllMeasures",  produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Measure> getAllMeasures() {
		return measureService.findAll();
	}
	@PostMapping(value = "/edit/getAllMeasures",  produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Measure> getListMeasures() {
		return measureService.findAll();
	}
	
	@GetMapping(value = "/edit/{id}/find", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Product getById(@PathVariable("id") String id) {
		return productService.find(id);
	}
	
	@PutMapping(value = "/edit/{id}/update", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Product update(@PathVariable("id") String id, @RequestBody  Product product) {
		productService.update(product);
		return product;
	}
	
	@PostMapping(value = "add/create", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Product create(@RequestBody Product product) {
		productService.create(product);
		return product;
	}
	
	@DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Product delete(@PathVariable("id") String id, @RequestBody Product product) {
		productService.delete(product); 
		return product;
	}

}
