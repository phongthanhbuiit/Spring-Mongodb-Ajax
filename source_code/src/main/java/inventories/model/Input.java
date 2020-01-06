package inventories.model;

public class Input {
	
	private Product product;
	private int qty;
	private double count;
	private double outputPrice;
	
	public Input() {
		super();
	
	}

	public Input(Product product, int qty, double count, double outputPrice) {
		super();
		this.product = product;
		this.qty = qty;
		this.count = count;
		this.setOutputPrice(outputPrice);
	}


	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public double getCount() {
		return count;
	}
	public void setCount(double count) {
		this.count = count;
	}

	public double getOutputPrice() {
		return outputPrice;
	}

	public void setOutputPrice(double outputPrice) {
		this.outputPrice = outputPrice;
	}
	
	
}
