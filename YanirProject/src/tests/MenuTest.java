package tests;

import java.util.Set;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObejects.LoginPage;
import pageObejects.MenuPage;
import pageObejects.ProductsPage;

public class MenuTest extends BaseTest {

	@Test
	public void tc06_integrations() {
	//Test about integration with menuPage > click about button
		MenuPage mp = new MenuPage(driver);	
		mp.about();
	//Back to products page	
		driver.navigate().back();
		ProductsPage pp = new ProductsPage(driver);
		Assert.assertTrue(pp.isItProductsPage());
	}
	@Test
	public void tc07_integrations() {
	// Test about close menu,scroll-down ,integration with click twitter button	
		MenuPage mp = new MenuPage(driver);
		sleep(1000);
		mp.closeBarMenu();
		String main = driver.getWindowHandle();
	//Move to a new window
		mp.twitter();
		Set <String>list = driver.getWindowHandles();
		for (String win : list) {
			driver.switchTo().window(win);
		}
	//Close the current window and move to main window(product page)
			driver.close();
			driver.switchTo().window(main);
			ProductsPage pp = new ProductsPage(driver);
			Assert.assertTrue(pp.isItProductsPage());
		 
	}
	@Test
	public void tc08_integrations() {
	//Test about integration with click faceBook button	
			sleep(1000);
			MenuPage mp = new MenuPage(driver);
			String main = driver.getWindowHandle();
	//Move to a new window
			mp.facebook();
			sleep(2000);
			Set <String>list = driver.getWindowHandles();
			for (String win : list) {
				driver.switchTo().window(win);
		}
	//Close the current window and move to main window(product page)		
				driver.close();
				driver.switchTo().window(main);
				ProductsPage pp = new ProductsPage(driver);
				Assert.assertTrue(pp.isItProductsPage());
			 
	}
	@Test	
	public void tc09_integrations() {	
	//Test about integration with click Linkedin button 
		sleep(1000);
		MenuPage mp = new MenuPage(driver);
		String main = driver.getWindowHandle();
	//Move to a new window
		mp.linkedin();
		Set <String>list = driver.getWindowHandles();
		for (String win : list) {
			driver.switchTo().window(win);
		}
	//Close the current window and move to main window(product page)
			driver.close();	
			driver.switchTo().window(main);
			ProductsPage pp = new ProductsPage(driver);
			Assert.assertTrue(pp.isItProductsPage());
		 
	}
	@Test
	public void tc10_integrations() {	 
	//Test integration with menuPage > click logout button
		MenuPage mp = new MenuPage(driver);		
		mp.logout();
		LoginPage lp = new LoginPage(driver);
		Assert.assertTrue(lp.isItLoginPage());	
	}
	
	@Override
	//Close the current website
	public void tearDown() {
		driver.quit();
	}
}
