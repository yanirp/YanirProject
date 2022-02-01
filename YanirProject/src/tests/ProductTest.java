package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObejects.ItemPage;
import pageObejects.ProductsPage;

public class ProductTest extends BaseTest{
	
	@Test
	public void tc11_rearrange_Item() {
		//Test about sort price (high to low)
		ProductsPage pp = new ProductsPage(driver);	 
		pp.sortPriceHighToLow();;
		sleep(3000);
	}	
	@Test	
	public void tc12_rearrange_Item() {
		//Test about sort price (low to high)
		ProductsPage pp = new ProductsPage(driver);	 
		pp.sortPriceLowToHigh();
		sleep(3000);	
	}
	@Test
	public void tc13_rearrange_Item() {
		//Test about sort name (Z to A)
		ProductsPage pp = new ProductsPage(driver);	 
		pp.sortNameZToA();;
		sleep(3000);
	}
	@Test
	public void tc14_rearrange_Item() {
		//Test sort name (A to Z)
		ProductsPage pp = new ProductsPage(driver);	 
		pp.sortNameAToZ();;
		sleep(3000);
	}
	@Test
	public void tc15_addToCart_Cancel() {
		//Test about sort price (low to high),choose a product("Sauce Labs Onesie"),add to cart,  
		//decide to cancel the purchase and navigate back to products page
		ProductsPage pp = new ProductsPage(driver);	 
		pp.sortPriceLowToHigh();
		sleep(3000);	
		pp.chooseProduct("Sauce Labs Onesie");
		ItemPage ip = new ItemPage(driver);
		ip.addToCart();
		sleep(2000);
		//Move to a shopping cart
		ip.ShoppingCart();
		sleep(2000);
		Assert.assertTrue(ip.isItYourCart());
		//Remove the product from the list and return to product page
		ip.RemoveBtn();
		driver.navigate().back();

	}
	@Test
	public void tc16_addToCart_Cancel() {
		//Test about choose a product("Sauce Labs Bolt T-Shirt"),add to cart,go to checkout,
		//decide to cancel the purchase, remove the product from cart list ,back to product page
		ProductsPage pp = new ProductsPage(driver);
		pp.chooseProduct("Sauce Labs Bolt T-Shirt");
		sleep(2000);
		ItemPage ip = new ItemPage(driver);
		ip.addToCart();
		sleep(2000);
		//Move to a shopping cart
		ip.ShoppingCart();
		sleep(2000);
		Assert.assertTrue(ip.isItYourCart());
		ip.CheckoutBtn();
		sleep(2000);
		//Decide to cancel the purchase
		ip.CancelBtn();
		//Remove the product from the list and return to product page
		ip.RemoveBtn();	
		sleep(2000);
		ip.ContinueShoppingBtn();
	}
	@Test
	public void tc17_checkoutInformation() {
		//Test about choose a product("Sauce Labs Backpack"),add to cart,go to checkout,
		//fill information(first name, last name, zipcode)for the delivery, continue to order view,
		//decide to cancel the purchase, remove the product from cart list ,back to product page
		ProductsPage pp = new ProductsPage(driver);
		sleep(2000);
		pp.chooseProduct("Sauce Labs Backpack");
		sleep(2000);
		ItemPage ip = new ItemPage(driver);
		ip.addToCart();
		sleep(2000);
		//Move to a shopping cart
		ip.ShoppingCart();
		sleep(2000);
		Assert.assertTrue(ip.isItYourCart());
		ip.CheckoutBtn();
		//Fill my information for a delivery
		ip.FillInformation("Yanir","Patel","12345");
		ip.ContinueBtn();
		//Decide to cancel the purchase
		ip.CancelBtn();
		sleep(2000);
		ip.ShoppingCart();
		sleep(2000);
		//Remove the product from the list and return to product page
		ip.RemoveBtn();
		ip.ContinueShoppingBtn();
	}
	@Test
	public void tc18_completeProductPurchase() {
		//Test about choose a product("Sauce Labs Backpack"),add to cart,go to checkout,
		//fill information(first name, last name, zipcode)for the delivery, continue to order view,
		//completion and full purchase
		ProductsPage pp = new ProductsPage(driver);
		sleep(2000);
		pp.chooseProduct("Sauce Labs Backpack");
		sleep(2000);
		ItemPage ip = new ItemPage(driver);
		ip.addToCart();
		sleep(2000);
		//Move to a shopping cart
		ip.ShoppingCart();
		sleep(2000);
		Assert.assertTrue(ip.isItYourCart());
		ip.CheckoutBtn();
		//Fill my information for a delivery
		ip.FillInformation("Yanir","Patel","12345");
		ip.ContinueBtn();
		//Checkout the order and complete the purchase
		ip.scrollDown(500);
		Assert.assertTrue(ip.isItCheckout());
		ip.FinishBtn();
		//Checkout is complete! - Thank you for your order , back to product page
		Assert.assertTrue(ip.isItCompleteOrder());
		sleep(3000);
		ip.back();
	}

	public void tearDown() {
		//Close the current website
		driver.quit();
		}
}
