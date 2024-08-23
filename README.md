Automated Testing of Germany is Calling Web Application:
This repository contains Selenium test scripts for automating the login functionality of the "Germany is Calling" web application. The test scripts cover both successful and unsuccessful login scenarios.

Table of Contents:
- Test Execution Steps
- Assumptions
- Additional Information

Test Execution Steps
Prerequisites:

1. Java Development Kit (JDK):
   - Ensure that JDK 8 or above is installed on your machine.
   - Set up the `JAVA_HOME` environment variable.

2. Maven:
   - Install Maven to manage dependencies and build the project.
   - Ensure that Maven is added to your system’s `PATH`.

3. IDE:
   - Use an IDE like IntelliJ IDEA or Eclipse for writing and running the test scripts.

4. Browser:
   - Ensure that the web browser (e.g., Chrome, Firefox) you plan to test is installed.
   - Download the corresponding WebDriver (e.g., ChromeDriver, GeckoDriver).

5. Cloning the Repository:
   - Clone the repository to your local machine using:
     git clone https://github.com/your-username/repo-name.git
     cd repo-name
 
Setting Up the Project:

1. Open the Project in Your IDE:
   - Open the cloned project in your preferred IDE.

2. Install Dependencies:
   - The `pom.xml` file is configured with all necessary dependencies. Ensure that all the dependencies have been installed into your system.

3. Configure WebDriver:
   - Ensure that the WebDriver executable (e.g., `chromedriver.exe` for Chrome) is available in the system's `PATH`. WebDriverManager dependency have been used to manage all the browser     drivers.

Running the Tests:

1. Run All Tests:
   - You can run all test scripts together by using the Master.xml file, which consists of the test scenario (TC_001_Login_Test) with all the test cases.

3. Test Reports:
   - After executing the tests, you can find the test report in the `reports` folder. The report generated is Extent Report implemented through ExtentReportManager.java file and listeners.

Assumptions:

- Environment Setup: It is assumed that the test environment (browser, WebDriver, etc.) is set up and configured correctly on the machine where the tests will be executed.
- Test Data: Valid and invalid credentials are assumed to be available and configured by random generation through java.
- Network Availability: The test scripts assume a stable internet connection for accessing the web application.
- Application Stability: It is assumed that the web application under test is stable and running during the test execution.
