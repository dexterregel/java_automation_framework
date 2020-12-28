

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;



class BasePage
{
	public static String baseUrl = "https://www.amazon.com/";
	public static String searchBar = "input[id='twotabsearchtextbox']";
	public WebDriver driver;
	
	public BasePage(WebDriver driver)
	{
		this.driver = driver;
	}
}


class AmazonHomePage extends BasePage
{
	public AmazonHomePage(WebDriver driver)
	{
		super(driver);
	}
	
	
	public void enterSearchTerms(String searchTerms)
	{
		driver.get(BasePage.baseUrl);
		driver.findElement(By.cssSelector(searchBar)).sendKeys(searchTerms);
	}
}

