package cdp.lviv.singrabber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cdp.lviv.singrabber.dto.Tester;

public class ProfilePage extends AbstractPage {
	
  @FindBy(className = "given-name")
  private WebElement givenName;
  
  @FindBy(className = "family-name")
  private WebElement familyName;
  
  @FindBy(className = "current")
  private WebElement currentTitle;
  
  @FindBy(className = "past")
  private WebElement pastTitle;
 
  @FindBy(className = "period")
  private WebElement period;
  
  @FindBy(className = "locality")
  private WebElement locality;

  @FindBy(className = "industry")
  private WebElement industry;
  
  @FindBy(xpath = "//div/div/dl/dd[3]/ul")
  private WebElement education;
  
  @FindBy(className = "abook-email")
  private WebElement email;
  
  private String id;
 
	
	public ProfilePage(WebDriver driver) {
		super(driver);
		//get linkedin id from url
		String url = this.driver.getCurrentUrl();
		this.id = url.split("id=")[1].split("&")[0];
		
	}
	public Tester initTester(Tester tester){
		tester.setId(Long.parseLong(id));
		
		if(this.hasClassName("given-name")){
			tester.setGivenName(this.givenName.getText());
		}
		if(this.hasClassName("family-name")){
			tester.setFamilyName(this.familyName.getText());
		}
		if(this.hasClassName("current")){
			tester.setCurrentTitle(this.currentTitle.getText());
		}
		if(this.hasClassName("past")){
			tester.setPastTitle(this.pastTitle.getText());
		}
		if(this.hasClassName("period")){
			tester.setPeriod(this.period.getText());
		}
		if(this.hasClassName("locality")){
			tester.setLocality(this.locality.getText());
		}
		if(this.hasClassName("industry")){
			tester.setIndustry(this.industry.getText());
		}
		if(this.hasXPath("//div/div/dl/dd[3]/ul")){
			tester.setEducation(this.education.getText());
		}
		if(this.hasClassName("abook-email")){
			tester.setEmail(this.email.getText());
		}
		
		return tester;
	}
    public AbstractPage goBack() throws InterruptedException{
    	this.driver.navigate().back();
    	Thread.sleep(3000);
    	
		SearchResultPage searchResult = PageFactory.initElements(driver, SearchResultPage.class);
    	
    	return searchResult;
    }
    
    private boolean hasClassName(String className){
    	if(this.driver.findElements(By.className(className)).isEmpty()){
    		return true;
    	}else{
    		return false;
    	}
    }
    private boolean hasXPath(String xPath){
    	if(this.driver.findElements(By.xpath(xPath)).isEmpty()){
    		return true;
    	}else{
    		return false;
    	}
    }

}
