package cdp.lviv.singrabber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage extends AbstractPage {
//    @FindBy(id = "keywords-search")
//    private WebElement searchField;
//    
//    @FindBy(name = "search")
//    private WebElement searchButton;
    
    @FindBy(className = "paginator-next")
    private WebElement nextLink;
    
//    @FindBy(xpath = "//li[1]/div/h2/a")
//    private WebElement person1;

	public SearchResultPage(WebDriver driver) {
		super(driver);
	}
	protected WebElement getPersonLink(int numberOnThePage){
		if((numberOnThePage > 10) || (numberOnThePage < 1)){
			throw new RuntimeException("Trying to call a person by index: " + 
					numberOnThePage + " (shoudl be [1..10]).");
		}

		return this.driver.findElement(By.xpath("//li[" + numberOnThePage + "]/div/h2/a"));

	}
//	public String getAllNamesOnPage(){
//		String result = "";
//		for (int i=1; i<11; i++){
//			result += this.getPersonLink(i).getText() + "\n";
//		}
//		return result;
//	}
	public AbstractPage getPerson(int numberOnThePage) throws InterruptedException{
		this.getPersonLink(numberOnThePage).click();
		Thread.sleep(1000);
		
		return this;
	}
	public AbstractPage getNextSearchResult() throws InterruptedException{
		this.nextLink.click();
		Thread.sleep(3000);
		
		return this;
	}
}
