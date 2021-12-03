
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.util.List;
import java.util.ArrayList;


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
		
		
		//set location of browser drivers
		String pathToDrivers = "C:\\Users\\Dexter\\Documents\\Programming\\Java\\Java_automation_framework\\framework\\drivers\\";
		System.setProperty("webdriver.chrome.driver", pathToDrivers+"chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", pathToDrivers+"geckodriver.exe");
		
		
		//create log object here
		
		//settings for running tests
		String testDelimiter = "~";
		String methodName = "runTest";
		String testStatusFieldName = "testStatus";
		
		
		//for storing and later reporting test results
		Object[] testResult = new Object[2];
		List<Object[]> testResults = new ArrayList<Object[]>();
		
		//tests are supplied as test1~test2~test3
		//split and run the tests
		String[] tests = args[0].split(testDelimiter);
		for (String test : tests)
		{
			try
			{
				//create object for the test and run its start method
				Class c = Class.forName(test);
				Object o = c.newInstance();
				Method m = c.getMethod(methodName);
				m.invoke(o);
				
				
				/* left off here. problems are:
				when i print the f.get(o), i get the actual value of the field
				but when i try setting a string array element to it, it says
				incompat types, can't convert to string. that's because the f.get
				is returning an object
				so i tried making the array an array of objects instead of string and that makes the
				code happy, but it still prints nonsense when i try to print either
				the array or the arraylist. but printing things out on their own is
				totally fine?? so maybe i need to revist doing toString() for each
				of them
				
				*/
				Field f = c.getSuperclass().getField(testStatusFieldName);
				testResult[0] = test;
				testResult[1] = f.get(o);
				System.out.println("Test name: " + test);
				System.out.println("Test result: " + f.get(o));
				System.out.println("testResult list: " + testResult);
				testResults.add(testResult);
				
			}
			catch (ClassNotFoundException e)
			{
				System.out.println("Could not find class " + test);
				System.out.println(e);
				//continue on to other tests, if there are any
				//it should be noted in the results that this test didn't run
			}
			catch (NoSuchMethodException e)
			{
				System.out.println("Could not find method " + methodName);
				System.out.println(e);
			}
			catch (Exception e)
			{
				System.out.println("Could not run " + test);
				System.out.println(e);
			}
			finally
			{
				//this is where the framework should collect the status of each test
			}
		}
		
		//report statuses of tests via testResults
		System.out.println("all test results: " + testResults.toString());
	}
}
