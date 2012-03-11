package cdp.lviv.singrabber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;


import cdp.lviv.singrabber.pages.HomePage;
import cdp.lviv.singrabber.pages.LoginPage;
import cdp.lviv.singrabber.pages.ProfilePage;
import cdp.lviv.singrabber.pages.SearchResultPage;

public class MyRunner {

	public static void main(String[] args) throws InterruptedException {
		
//      FirefoxProfile profile = new ProfilesIni().getProfile("selenium");
//      DesiredCapabilities capabilities = DesiredCapabilities.firefox();
//      capabilities.setJavascriptEnabled(true);
//      capabilities.setCapability(FirefoxDriver.PROFILE, profile);
//		WebDriver driver = new FirefoxDriver(capabilities);
		
		WebDriver driver = new HtmlUnitDriver();
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.open();
		loginPage.login("", "");
		
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.search("Lviv qa");
		
		for(int i=1; i<5; i++){
			SearchResultPage searchResult = PageFactory.initElements(driver, SearchResultPage.class);
//	    	System.out.println(searchResult.getAllNamesOnPage());

			for(int j=1; j<11; j ++){
				searchResult.getPerson(j);
				ProfilePage profilePage = PageFactory.initElements(driver, ProfilePage.class);
				
		        profilePage.getInfo();
		        profilePage.goBack();
			}
			
			searchResult.getNextSearchResult();
		}
        
        driver.quit();
	}
}
