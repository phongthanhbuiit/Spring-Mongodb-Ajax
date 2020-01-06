package inventories.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inventories.model.Measure;
import inventories.repository.MeasureRepository;

@Service
public class MeasureServiceImpl implements MeasureService{

	@Autowired
	MeasureRepository measureRepository;
	
	@Override
	public void create(Measure measure) {
		measureRepository.insert(measure);
	}

	@Override
	public void update(Measure measure) {
		measureRepository.save(measure);
	}

	@Override
	public void delete(Measure measure) {
		measureRepository.delete(measure);
	}

	@Override
	public void deleteAll() {
		measureRepository.deleteAll();
	}

	@Override
	public Measure find(Measure measure) {
		return measureRepository.findById(measure.getId()).orElse(null);
	}

	@Override
	public List<Measure> findAll() {
		return measureRepository.findAll();
	}

	@Override
	public Measure findByName(String name) {
		return measureRepository.findByName(name);
	}

	@Override
	public void deleteById(String id) {
		measureRepository.deleteById(id);	
	}

	@Override
	public boolean checkIdExist(String id) {
		if (measureRepository.existsById(id)) {
			return true;
		} 
		return false;
	}

	@Override
	public Measure find(String id) {
		return measureRepository.findById(id).orElse(null);
	}

}
