package pageObejects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ItemPage extends MenuPage{	
	@FindBy(css=".btn_primary.btn_inventory")
	private WebElement addToCartBtn;
	@FindBy(css="#back-to-products")
	private WebElement backBtn;
	@FindBy(css="#shopping_cart_container")
	private WebElement ShoppingCart;
	@FindBy(css=".btn.btn_secondary.btn_small.cart_button")
	private WebElement removeBtn;
	@FindBy(css="#checkout")
	private WebElement checkoutBtn; 
	@FindBy(css="#cancel")
	private WebElement cancelBtn; 
	@FindBy(css="#continue-shopping")
	private WebElement continueShoppingBtn; 
	@FindBy(css="#first-name")
	private WebElement InformationFirstName; 
	@FindBy(css="#last-name")
	private WebElement InformationLastName; 
	@FindBy(css="#postal-code")
	private WebElement InformationZipCode; 
	@FindBy(css="#continue")
	private WebElement continueBtn; 
	@FindBy(css=".header_secondary_container>.title")
	private WebElement title; 
	@FindBy(css=".btn.btn_action.btn_medium.cart_button")
	private WebElement finishBtn; 
	@FindBy(css=".summary_info>.summary_tax_label")
	private WebElement tax;
	@FindBy(css="#checkout_complete_container>h2")
	private WebElement CompletePurchase;
	
	public ItemPage(WebDriver driver) {
		super(driver);
	}

	public void addToCart() {
		click(addToCartBtn);
	}
	
	public void back() {
		click(backBtn);
	}
	public void ShoppingCart() {
		click(ShoppingCart);
	}
	public void RemoveBtn() {
		click(removeBtn);
	}
	public void CheckoutBtn() {
		click(checkoutBtn);
	}
	
	public void CancelBtn( ) {
		click(cancelBtn);
	}
	
	public void ContinueShoppingBtn() {
		click(continueShoppingBtn);
	}
	
	public void FillInformation(String firstName , String lastName,CharSequence string ) {
		fillText(InformationFirstName, firstName);
		fillText(InformationLastName, lastName);
		FillInformation(InformationZipCode, string);
	}
	public void ContinueBtn() {
		sleep(2000);
		click(continueBtn);
		
	}
	public void FinishBtn() {
		sleep(2000);
		click(finishBtn);
		sleep(2000);
	}
	public boolean isItYourCart() {
		if (getText(title).equalsIgnoreCase("Your Cart")) {
			return true;
		} else
			return false;
	}
	public boolean isItCheckout() {
		if (getText(title).equalsIgnoreCase("Checkout: Overview")) {
			return true;
		} else
			return false;
	}

	public boolean isItCompleteOrder() {
		if (getText(CompletePurchase).equalsIgnoreCase("THANK YOU FOR YOUR ORDER")) {
			return true;
		} else
			return false;
	}
	
	}

