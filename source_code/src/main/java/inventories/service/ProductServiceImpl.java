package inventories.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inventories.model.Product;
import inventories.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	ProductRepository productRepository;
	
	@Override
	public void create(Product product) {
		productRepository.insert(product);
		
	}

	@Override
	public void update(Product product) {
		productRepository.save(product);
		
	}

	@Override
	public void delete(Product product) {
		productRepository.delete(product);
		
	}

	@Override
	public void deleteAll() {
		productRepository.deleteAll();
		
	}

	@Override
	public Product find(Product product) {
		return productRepository.findById(product.getId()).orElse(null);
	}

	@Override
	public Product findByName(String name) {
		return productRepository.findByName(name);
	}

	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public Product find(String id) {
		return productRepository.findById(id).orElse(null);
	}

	@Override
	public boolean checkIdExist(String id) {
		if (productRepository.existsById(id)) {
			return true;
		} 
		return false;
	}
}
