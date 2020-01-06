package inventories.model;

import java.io.Serializable;

import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "Measures")
public class Measure  implements Serializable{
	private static final long serialVersionUID = 1L;
	@MongoId(value = FieldType.OBJECT_ID)	
	private String id;
	private String name;
	
	public Measure() {

	}
	@PersistenceConstructor
	public Measure(String name) {
		super();
		this.name = name;
	}
	public String getId() {
		return id;
	}                                                                                          
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Measure [id=" + id + ", name=" + name + "]";
	}
	
}
