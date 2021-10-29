package domain;

import java.util.HashMap;

public class ProductsInformation {
	
	private HashMap<String, Product> products;
	
	public ProductsInformation() {
		products = new HashMap<>();
	}
	
	public void storeProduct(Product product) {
		products.put(product.getCode(), product);
	}
	
	public Product getProductByCode(String productCode) {
		return products.get(productCode);
	}

	public HashMap<String, Product> getProducts() {
		return products;
	}

	public void setProducts(HashMap<String, Product> products) {
		this.products = products;
	}

}
