package cdp.lviv.singrabber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends AbstractPage {
  @FindBy(className = "backToResults")
  private WebElement goBackLink;  
	
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
  
  @FindBy(className = "abook-email")
  private WebElement email;
  
  private String id;
 
	
	public ProfilePage(WebDriver driver) {
		super(driver);
		
		//get linkedin id from url
		this.id = this.driver.getCurrentUrl().split("id=")[1].split("&")[0];
	}
	public void getInfo(){
		System.out.println(
				this.id + "\n" +
				this.givenName.getText() + "\n" +
				this.familyName.getText() + "\n" +
				this.currentTitle.getText() + "\n" +
				this.pastTitle.getText()  + "\n" +
				this.period.getText() + "\n" +
				this.locality.getText() + "\n" +
				this.industry.getText() + "\n" +
				this.email.getText());
	}
    public AbstractPage goBack(){
    	this.goBackLink.click();
    	
    	return this;
    }

}