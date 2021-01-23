
import java.lang.reflect.Method;


public class AutomationFramework
{
	public static void main(String[] args)
	{
		//stop if args is empty
		if (args.length == 0)
		{
			System.out.println("No tests specified");
			System.exit(1);
		}	
		
		
		//set location of drivers
		String pathToDrivers = "C:\\Users\\Dexter\\Documents\\Programming\\Java\\Java_automation_framework\\framework\\drivers\\";
		System.setProperty("webdriver.chrome.driver", pathToDrivers+"chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", pathToDrivers+"geckodriver.exe");
		
		
		//create log object

		//method 
		String methodName = "runTest";
		
		//tests are supplied as test1~test2~test3
		//split and run the tests
		String[] tests = args[0].split("~");
		for (String test : tests)
		{
			try
			{
				//create object for the test and run its start method
				Class c = Class.forName(test);
				Object o = c.newInstance();
				Method m = c.getMethod(methodName);
				m.invoke(o);
			}
			catch (ClassNotFoundException e)
			{
				System.out.println("Could not find class " + test);
				//continue on to other tests, if there are any
				//it should be noted in the results that this test didn't run
			}
			catch (NoSuchMethodException e)
			{
				System.out.println("Could not find method " + methodName);
			}
			catch (Exception e)
			{
				System.out.println("Could not run " + test);
			}
		}
		
		//report statuses of tests that ran
	}
}
