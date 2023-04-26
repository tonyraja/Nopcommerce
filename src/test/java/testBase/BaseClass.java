package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	public static WebDriver driver;
	
	public Logger logger;
	
	public ResourceBundle rb;
	
	
	@BeforeClass(groups= {"Master","Regression","Sanity"})
	@Parameters("browser")
	public void setup(String br)
	{
		
		logger=LogManager.getLogger(this.getClass());
		
		rb=ResourceBundle.getBundle("config");
		
		if(br.equals("edge"))
		{
		driver=new EdgeDriver();
		}
		
		else if(br.equals("chrome"))
		{
			driver=new ChromeDriver();
			
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(rb.getString("appURL"));
		driver.manage().window().maximize();
		
	}
	
	@AfterClass(groups= {"Master","Regression","Sanity"})
	public void teardown()
	{
		driver.quit();
	}
	
	
	public String randomstring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(5);
				return(generatedstring);
	}
	
	public String randomnumber()
	{
		String generatednumber=RandomStringUtils.randomNumeric(10);
		return(generatednumber);
	}
	
	public String alphanumeric()
	{
	String alpha=RandomStringUtils.randomAlphabetic(5);
	String numeric=RandomStringUtils.randomNumeric(3);
	return(alpha+"@"+numeric);
	}

	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;
	}

	
	}

