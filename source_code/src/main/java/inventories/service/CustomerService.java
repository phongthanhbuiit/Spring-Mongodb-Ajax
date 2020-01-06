package inventories.service;

import java.util.List;


import inventories.model.Customer;

public interface CustomerService {
	public void create(Customer customer);

	public void update(Customer customer);

	public void delete(Customer customer);

	public void deleteAll();

	public Customer find(String id);

	public Customer findByName(String name);

	public List<Customer> findAll();

	public void deleteById(String id);
	
	public boolean checkIdExist(String id);

}
