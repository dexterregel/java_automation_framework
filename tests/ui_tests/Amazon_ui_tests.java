
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.List;
import java.util.ArrayList;


class BaseTest
{
	public static String testStatus;
	
	//todo limit the allowed values for result to pass, fail, and notrun
	public void setTestResult(String result)
	{
		this.testStatus = result;
	}
	
	
	public String getTestResult()
	{
		return this.testStatus;
	}
}


/********************************************************************
this test is just a dummy test to test running multiple tests
********************************************************************/
class AmazonSearch extends BaseTest
{
	public void runTest()
	{
		System.out.println("*********************");
		System.out.println("Starting AmazonSearch");
		System.out.println("*********************");
		
		WebDriver driver = new FirefoxDriver();
		
		try
		{
			
			AmazonHomePage amazonHomePage = new AmazonHomePage(driver);
			amazonHomePage.enterSearchTerms("hello");
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		
		driver.quit();
		
		System.out.println("*********************");
		System.out.println("Stopping AmazonSearch");
		System.out.println("*********************");
	}
}


/********************************************************************
this test searches for a product, sets the max and minimum price range filter,
then verifies all results on the first page fall within that range
********************************************************************/
class AmazonPriceRangeTest extends BaseTest
{
	public void runTest()
	{
		System.out.println("*****************************");
		System.out.println("Starting AmazonPriceRangeTest");
		System.out.println("*****************************");
		
		//test variables
		String searchTerms = "nintendo switch";
		int minPrice = 250;
		int maxPrice = 350;
				
		WebDriver driver = new FirefoxDriver();
		try
		{
			AmazonHomePage homePage = new AmazonHomePage(driver);
			homePage.enterSearchTerms(searchTerms);
			homePage.performSearch();
			
			AmazonSearchResultsPage searchResultsPage = new AmazonSearchResultsPage(driver);
			searchResultsPage.enterMinPrice(minPrice);
			searchResultsPage.enterMaxPrice(maxPrice);
			searchResultsPage.confirmPriceRange();
			
			List<Integer> itemPrices = new ArrayList<Integer>();
			itemPrices = searchResultsPage.getPriceAllItems();
			System.out.println("Prices found: " + itemPrices);
			
			//check if each price is within the range
			for (Integer price : itemPrices)
			{
				if (price < minPrice || price > maxPrice)
				{
					System.out.println("Price " + price + " is outside the price range of " + minPrice + "-" + maxPrice);
					throw new Exception("Not all prices were within the range");
				}
			}
			
			System.out.println("All found prices are inside the price range of " + minPrice + "-" + maxPrice);
			this.testStatus = "pass";
		}
		catch (Exception e)
		{
			System.out.println("Test failed due to: " + e);
			this.testStatus = "fail";
		}
		
		driver.quit();
		
		System.out.println("*****************************");
		System.out.println("Stopping AmazonPriceRangeTest");
		System.out.println("*****************************");
	}
}
