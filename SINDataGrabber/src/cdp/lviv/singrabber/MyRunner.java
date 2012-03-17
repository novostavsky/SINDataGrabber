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
		try {
			MyRunner.grab("test Lviv", "", "");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void grab(String searchString, String login, String passwd) 
															throws InterruptedException{
		
		WebDriver driver = SINDriver.getInstance().getDriver();
		TesterManager manager = new TesterManager();
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.open();
		HomePage homePage = (HomePage) loginPage.login(login, passwd);
		
		SearchResultPage searchResult = (SearchResultPage) homePage.search(searchString);
		
		while(!searchResult.isTheEnd()){
			int personsOnpage = searchResult.getNumOfPersonsOnPage();
			for(int j=1; j<(personsOnpage+1); j ++){
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
		driver.quit();
	}
}
