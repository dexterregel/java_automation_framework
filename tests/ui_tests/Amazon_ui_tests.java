

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//need to import code from the frame and from the amazon page


class AmazonSearch
{
	private String status;
	
	public void run()
	{
		WebDriver driver = new FirefoxDriver();
		
		AmazonHomePage amazonHomePage = new AmazonHomePage(driver);
		amazonHomePage.enterSearchTerms("hello");
	}
}













