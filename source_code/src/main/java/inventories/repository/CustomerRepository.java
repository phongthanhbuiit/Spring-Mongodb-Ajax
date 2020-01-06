package inventories.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import inventories.model.Customer;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String>{
	
	@Query("{ 'name' : ?0 }")
	Customer findByName(String name);
}
