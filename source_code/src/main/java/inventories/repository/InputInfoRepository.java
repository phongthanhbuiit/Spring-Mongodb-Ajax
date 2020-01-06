package inventories.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import inventories.model.InputInfo;

@Repository
public interface InputInfoRepository extends MongoRepository<InputInfo, String> {
	@Query("{ 'name' : ?0 }")
	InputInfo findByName(String name);
}
