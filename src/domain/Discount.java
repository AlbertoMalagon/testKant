package domain;

public class Discount {
	
	private String prodCode;
	private Integer quantityDiscount;
	private Double discountValue;
	private String typeDiscount;
	
	public Discount() {
		
	}
	
	public String getProdCode() {
		return prodCode;
	}
	public void setProdCode(String prodCode) {
		this.prodCode = prodCode;
	}
	public Integer getQuantityDiscount() {
		return quantityDiscount;
	}
	public void setQuantityDiscount(Integer quantityDiscount) {
		this.quantityDiscount = quantityDiscount;
	}
	public Double getDiscountValue() {
		return discountValue;
	}
	public void setDiscountValue(Double discountValue) {
		this.discountValue = discountValue;
	}
	public String getTypeDiscount() {
		return typeDiscount;
	}
	public void setTypeDiscount(String typeDiscount) {
		this.typeDiscount = typeDiscount;
	}
	
	
}
