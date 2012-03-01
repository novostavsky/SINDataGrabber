package cdp.lviv.singrabber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {
    @FindBy(id = "session_key-login")
    private WebElement emailField;

    @FindBy(id = "session_password-login")
    private WebElement passwordField;
    
    @FindBy(id = "btn-login")
    private WebElement signInButton;
    
    
	public LoginPage(WebDriver driver) {
		super(driver);
	}
    public LoginPage open() {
        super.openRelativePath("");
        return this;
    }
    public AbstractPage login(String email, String password){
    	this.emailField.sendKeys(email);
    	this.passwordField.sendKeys(password);
    	this.signInButton.click();
    	
    	return this;
    }
}
