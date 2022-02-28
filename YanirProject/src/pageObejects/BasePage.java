package pageObejects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
public WebDriver driver;
public String mainWindow;
 
public void fillText(WebElement el, String text) {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].setAttribute('style', 'background: green; border: 2px solid green;');", el);

	el.clear();
	el.sendKeys(text);
	
}
	
public void click(WebElement el) {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].setAttribute('style', 'background: green; border: 2px solid green;');", el);
	el.click();
}
 
public String getText(WebElement el) {
			return el.getText();
}
 
public void sleep(long millis) {
	try {
	Thread.sleep(millis);
	} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
 
public BasePage(WebDriver driver) {
	super();
	this.driver = driver;
	PageFactory.initElements(driver, this);
}

public void setupLogin() {
	
}

public void scrollDown(long pixel) {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	// This will scroll down the page by 1000 pixel vertical
	js.executeScript("window.scrollBy(0," + pixel + ")");
	sleep(500);
}	

public void backToMainWindow() {
	driver.switchTo().window(mainWindow);
}

public void FillInformation(WebElement el, CharSequence string) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('style', 'background: green; border: 2px solid green;');", el);

			el.clear();
			el.sendKeys(string);
	
	}
 
 }







	
	

 
 


	
	

