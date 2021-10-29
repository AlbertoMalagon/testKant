package domain;

import java.util.HashMap;
import java.util.Map;

public class Cart {

	private HashMap<String, Integer> products = new HashMap<>();
	
	private static final String ONE_FOR_FREE = "OneForFree" ; 
	private static final String BY_AMOUNT = "ByAmount" ; 
	private static final String BY_PERCENTAGE = "ByPercentage" ;

	public void addProductToCart(String productCode) {
		if(products.get(productCode) == null) {
			products.put(productCode, 1);
		}else {
			products.put(productCode, products.get(productCode)+1);
		}
	}
	
	public String getTotal(ProductsInformation productInformation) {
		double totalPrice = 0.0;
		for(Map.Entry<String, Integer> entry : products.entrySet()){
			Product productInfo = productInformation.getProductByCode(entry.getKey());
			if(productInfo != null) {
				totalPrice = totalPrice + getTotalPriceByProduct(entry.getValue(), productInfo);
			}
		};
		return "£"+totalPrice;
	}
	
	private double getTotalPriceByProduct(int quantity, Product productInfo) {
		Discount discountProduct = productInfo.getProdTariff();
		productInfo.getProdTariff().getQuantityDiscount();
		if(discountProduct.getQuantityDiscount() != null && 
				discountProduct.getQuantityDiscount() >0 &&
				quantity >= discountProduct.getQuantityDiscount()) {
			if(ONE_FOR_FREE.equalsIgnoreCase(discountProduct.getTypeDiscount())) {
				int substract = quantity / discountProduct.getQuantityDiscount();
				return (quantity - substract)* productInfo.getPrice();
			}else if(BY_AMOUNT.equalsIgnoreCase(discountProduct.getTypeDiscount())) {
				return quantity * productInfo.getPrice() - quantity * discountProduct.getDiscountValue();
			} else if(BY_PERCENTAGE.equalsIgnoreCase(discountProduct.getTypeDiscount())) {
				return Math.round(quantity * productInfo.getPrice() *2/3 * 100) /100D;
			}
		}
		return quantity * productInfo.getPrice();
		
	}
	
	public HashMap<String, Integer> getProducts() {
		return products;
	}

	public void setProducts(HashMap<String, Integer> products) {
		this.products = products;
	}
}
