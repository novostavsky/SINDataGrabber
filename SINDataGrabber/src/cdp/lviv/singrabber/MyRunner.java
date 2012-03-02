package cdp.lviv.singrabber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;


import cdp.lviv.singrabber.pages.HomePage;
import cdp.lviv.singrabber.pages.LoginPage;
import cdp.lviv.singrabber.pages.ProfilePage;
import cdp.lviv.singrabber.pages.SearchResultPage;

public class MyRunner {

	public static void main(String[] args) throws InterruptedException {
		
        FirefoxProfile profile = new ProfilesIni().getProfile("selenium");
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setJavascriptEnabled(true);
        capabilities.setCapability(FirefoxDriver.PROFILE, profile);
		WebDriver driver = new FirefoxDriver(capabilities);
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.open();
        Thread.sleep(1000);
		loginPage.login("novostavsky@gmail.com", "nbjteaqhs");
		
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        Thread.sleep(1000);
		homePage.search("Lviv qa");
		
		SearchResultPage searchResult = PageFactory.initElements(driver, SearchResultPage.class);
        Thread.sleep(1000);
		System.out.println(searchResult.getAllNamesOnPage());
		searchResult.getPerson(1);
		
		ProfilePage profilePage = PageFactory.initElements(driver, ProfilePage.class);
        Thread.sleep(1000);
        profilePage.getInfo();
		
        driver.quit();
	}

}
