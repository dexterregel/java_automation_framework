
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.ArrayList;


class BaseTest
{
	public static String testStatus;
}


class AmazonSearch extends BaseTest
{
	String testStatus;
	
	public void runTest()
	{
		//log that test starts
		
		WebDriver driver = new FirefoxDriver();
		
		AmazonHomePage amazonHomePage = new AmazonHomePage(driver);
		amazonHomePage.enterSearchTerms("hello");
		
		driver.quit();
		
		//log that test is done
	}
}

//this test searches for a product, sets a max and minimum price range filter,
//then verifies all results on the first page fall within that range
class AmazonMinMaxPriceTest extends BaseTest
{
	static String testStatus;
	
	public void runTest()
	{
		String searchTerms = "nintendo switch";
		int minPrice = 200;
		int maxPrice = 300;
		
		WebDriver driver = new FirefoxDriver();
		
		AmazonHomePage homePage = new AmazonHomePage(driver);
		homePage.enterSearchTerms(searchTerms);
		homePage.performSearch();
		
		AmazonSearchResultsPage searchResultsPage = new AmazonSearchResultsPage(driver);
		searchResultsPage.enterMinPrice(minPrice);
		searchResultsPage.enterMaxPrice(maxPrice);
		searchResultsPage.confirmPriceRange();
		
		ArrayList<Integer> itemPrices = new ArrayList<Integer>();
		itemPrices = searchResultsPage.getPriceAllItems();
		System.out.println("Prices found: " + itemPrices);
		
		//check prices. if any are outside of 200-300, fail the test
		
		//log that test is done
		
		driver.quit();
	}
}
