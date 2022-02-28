package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObejects.LoginPage;
import pageObejects.ProductsPage;

public class LoginTest extends BaseTest {
	
@Override
public void setupLogin() {
	//Skip the login method for testing
}

	
@Test
public void tc01_login() {
	//Test login with empty password
	LoginPage lp = new LoginPage(driver);
	lp.login("standard_user", "");
	lp.click();
	String expected = "Epic sadface: Password is required";
	sleep(3000);
	String actual = lp.getErrorMsg();
	Assert.assertEquals(actual, expected);
		
		
}
@Test
public void tc02_login() {
	//Test login with empty user and correct password
	LoginPage lp = new LoginPage(driver);
	lp.login("", "");
	lp.click();
	sleep(3000);
	String expected = "Epic sadface: Password is required";
	String actual = lp.getErrorMsg();
	Assert.assertEquals(actual, expected);
}
@Test
public void tc03_login() {
	//Test login with correct user and wrong password
	LoginPage lp = new LoginPage(driver);
	lp.login("standard_user", "1234");
	lp.click();
	String expected = "Epic sadface: Username and password do not match any user in this service";
	sleep(3000);
	String actual = lp.getErrorMsg();
	Assert.assertEquals(actual,expected);
			
}
@Test
public void tc04_login() {
	//Test login with wrong user and correct password
	LoginPage lp = new LoginPage(driver);
	lp.login("AAA", "secret_sauce");
	sleep(3000);
	String expected = "Epic sadface: Username and password do not match any user in this service";
	String actual = lp.getErrorMsg();
	Assert.assertEquals(actual,expected);
		
}
@Test	
public void tc05_login() {
	//Test login with correct user & password
	LoginPage lp = new LoginPage(driver);
	sleep(3000);
	lp.login("standard_user", "secret_sauce");
	sleep(4000);
	ProductsPage pp = new ProductsPage(driver);
	Assert.assertTrue(pp.isItProductsPage());
		
}
}
