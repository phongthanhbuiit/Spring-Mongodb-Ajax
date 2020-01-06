package inventories.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inventories.model.InputInfo;
import inventories.repository.InputInfoRepository;

@Service
public class InputInfoServiceImpl implements InputInfoService{
	@Autowired
	InputInfoRepository inputInfoRepository;
	
	@Override
	public void create(InputInfo inputInfo) {
		inputInfoRepository.insert(inputInfo);
		
	}

	@Override
	public void update(InputInfo inputInfo) {
		inputInfoRepository.save(inputInfo);
		
	}

	@Override
	public void delete(InputInfo inputInfo) {
		inputInfoRepository.delete(inputInfo);
		
	}

	@Override
	public void deleteAll() {
		inputInfoRepository.deleteAll();
		
	}

	@Override
	public InputInfo find(InputInfo inputInfo) {
		return inputInfoRepository.findById(inputInfo.getId()).orElse(null);
	}

	@Override
	public InputInfo findByName(String name) {
		return inputInfoRepository.findByName(name);
	}

	@Override
	public List<InputInfo> findAll() {
		return inputInfoRepository.findAll();
	}

	@Override
	public InputInfo find(String id) {
		return inputInfoRepository.findById(id).orElse(null);
	}

	@Override
	public boolean checkIdExist(String id) {
		if (inputInfoRepository.existsById(id)) {
			return true;
		} 
		return false;
	}
}
