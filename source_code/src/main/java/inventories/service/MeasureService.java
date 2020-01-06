package inventories.service;

import java.util.List;


import inventories.model.Measure;

public interface MeasureService {
	public void create(Measure measure);

	public void update(Measure measure);

	public void delete(Measure measure);

	public void deleteAll();

	public Measure find(String id);

	public Measure findByName(String name);
	
	public List<Measure> findAll();
	
	public void deleteById(String id);
	
	public boolean checkIdExist(String id);

	Measure find(Measure measure);
}
