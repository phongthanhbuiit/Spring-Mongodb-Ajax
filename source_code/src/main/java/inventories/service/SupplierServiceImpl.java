package inventories.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inventories.model.Supplier;
import inventories.repository.SupplierRepository;

@Service
public class SupplierServiceImpl implements SupplierService{

	@Autowired
	SupplierRepository supplierRepository;
	
	@Override
	public void create(Supplier supplier) {
		supplierRepository.insert(supplier);
		
	}

	@Override
	public void update(Supplier supplier) {
		supplierRepository.save(supplier);
		
	}

	@Override
	public void delete(Supplier supplier) {
		supplierRepository.delete(supplier);
		
	}

	@Override
	public void deleteAll() {
		supplierRepository.deleteAll();
		
	}

	@Override
	public Supplier find(Supplier supplier) {
		return supplierRepository.findById(supplier.getId()).orElse(null);
	}

	@Override
	public Supplier findByName(String name) {
		return supplierRepository.findByName(name);
	}

	@Override
	public List<Supplier> findAll() {
		return supplierRepository.findAll();
	}

	@Override
	public Supplier find(String id) {
		return supplierRepository.findById(id).orElse(null);
	}

	@Override
	public boolean checkIdExist(String id) {
		if (supplierRepository.existsById(id)) {
			return true;
		} 
		return false;
	}
}
