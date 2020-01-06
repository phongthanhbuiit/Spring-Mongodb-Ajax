package inventories.service;

import java.util.List;


import inventories.model.Supplier;

public interface SupplierService {
	public void create(Supplier supplier);

	public void update(Supplier supplier);

	public void delete(Supplier supplier);

	public void deleteAll();

	public Supplier find(Supplier supplier);

	public Supplier findByName(String name);

	public List<Supplier> findAll();

	public Supplier find(String id);

	public boolean checkIdExist(String id);
}
