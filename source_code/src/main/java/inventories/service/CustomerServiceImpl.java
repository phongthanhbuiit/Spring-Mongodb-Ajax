package inventories.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inventories.model.Customer;
import inventories.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public void create(Customer customer) {
		customerRepository.insert(customer);
		
	}

	@Override
	public void update(Customer customer) {
		customerRepository.save(customer);
		
	}

	@Override
	public void delete(Customer customer) {
		customerRepository.delete(customer);
		
	}

	@Override
	public void deleteById(String id) {
		customerRepository.deleteById(id);
		
	}
	
	@Override
	public void deleteAll() {
		customerRepository.deleteAll();
		
	}

	@Override
	public Customer find(String id) {
		return customerRepository.findById(id).orElse(null);
	}

	@Override
	public Customer findByName(String name) {
		return customerRepository.findByName(name);
	}

	@Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	@Override
	public boolean checkIdExist(String id) {
		if (customerRepository.existsById(id)) {
			return true;
		} 
		return false;
	}

}
