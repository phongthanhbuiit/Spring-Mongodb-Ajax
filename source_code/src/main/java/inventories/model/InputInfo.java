package inventories.model;


import java.util.Date;

import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "inputinfo")
public class InputInfo {
	
	private static final long serialVersionUID = 1L;
	@MongoId(value = FieldType.OBJECT_ID)
	private String id;
	private Product product;
	private double count;
	private int qty;
	private double inputPrice;
	private double outputPrice;
	private Supplier supplier;
	private Date date;
	
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	public double getCount() {
		return count;
	}


	public void setCount(double count) {
		this.count = count;
	}


	public int getQty() {
		return qty;
	}


	public void setQty(int qty) {
		this.qty = qty;
	}


	public double getInputPrice() {
		return inputPrice;
	}


	public void setInputPrice(double inputPrice) {
		this.inputPrice = inputPrice;
	}


	public double getOutputPrice() {
		return outputPrice;
	}


	public void setOutputPrice(double outputPrice) {
		this.outputPrice = outputPrice;
	}


	public Supplier getSupplier() {
		return supplier;
	}


	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@PersistenceConstructor
	public InputInfo(String id, Product product, double count, int qty, double inputPrice, double outputPrice,
			Supplier supplier, Date date) {
		super();
		this.id = id;
		this.product = product;
		this.count = count;
		this.qty = qty;
		this.inputPrice = inputPrice;
		this.outputPrice = outputPrice;
		this.supplier = supplier;
		this.date = date;
	}


	public InputInfo() {
		super();
	}


	@Override
	public String toString() {
		return "InputInfo [id=" + id + ", product=" + product + ", count=" + count + ", qty=" + qty + ", inputPrice="
				+ inputPrice + ", outputPrice=" + outputPrice + ", supplier=" + supplier + "]";
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}



	

}
