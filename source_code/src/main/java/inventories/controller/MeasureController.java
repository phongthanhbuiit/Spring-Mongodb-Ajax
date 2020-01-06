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
import inventories.service.MeasureService;

@Controller
@RequestMapping("measure")
public class MeasureController {
	
	@Autowired
	MeasureService measureService;
	
	//redirect in measure.jsp
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String tomeasure() {
		return "redirect:/measure/";
	}
	
	//redirect in measureRegister.jsp
	@RequestMapping(value = {"/add/back", "/edit/back"}, method = RequestMethod.GET)
	public String backsMeasure() {
		return "redirect:/measure/";
	}
	
	@RequestMapping(value = {"/add/home", "/edit/home"}, method = RequestMethod.GET)
	public String backHome() {
		return "redirect:/";
	}
	
	//use Ajax in measure.jsp
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String measure() {
		return "measure";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addMeasure() {
		return "redirect:/measure/add/";
	}
	
	@RequestMapping(value = "/add/", method = RequestMethod.GET)
	public String getMeasure() {
		return "measureRegister";
	}
	
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editMeasure(@PathVariable("id") String id) {
		if (!measureService.checkIdExist(id)) {
			return "404";
		} 
		return "measureEdit";			
	}
	
	@GetMapping(value = "/getAll",  produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Measure> getAllMeasures() {
		return measureService.findAll();
	}
	
	@GetMapping(value = "/edit/{id}/find", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Measure getById(@PathVariable("id") String id) {
		return measureService.find(id);
	}
	
	@PutMapping(value = "/edit/{id}/update", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Measure update(@PathVariable("id") String id, @RequestBody  Measure measure) {
		measureService.update(measure);
		return measure;
	}
	
	@PostMapping(value = "add/create", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Measure create(@RequestBody Measure measure) {
		measureService.create(measure);
		return measure;
	}
	
	@DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Measure delete(@PathVariable("id") String id, @RequestBody Measure measure) {
		measureService.delete(measure); 
		return measure;
	}

}
