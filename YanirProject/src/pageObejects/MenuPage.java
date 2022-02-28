package pageObejects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuPage extends BasePage {
	@FindBy(css = ".shopping_cart_link")
	private WebElement cartBtn;
	@FindBy(css = "#react-burger-menu-btn")
	private WebElement mainMenuBtn;
	@FindBy(css = "#logout_sidebar_link")
	private WebElement logoutBtn;
	@FindBy(css = "#about_sidebar_link")
	private WebElement AboutBtn;
	@FindBy(css = ".social_twitter")
	private WebElement twitterBtn;
	@FindBy(css = ".social_facebook")
	private WebElement facebookBtn;
	@FindBy(css = ".social_linkedin")
	private WebElement linkedinBtn;
	@FindBy(css = "#react-burger-cross-btn")
	private WebElement closeBarMenuBtn;
		
	public MenuPage(WebDriver driver) {
		super(driver);
	}

	public void openCart() {
		click(cartBtn);
	}

	public void logout() {
		click(mainMenuBtn);
		sleep(2000);
		click(logoutBtn);
		
	}
		
	public void about( ) {
		click(mainMenuBtn);
		sleep(2000);
		click(AboutBtn);
			
	}
		
	public void twitter() {
		scrollDown(1000);
		click(twitterBtn);
		sleep(2000);		
	}
	
	public void facebook() {
		click(facebookBtn);
		sleep(2000);		
	}
	
	public void linkedin() {
		click(linkedinBtn);
		sleep(2000);
			
	}
	public void closeBarMenu( ) {
		click(closeBarMenuBtn);
		
	}
		
}


