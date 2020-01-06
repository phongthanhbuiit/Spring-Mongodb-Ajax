package inventories.service;

import java.util.List;


import inventories.model.InputInfo;

public interface InputInfoService {
	
	public void create(InputInfo inputInfo);

	public void update(InputInfo inputInfo);

	public void delete(InputInfo inputInfo);

	public void deleteAll();

	public InputInfo find(InputInfo inputInfo);

	public InputInfo findByName(String name);

	public List<InputInfo> findAll();

	public InputInfo find(String id);

	public boolean checkIdExist(String id);
}
