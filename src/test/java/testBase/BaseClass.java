package testBase;

import java.io.File;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public static WebDriver driver;
	public Properties pr;
	
	@BeforeClass()
	@Parameters({"browser"} )
	public void setup(String br) throws IOException
	{
		switch(br.toLowerCase())
		{
		case "chrome":driver= new ChromeDriver(); break;
		case "firefox":driver= new FirefoxDriver(); break;
		case "edge":driver= new EdgeDriver(); break;
		default: System.out.println("No matching Browsers");
			return;
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://app.germanyiscalling.com/common/login");
		driver.manage().window().maximize();
	}
	@AfterClass()
	public void teardown()
	{
		driver.close();
	}
	
	public String randomString() { 
		String generatedString=RandomStringUtils.randomAlphabetic(8);
		return generatedString;
	}
	
	public String randomNumeric() { 
		String generatedNumeric=RandomStringUtils.randomNumeric(10);
		return generatedNumeric;
	}
	
	public String randomAlphaNumeric() { 
		String str=RandomStringUtils.randomAlphabetic(3);
		String num=RandomStringUtils.randomNumeric(3);

		return (str+"@"+num);
	}
	
	public String randomLengthyString() { 
		String generatedString=RandomStringUtils.randomAlphabetic(25);
		return generatedString;
	}
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
}
