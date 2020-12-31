

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//need to import code from the frame and from the amazon page

class BaseTest
{
	public static String testStatus;
}


class AmazonSearch extends BaseTest
{
	String status = "pass";
	
	public void runTest()
	{
		//log that test starts
		
		WebDriver driver = new FirefoxDriver();
		
		AmazonHomePage amazonHomePage = new AmazonHomePage(driver);
		amazonHomePage.enterSearchTerms("hello");
		
		driver.quit();
		
		//log that tests stops
	}
}


class AlsoAmazonSearch extends BaseTest
{
	String status = "pass";
	
	public void runTest()
	{
		WebDriver driver = new FirefoxDriver();
		
		AmazonHomePage amazonHomePage = new AmazonHomePage(driver);
		amazonHomePage.enterSearchTerms("hello");
		
		driver.quit();
	}
}











