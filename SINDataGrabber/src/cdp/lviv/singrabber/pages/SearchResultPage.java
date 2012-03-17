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
    
    @FindBy(id="6549-CC-fps")
    private WebElement softserve;

    @FindBy(id="4972-CC-fps")
    private WebElement epam;
    @FindBy(id="774932-CC-fps")
    private WebElement edvantis;
    @FindBy(id="12127-CC-fps")
    private WebElement lohika;
    @FindBy(id="13412-CC-fps")
    private WebElement eleks;
    @FindBy(id="164008-CC-fps")
    private WebElement global;
    @FindBy(id="1063-CC-fps")
    private WebElement cisco;
    @FindBy(id="74037-CC-fps")
    private WebElement devcom;
    @FindBy(id="2089662-CC-fps")
    private WebElement serve;
    @FindBy(id="1035-CC-fps")
    private WebElement microsoft;
    @FindBy(id="2691-CC-fps")
    private WebElement manulife;
    @FindBy(id="137190-CC-fps")
    private WebElement conscensia;
    @FindBy(id="119247-CC-fps")
    private WebElement malkosUA;
    @FindBy(id="31921-CC-fps")
    private WebElement nix;
    @FindBy(id="252273-CC-fps")
    private WebElement skelia;
    @FindBy(id="1083914-CC-fps")
    private WebElement symphony;



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
		Thread.sleep(3000);
		
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
		Thread.sleep(3000);
		return this;
	}
	public AbstractPage selectSoftserve()throws InterruptedException{
		this.softserve.click();
		Thread.sleep(3000);
		return this;
	}
	public AbstractPage selectEpam()throws InterruptedException{
		this.epam.click();
		Thread.sleep(3000);
		return this;
	}
	public AbstractPage selectEdvantis()throws InterruptedException{
		this.edvantis.click();
		Thread.sleep(3000);
		return this;
	}
	public AbstractPage selectLohika()throws InterruptedException{
		this.lohika.click();
		Thread.sleep(3000);
		return this;
	}
	public AbstractPage selectEleks()throws InterruptedException{
		this.eleks.click();
		Thread.sleep(3000);
		return this;
	}
	public AbstractPage selectGlobal()throws InterruptedException{
		this.global.click();
		Thread.sleep(3000);
		return this;
	}
	public AbstractPage selectCisco()throws InterruptedException{
		this.cisco.click();
		Thread.sleep(3000);
		return this;
	}
	public AbstractPage selectDevcom()throws InterruptedException{
		this.devcom.click();
		Thread.sleep(3000);
		return this;
	}
	public AbstractPage selectServe()throws InterruptedException{
		this.serve.click();
		Thread.sleep(3000);
		return this;
	}
	public AbstractPage selectMicrosoft()throws InterruptedException{
		this.microsoft.click();
		Thread.sleep(3000);
		return this;
	}
	public AbstractPage selectConcensia()throws InterruptedException{
		this.conscensia.click();
		Thread.sleep(3000);
		return this;
	}
	public AbstractPage selectMalkos()throws InterruptedException{
		this.malkosUA.click();
		Thread.sleep(3000);
		return this;
	}
	public AbstractPage selectNix()throws InterruptedException{
		this.nix.click();
		Thread.sleep(3000);
		return this;
	}
	public AbstractPage selectSkelia()throws InterruptedException{
		this.skelia.click();
		Thread.sleep(3000);
		return this;
	}
	public AbstractPage selectSymphony()throws InterruptedException{
		this.symphony.click();
		Thread.sleep(3000);
		return this;
	}
	public AbstractPage selectManulife()throws InterruptedException{
		this.manulife.click();
		Thread.sleep(3000);
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
