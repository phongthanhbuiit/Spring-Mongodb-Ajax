package inventories.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import inventories.model.OutputInfo;
@Repository
public interface OutputInfoRepository extends MongoRepository<OutputInfo, String> {
	@Query("{ 'name' : ?0 }")
	OutputInfo findByName(String name);
}
