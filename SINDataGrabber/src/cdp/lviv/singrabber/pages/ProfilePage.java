package cdp.lviv.singrabber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends AbstractPage {
//  @FindBy(className = "given-name")
//  private WebElement givenName;
//  
//  @FindBy(className = "family-name")
//  private WebElement familyName;
//  
//  @FindBy(className = "headline-title title")
//  private WebElement currentTitle;
//  
//  @FindBy(className = "locality")
//  private WebElement location;
//
//  @FindBy(className = "industry")
//  private WebElement industry;
//  
//  @FindBy(className = "current")
//  private WebElement currentPosition;
  
  @FindBy(xpath = "//div/h4/strong/span/strong/a/span")
  private WebElement company;
	
	public ProfilePage(WebDriver driver) {
		super(driver);
	}
	public void getInfo(){
		System.out.println(
//				this.givenName + "\n" +
//				this.familyName + "\n" +
//				this.currentTitle + "\n" +
//				this.location + "\n" +
//				this.industry + "\n" +
//				this.currentPosition + "\n" +
				this.company.getText());
	}

}