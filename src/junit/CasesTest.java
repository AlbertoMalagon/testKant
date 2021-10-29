package junit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import domain.Cart;
import domain.Product;
import domain.ProductsInformation;
import domain.Discount;

public class CasesTest {
	
	private Cart cart = new Cart();
	private ProductsInformation prodInformation;
	
	private static final String CODE_GREEN_TEA = "GR1" ; 
	private static final String CODE_STRAWBERRIES = "SR1" ; 
	private static final String CODE_COFFEE = "CF1" ; 

	@Before
	public void setUp() {
		prodInformation = new ProductsInformation();
		
		Discount discountGreenTea = new Discount();
		discountGreenTea.setProdCode(CODE_GREEN_TEA);
		discountGreenTea.setQuantityDiscount(2);
		discountGreenTea.setTypeDiscount("OneForFree");
		
		Product greenTea = new Product();
		greenTea.setCode(CODE_GREEN_TEA);
		greenTea.setName("Green tea");
		greenTea.setPrice(3.11);
		greenTea.setProdTariff(discountGreenTea);

		Discount discountStrawberrie = new Discount();
		discountStrawberrie.setProdCode(CODE_STRAWBERRIES);
		discountStrawberrie.setTypeDiscount("ByAmount");
		discountStrawberrie.setQuantityDiscount(3);
		discountStrawberrie.setDiscountValue(0.50);
		
		Product strawberrie = new Product();
		strawberrie.setCode(CODE_STRAWBERRIES);
		strawberrie.setName("Strawberries");
		strawberrie.setPrice(5.00);
		strawberrie.setProdTariff(discountStrawberrie);

		Discount discountCoffee = new Discount();
		discountCoffee.setProdCode(CODE_COFFEE);
		discountCoffee.setTypeDiscount("ByPercentage");
		discountCoffee.setQuantityDiscount(3);
		discountCoffee.setDiscountValue(66D);
		
		Product coffee = new Product();
		coffee.setCode(CODE_COFFEE);
		coffee.setName("Coffee");
		coffee.setPrice(11.23);
		coffee.setProdTariff(discountCoffee);
		
		prodInformation.storeProduct(greenTea);
		prodInformation.storeProduct(strawberrie);
		prodInformation.storeProduct(coffee);
	}
	
	@Test
	public void testFirstCart() {
		cart.addProductToCart(CODE_GREEN_TEA);
		cart.addProductToCart(CODE_STRAWBERRIES);
		cart.addProductToCart(CODE_GREEN_TEA);
		cart.addProductToCart(CODE_GREEN_TEA);
		cart.addProductToCart(CODE_COFFEE);
		Assert.assertEquals(cart.getTotal(prodInformation), "£22.45");
	}
	
	@Test
	public void testSecondCart() {
		cart.addProductToCart(CODE_GREEN_TEA);
		cart.addProductToCart(CODE_GREEN_TEA);
		Assert.assertEquals(cart.getTotal(prodInformation), "£3.11");
	}
	
	@Test
	public void testThirdCart() {
		cart.addProductToCart(CODE_STRAWBERRIES);
		cart.addProductToCart(CODE_STRAWBERRIES);
		cart.addProductToCart(CODE_GREEN_TEA);
		cart.addProductToCart(CODE_STRAWBERRIES);
		Assert.assertEquals(cart.getTotal(prodInformation), "£16.61");
	}
	
	@Test
	public void testForthCart() {
		cart.addProductToCart(CODE_GREEN_TEA);
		cart.addProductToCart(CODE_COFFEE);
		cart.addProductToCart(CODE_STRAWBERRIES);
		cart.addProductToCart(CODE_COFFEE);
		cart.addProductToCart(CODE_COFFEE);
		Assert.assertEquals(cart.getTotal(prodInformation), "£30.57");
	}
}
