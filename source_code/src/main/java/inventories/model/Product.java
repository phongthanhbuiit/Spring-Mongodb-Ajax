package inventories.model;

import java.io.Serializable;

import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "Products")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@MongoId(value = FieldType.OBJECT_ID)	
	private String id;
	private String name;
	private Measure measure;
	@PersistenceConstructor
	public Product(String name, Measure measure) {
		super();
		this.name = name;
		this.measure = measure;
	}

	public Product() {
		super();
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
	
	public Measure getMeasure() {
		return measure;
	}
	
	public void setMeasure(Measure measure) {
		this.measure = measure;
	}
	


	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", measure=" + measure;
	}
	
	
}
