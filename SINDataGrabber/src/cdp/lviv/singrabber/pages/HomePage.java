package cdp.lviv.singrabber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends AbstractPage {
    @FindBy(id = "main-search-box")
    private WebElement searchField;
    
    @FindBy(name = "search")
    private WebElement searchButton;
    
	public HomePage(WebDriver driver) {
		super(driver);
	}
	public AbstractPage search(String searchPattern) throws InterruptedException{
		this.searchField.sendKeys(searchPattern);
		this.searchButton.click();
		Thread.sleep(2000);
		
		SearchResultPage searchResult = PageFactory.initElements(driver, SearchResultPage.class);
		
		return searchResult;
	}

}
