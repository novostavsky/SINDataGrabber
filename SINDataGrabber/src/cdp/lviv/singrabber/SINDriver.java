package cdp.lviv.singrabber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class SINDriver {
	private static volatile SINDriver instance;
	private WebDriver webDriver;
	
	private SINDriver(){
//****** use Firefox driver for debug if you need it
//      FirefoxProfile profile = new ProfilesIni().getProfile("selenium");
//      DesiredCapabilities capabilities = DesiredCapabilities.firefox();
//      capabilities.setJavascriptEnabled(true);
//      capabilities.setCapability(FirefoxDriver.PROFILE, profile);
//		WebDriver driver = new FirefoxDriver(capabilities);
		
//****** use headless htmlunit if you need speed
		WebDriver driver = new HtmlUnitDriver();
		
		this.webDriver = driver;
	}
	
	public static SINDriver getInstance(){
		SINDriver localInstance = SINDriver.instance;
		if(localInstance == null){
			synchronized(SINDriver.class){
				localInstance = SINDriver.instance;
				if(localInstance == null){
					SINDriver.instance = localInstance = new SINDriver();
				}
			}
		}
		return localInstance;
	}
	public WebDriver getDriver(){
		return this.webDriver;
	}
}
