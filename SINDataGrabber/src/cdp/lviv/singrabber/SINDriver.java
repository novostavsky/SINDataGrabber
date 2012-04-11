package cdp.lviv.singrabber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SINDriver {
	private static volatile SINDriver instance;
	private WebDriver webDriver;
	
	private SINDriver(){
//******use Firefox driver for debug if you need it
//		this.webDriver = SINDriver.getFullDriver();		
//******use headless htmlunit if you need speed
		this.webDriver = SINDriver.getHeadlessDriver();
	}
	
	private static WebDriver getFullDriver(){
	    FirefoxProfile profile = new ProfilesIni().getProfile("selenium");
	    DesiredCapabilities capabilities = DesiredCapabilities.firefox();
	    capabilities.setJavascriptEnabled(true);
	    capabilities.setCapability(FirefoxDriver.PROFILE, profile);
	    
	    return new FirefoxDriver(capabilities);
	}
	private static WebDriver getHeadlessDriver(){
		return new HtmlUnitDriver();
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
