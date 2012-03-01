package cdp.lviv.singrabber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;


import cdp.lviv.singrabber.pages.LoginPage;

public class MyRunner {

	public static void main(String[] args) {
		
        FirefoxProfile profile = new ProfilesIni().getProfile("selenium");
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setJavascriptEnabled(true);
        capabilities.setCapability(FirefoxDriver.PROFILE, profile);
		WebDriver driver = new FirefoxDriver(capabilities);
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

		loginPage.open();
		loginPage.login("mail", "passwd");
		
        driver.quit();
	}

}
