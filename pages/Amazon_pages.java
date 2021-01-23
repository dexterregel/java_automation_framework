
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.ArrayList;


class BasePage
{
	public static String baseUrl = "https://www.amazon.com/";
	public WebDriver driver;
	
	//css selectors common to most Amazon pages
	public static final String searchBar = "input[id='twotabsearchtextbox']";
	public static final String performSearchButton = "input[id='nav-search-submit-button']";
	
	
	//constructor
	public BasePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	//page interactions commmon to most Amazon pages
	public void navigateToMainSite()
	{
		driver.get(BasePage.baseUrl);
	}
	
	
	public void enterSearchTerms(String searchTerms)
	{
		driver.get(BasePage.baseUrl);
		driver.findElement(By.cssSelector(searchBar)).sendKeys(searchTerms);
	}
	
	
	public void performSearch()
	{
		driver.findElement(By.cssSelector(performSearchButton)).click();
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


class AmazonSearchResultsPage extends BasePage
{
	//css selectors
	private static final String minPriceField = "input[id='low-price']";
	private static final String maxPriceField = "input[id='high-price']";
	private static final String confirmPriceRangeButton = "input[class='a-button-input']";
	private static final String priceField = "span[class='a-price-whole']";
	
	
	//constructor
	public AmazonSearchResultsPage(WebDriver driver)
	{
		super(driver);
	}
	
	//=================
	//Page interactions
	//=================
	
	//enters a value in the min price range field
	public void enterMinPrice(Integer minPrice)
	{
		driver.findElement(By.cssSelector(minPriceField)).sendKeys(minPrice.toString());
	}
	
	
	//enters a value in the max price range field
	public void enterMaxPrice(Integer maxPrice)
	{
		driver.findElement(By.cssSelector(maxPriceField)).sendKeys(maxPrice.toString());
	}
	
	
	//selects the Go button for the price range filter
	public void confirmPriceRange()
	{
		driver.findElement(By.cssSelector(confirmPriceRangeButton)).click();
	}
	
	
	//gets the price of every item on the current page
	public ArrayList<Integer> getPriceAllItems()
	{
		List<WebElement> itemPrices = new ArrayList<WebElement>();
		ArrayList<Integer> prices = new ArrayList<Integer>();
		
		itemPrices = driver.findElements(By.cssSelector(priceField));
		
		for (WebElement price : itemPrices)
		{
			prices.add(Integer.parseInt(price.getText()));
		}		
		
		return prices;
	}
}
