package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pageObejects.LoginPage;
import pageObejects.ProductsPage;

public class BaseTest {
WebDriver driver;
	
@BeforeClass
public void setUp() {
	//Open the website that we want to test :)
	System.setProperty("webdriver.chrome.driver", "C:\\automation\\drivers\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	sleep(1000);
	driver.get("https://www.saucedemo.com/");
}
	
@BeforeClass
public void setupLogin() {
//Fill text right user and password
	sleep(4000);
	LoginPage lp = new LoginPage(driver);
	lp.login("standard_user", "secret_sauce");
	@SuppressWarnings("unused")
	ProductsPage pp = new ProductsPage(driver);
}
	
	
public void sleep(long millis) {
	//Method for delaying processes 
	try {
	Thread.sleep(millis);
	} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
		
}
@AfterClass
//Close the current website
public void tearDown() {
	driver.quit();
}
}
