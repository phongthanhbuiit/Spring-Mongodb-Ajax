package inventories.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inventories.model.Input;
import inventories.model.InputInfo;
import inventories.model.OutputInfo;
import inventories.model.Product;

@Service
public class InventoryServiceImpl implements InventoryService {
	
	@Autowired
	OutputInfoService outputInfoService;
	
	@Autowired
	InputInfoService inputInfoService;

	
	@Override
	public List<Input> getInventorys() {
		List<InputInfo> inputInfos = inputInfoService.findAll();
		List<OutputInfo> outputInfos = outputInfoService.findAll();
		
		HashMap<String, Input> inventoriesMap = new HashMap<>();
		
	
		//get list product input
		List<Input> productInput = new ArrayList<>();

		for (InputInfo inputInfo :inputInfos) {
			
			Product product = inputInfo.getProduct();
			
			Input input = new Input();
			input.setProduct(product);
			input.setQty(inputInfo.getQty());
			input.setCount(inputInfo.getCount());
			productInput.add(input);
		}
		
		for (Input input:productInput) {
			if (inventoriesMap.containsKey(input.getProduct().getId())) {
				
				Input newInput = new Input();
				Input oldInput = inventoriesMap.get(input.getProduct().getId());
				//cap nhap gia tri moi
				newInput.setProduct(input.getProduct());
				newInput.setQty(input.getQty()+oldInput.getQty());
				newInput.setCount(input.getCount()+oldInput.getCount());
				inventoriesMap.replace(input.getProduct().getId(), newInput);
			} else {
				//them moi
				inventoriesMap.put(input.getProduct().getId(), input);
				
			}
		}
		
		
		List<Input> productOutput = new ArrayList<>();
		
		for (OutputInfo outputInfo :outputInfos) {
			
			for (Input input:outputInfo.getInput()) {
				productOutput.add(input);
				
			}
			
		}
		
		for (Input input:productOutput) {
			
			if (inventoriesMap.containsKey(input.getProduct().getId())) {
				Input newInput = new Input();
				Input oldInput = inventoriesMap.get(input.getProduct().getId());
				//cap nhap gia tri moi
				newInput.setProduct(input.getProduct());
				newInput.setQty(oldInput.getQty()-input.getQty());
				newInput.setCount(oldInput.getCount()-input.getCount());
				inventoriesMap.replace(input.getProduct().getId(), oldInput, newInput);
			} 
		}
		
		List<Input> inventories = new ArrayList<>();
		  for (String key : inventoriesMap.keySet()) {
			  inventories.add(inventoriesMap.get(key));
		    }
		return inventories;
	}
}
