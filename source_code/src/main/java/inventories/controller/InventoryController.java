package inventories.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import inventories.model.Input;
import inventories.service.InventoryService;


@Controller
@RequestMapping("inventory")
public class InventoryController {
	
	@Autowired
	InventoryService inventoryService;
	
	@GetMapping(value = "/getAll",  produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Input> getInventorys() {
		List<Input> inventories = inventoryService.getInventorys();
		return inventories;
	}
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String toinputInfo() {
		return "redirect:/inventory/";
	}
	//use Ajax in outputInfo.jsp
	@RequestMapping(value = {"/"}, method = RequestMethod.GET)
	public String outputInfo() {
		return "inventory";
	}
	
}
