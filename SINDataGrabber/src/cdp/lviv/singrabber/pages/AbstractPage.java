package cdp.lviv.singrabber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AbstractPage {
	protected static final String BASIC_URL = "http://www.linkedin.com";
	protected WebDriver driver;
	
	public AbstractPage(WebDriver driver){
		this.driver = driver;
	}
	
	protected AbstractPage openRelativePath(String relativePath){
		this.driver.get(AbstractPage.BASIC_URL + relativePath);
		return this;
	}
    protected WebElement findByXPath(String xpathLocator) {
        return this.driver.findElement(By.xpath(xpathLocator));
    }
    protected WebElement findById(String id) {
        return this.driver.findElement(By.id(id));
    }
    protected WebElement findByCss(String cssLocator) {
        return this.driver.findElement(By.cssSelector(cssLocator));
    }
    protected void clickLink(String linkText) {
        this.driver.findElement(By.linkText(linkText)).click();
    }
}
