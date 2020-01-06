package inventories.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import inventories.model.Measure;
@Repository
public interface MeasureRepository extends MongoRepository<Measure, String>{
	@Query("{ 'name' : ?0 }")
	Measure findByName(String name);
}
