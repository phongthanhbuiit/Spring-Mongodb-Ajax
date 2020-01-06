package inventories.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import inventories.model.Product;
@Repository
public interface ProductRepository extends MongoRepository<Product, String>{
	
	@Query("{ 'name' : ?0 }")
	Product findByName(String name);
}
