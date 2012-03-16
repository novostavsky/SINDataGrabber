package cdp.lviv.singrabber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage extends AbstractPage {

//    @FindBy(id = "upsell")
//    private WebElement upSell;
    
    @FindBy(className = "paginator-next")
    private WebElement nextLink;
    
    @FindBy(linkText = "Show more...")
    private WebElement showMore;
    
    @FindBy(id = "6549-CC-fps")
    private WebElement company;

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
	public String getAllNamesOnPage(){
		String result = "";
		int limit = this.getNumOfPersonsOnPage() + 1;
		for (int i=1; i<limit; i++){
			result += this.getPersonLink(i).getText() + "\n";
		}
		return result;
	}
	public int getNumOfPersonsOnPage(){
		return this.driver.findElements(By.className("result-data")).size();
	}
	public AbstractPage getPerson(int numberOnThePage) throws InterruptedException{
		this.getPersonLink(numberOnThePage).click();
		Thread.sleep(2000);
		
		ProfilePage profilePage = PageFactory.initElements(driver, ProfilePage.class);
		
		return profilePage;
	}
	public AbstractPage getNextSearchResult() throws InterruptedException{
		this.nextLink.click();
		Thread.sleep(3000);
		
		SearchResultPage searchResult = PageFactory.initElements(driver, SearchResultPage.class);
		
		return searchResult;
	}
	public AbstractPage showMore() throws InterruptedException{
		this.showMore.click();
		Thread.sleep(2000);
		return this;
	}
	public AbstractPage selectSymphony()throws InterruptedException{
		this.company.click();
		Thread.sleep(2000);
		return this;
	}
	public boolean isTheEnd(){
		if(this.driver.findElements(By.id("upsell")).size() !=0){
			return true;
		}else{
			return false;
		}
	}
}
