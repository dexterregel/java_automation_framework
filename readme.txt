
download and install jdk 15.0.1
setup environment variables
	create a new system variable called JAVA_HOME. it should be the install directory of the jdk, like:
		C:\Program Files\Java\jdk-15.0.1
	so that javac can be used from any directory in cmd prompt, add this to the system Path variable:
		%JAVA_HOME%\bin
add necessary drivers
	https://www.selenium.dev/documentation/en/webdriver/driver_requirements/

compile everything with:
	javac -cp "framework\selenium-java-4.0.0-alpha-7\*;framework\selenium-java-4.0.0-alpha-7\lib\*" AutomationFramework.java pages\Amazon_pages.java tests\ui_tests\Amazon_ui_tests.java
run everything with:
	java -cp framework\selenium-java-4.0.0-alpha-7;framework\selenium-java-4.0.0-alpha-7\lib;pages;tests\ui_tests; AutomationFramework


conventions
	all tests are classes
	each test class' steps should be in a method named runTest
