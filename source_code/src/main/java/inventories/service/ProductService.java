package inventories.service;

import java.util.List;


import inventories.model.Product;

public interface ProductService {
	public void create(Product product);

	public void update(Product product);

	public void delete(Product product);

	public void deleteAll();

	public Product find(Product product);

	public Product findByName(String name);

	public List<Product> findAll();

	public Product find(String id);

	public boolean checkIdExist(String id);
}
