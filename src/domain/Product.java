package domain;

public class Product {
	
	private long prodId;
	private String code;
	private String name;
	private double price;
	private Discount prodTariff;
	
	public Product () {
		code = "";
		name = "";
		prodTariff = new Discount();
	}
	
	public long getProdId() {
		return prodId;
	}
	public void setProdId(long prodId) {
		this.prodId = prodId;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Discount getProdTariff() {
		return prodTariff;
	}
	public void setProdTariff(Discount prodTariff) {
		this.prodTariff = prodTariff;
	}
}
