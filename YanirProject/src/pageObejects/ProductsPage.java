package pageObejects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ProductsPage extends MenuPage {
	@FindBy(css=".inventory_item_name")
	private List<WebElement> productList; 
	@FindBy(css=".peek")
	private WebElement productImg; 	
	@FindBy(css=".product_sort_container")
	private WebElement sortProductList; 		
	@FindBy(css="[value='az']")
	private WebElement nameAToZ; 
	@FindBy(css="[value='za']")
	private WebElement nameZToA;
	@FindBy(css="[value='lohi']")
	private WebElement priceLowToHigh;
	@FindBy(css=".product_sort_container>[value='hilo']")
	private WebElement priceHighToLow;
	@FindBy(css=".btn_primary.btn_inventory")
	private WebElement addToCart; 	
	@FindBy(css=".header_secondary_container>.title")
	private WebElement titleLabel; 	

	public ProductsPage(WebDriver driver) {
		super(driver);
}

	public void sortPriceHighToLow() {
		//test rearrange Item price (high to low)	
		Select sort = new Select(sortProductList);
		sort.selectByIndex(3);
}

	public void sortPriceLowToHigh() {
		//test rearrange Item price (low to high)
		Select sort = new Select(sortProductList);
		sort.selectByIndex(2);
}

	public void sortNameZToA() {
		//test rearrange Item name (Z to A)
		Select sort = new Select(sortProductList);
		sort.selectByIndex(1);
}
	public void sortNameAToZ() {
		//test rearrange Item name (A to Z)
		Select sort = new Select(sortProductList);
		sort.selectByIndex(0);

}
	public void addToCart( ) {
		click(addToCart);
}



	public void chooseProduct(String product) {
	
		for (WebElement el : productList) {
			if (getText(el).equalsIgnoreCase(product)) {
			click(el);
			break;
		}
	}
}

	public void click(WebElement el) {
	// TODO Auto-generated method stub
	
}

	public void chooseProduct(int position) {
	
		productList.get(position).click();
}
	

	public void addProduct(String product) {
		//add a product
}


	public boolean isItProductsPage() {
		if (getText(titleLabel).equalsIgnoreCase("Products")) {
			return true;
	} 	else
			return false;
}

}
	
	

