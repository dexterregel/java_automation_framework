

public class AutomationFramework
{
	public static void main(String[] args)
	{
		//need to look into the advantages of having this defined as an env variable
		String pathToDrivers = "C:\\Users\\Dexter\\Documents\\Programming\\Java\\Java_automation_framework\\framework\\drivers\\";
		
		System.setProperty("webdriver.chrome.driver", pathToDrivers+"chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", pathToDrivers+"geckodriver.exe");
		
		System.out.println("hello");
		
		AmazonSearch amazonSearchTest = new AmazonSearch();
		amazonSearchTest.run();
		
	}
}









