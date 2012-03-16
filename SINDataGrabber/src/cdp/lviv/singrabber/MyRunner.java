package cdp.lviv.singrabber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cdp.lviv.singrabber.pages.HomePage;
import cdp.lviv.singrabber.pages.LoginPage;
import cdp.lviv.singrabber.pages.ProfilePage;
import cdp.lviv.singrabber.pages.SearchResultPage;

public class MyRunner {

	public static void main(String[] args) {
		
		try {
			MyRunner.grab("Lviv QA");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
	public static void grab(String searchPattern) throws InterruptedException{
		WebDriver driver = SINDriver.getInstance().getDriver();
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.open();
		
		HomePage homePage = (HomePage) loginPage.login("", "");
		SearchResultPage searchResult = (SearchResultPage) homePage.search(searchPattern);
		
		for(int i=1; i<5; i++){
			for(int j=1; j<11; j ++){
				ProfilePage profilePage = (ProfilePage) searchResult.getPerson(j);
		        profilePage.getInfo();
		        profilePage.goBack();
			}
			searchResult.getNextSearchResult();
		}
        driver.quit();
	}
}
