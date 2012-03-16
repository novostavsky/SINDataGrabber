package cdp.lviv.singrabber;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import cdp.lviv.singrabber.dao.Tester;
import cdp.lviv.singrabber.db.TesterManager;
import cdp.lviv.singrabber.pages.HomePage;
import cdp.lviv.singrabber.pages.LoginPage;
import cdp.lviv.singrabber.pages.ProfilePage;
import cdp.lviv.singrabber.pages.SearchResultPage;

public class MyRunner {

	public static void main(String[] args) {
		
//      FirefoxProfile profile = new ProfilesIni().getProfile("selenium");
//      DesiredCapabilities capabilities = DesiredCapabilities.firefox();
//      capabilities.setJavascriptEnabled(true);
//      capabilities.setCapability(FirefoxDriver.PROFILE, profile);
//		WebDriver driver = new FirefoxDriver(capabilities);
		
		WebDriver driver = new HtmlUnitDriver();
		
		try {
			MyRunner.grab(driver, "Lviv QA", "", "");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.quit();
	}
	
	public static void grab(WebDriver driver, String searchString, String login, String passwd) throws InterruptedException{
		TesterManager manager = new TesterManager();
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.open();
		loginPage.login(login, passwd);
		
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.search(searchString);
		
		for(int i=1; i<11; i++){
			SearchResultPage searchResult = PageFactory.initElements(driver, SearchResultPage.class);

			for(int j=1; j<11; j ++){
				searchResult.getPerson(j);
				ProfilePage profilePage = PageFactory.initElements(driver, ProfilePage.class);
		        
				Tester tester = new Tester(); 
		        profilePage.initTester(tester);
		        
		        try {
					manager.insert(tester);
				} catch (SQLException e) {
					e.printStackTrace();
				}
		        
		        profilePage.goBack();
			}
			searchResult.getNextSearchResult();
		}
	}
}
