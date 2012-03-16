package cdp.lviv.singrabber;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cdp.lviv.singrabber.dao.Tester;
import cdp.lviv.singrabber.db.TesterManager;
import cdp.lviv.singrabber.pages.HomePage;
import cdp.lviv.singrabber.pages.LoginPage;
import cdp.lviv.singrabber.pages.ProfilePage;
import cdp.lviv.singrabber.pages.SearchResultPage;

public class MyRunner {

	public static void main(String[] args) {
		WebDriver driver = SINDriver.getInstance().getDriver();
		
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
		HomePage homePage = (HomePage) loginPage.login(login, passwd);
		
		SearchResultPage searchResult = (SearchResultPage) homePage.search(searchString);
		
		for(int i=1; i<11; i++){
			for(int j=1; j<11; j ++){
				ProfilePage profilePage = (ProfilePage) searchResult.getPerson(j);
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
