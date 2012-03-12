package cdp.lviv.singrabber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import cdp.lviv.singrabber.dao.Tester;

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
  
//  @FindBy(className = "abook-email")
//  private WebElement email;
  
  private String id;
 
	
	public ProfilePage(WebDriver driver) {
		super(driver);
		
		//get linkedin id from url
		this.id = this.driver.getCurrentUrl().split("id=")[1].split("&")[0];
		
	}
	public Tester initTester(Tester tester){
		tester.setId(Long.parseLong(id));
		tester.setGivenName(this.givenName.getText());
		tester.setFamilyName(this.familyName.getText());
		tester.setCurrentTitle(this.currentTitle.getText());
		tester.setPastTitle(this.pastTitle.getText());
		tester.setPeriod(this.period.getText());
		tester.setLocality(this.locality.getText());
		tester.setIndustry(this.industry.getText());
		tester.setEducation(this.education.getText());
//		tester.setEducation(this.email.getText());
		
		return tester;
	}
    public AbstractPage goBack() throws InterruptedException{
    	this.driver.navigate().back();
    	Thread.sleep(1000);
    	
    	return this;
    }

}