package inventories.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "OutputInfos")
public class OutputInfo {
	
	private static final long serialVersionUID = 1L;
	@MongoId(value = FieldType.OBJECT_ID)
	private String id;
	private List<Input> input;
	private Date date;
	private Customer customer;
	
	public OutputInfo() {
		super();
	}
	@PersistenceConstructor
	public OutputInfo(String id, List<Input> input, Date date, Customer customer) {
		super();
		this.id = id;
		this.input = input;
		this.date = date;
		this.customer = customer;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<Input> getInput() {
		return input;
	}
	public void setInput(List<Input> input) {
		this.input = input;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}	
