package pageObejects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	@FindBy(css="#user-name")
	private WebElement userNameField;
	@FindBy(css="#password")
	private WebElement passwordField;
	@FindBy(css="#login-button")
	private WebElement loginBtn;
	@FindBy(css=".error-message-container>h3")
	private WebElement errorMsgLabel;
	@FindBy(css=".login_credentials>h4")
	private WebElement IsItLoginPage;
 
public LoginPage(WebDriver driver) {
	super(driver);
	this.driver = driver;
}


public void login(String user,String passsword) {
	fillText(userNameField, user);
	fillText(passwordField, passsword);
	click(loginBtn);
	
}

public String getErrorMsg() {
	return getText(errorMsgLabel);
}

public void click() {
	click(loginBtn);
}
 
public boolean isItLoginPage() {
	if (getText( IsItLoginPage).equalsIgnoreCase("Accepted usernames are:")) {
	return true;
	} else
	return false;
}
	
}





	


	
	


