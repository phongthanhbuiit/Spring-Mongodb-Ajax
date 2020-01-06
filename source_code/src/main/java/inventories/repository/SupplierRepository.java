package inventories.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import inventories.model.Supplier;
@Repository
public interface SupplierRepository extends MongoRepository<Supplier, String>{
	@Query("{ 'name' : ?0 }")
	Supplier findByName(String name);
}
