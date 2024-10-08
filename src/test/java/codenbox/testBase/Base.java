package codenbox.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class Base {
	
	public static WebDriver driver;
	public Logger logger;
	public Properties prop;
	public FileInputStream fs;

   // will run before every test cases
	@BeforeMethod (alwaysRun=true)
	@Parameters({"OS","Browser"})
	public void setup(String osName,String browserName) throws IOException {
		prop=new Properties();
		fs=new FileInputStream("./src//test//resources//data.properties");  // will connect with the file
		prop.load(fs); // will load the file 
		
		logger=LogManager.getLogger(); //load log4j from xml

	//remote or grid test env options
		if(prop.getProperty("test_env").equalsIgnoreCase("remote")) {
		DesiredCapabilities cap=new DesiredCapabilities();
	//		cap.setPlatform(Platform.WIN11);
	//		cap.setBrowserName("chrome");
		
		//os
		if(osName.equalsIgnoreCase("linux")) {
			cap.setPlatform(Platform.LINUX);
		}
		else if(osName.equalsIgnoreCase("mac")) {
			cap.setPlatform(Platform.MAC);
		}
		else {
			System.out.println("OS IS NOT MATCHING!");
			return;
		}
		
		//browser
		switch(browserName.toLowerCase()) 
		{
		case "chrome": cap.setBrowserName("chrome"); break;	
		case "firefox": cap.setBrowserName("firefox");break;
		case "edge" : cap.setBrowserName("MicrosoftEdge");break;
		default:System.out.println("Browser doesn't exist"); return;
		}
		//hub URL =ip address of hub machine+hub port+/wd/hub
		//ip address of hub machine= http://192.168.2.50

		String huburl="http://localhost:4444/wd/hub";
		 driver=new RemoteWebDriver(new URL(huburl), cap);
		
	}	
		
		//local test env options
		if(prop.getProperty("test_env").equalsIgnoreCase("local")) {
		switch(browserName.toLowerCase()) 
		{
		case "chrome": driver=new ChromeDriver(); break;
		case "chromeheadless":
			ChromeOptions options=new ChromeOptions();
			options.addArguments("headless");
			driver=new ChromeDriver(options); 
			driver.manage().window().setSize(new Dimension(1440,900));
			break;
			
		case "firefox": driver=new FirefoxDriver();break;
		case "edge" : driver=new EdgeDriver();break;
		default:System.out.println("Browser doesn't exist"); return;
		}
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	//	driver.get("https://tutorialsninja.com/demo/");
		driver.get(prop.getProperty("baseUrl"));
		driver.manage().window().maximize();
	}
	//will run end of each test csae
	@AfterMethod (alwaysRun=true)
	public void tearDown() {
		driver.quit();
	}
	
	public String getRandomString() { //commons.lang3 library RandomStringUtils
		return RandomStringUtils.randomAlphabetic(6);
	}
	
	public String getRandomNum() { //commons.lang3 library RandomStringUtils
		return RandomStringUtils.randomNumeric(10);
	}
	
	public String getRandomAlphaNumeric() {
		String stringValue= RandomStringUtils.randomAlphabetic(4);
		String numericValue=RandomStringUtils.randomNumeric(3);
		return (stringValue+stringValue+"@");
	}
	
	public String getScreenshot(String methodName) throws IOException {
		String currentTimeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		File srcFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\"+methodName+"_"+currentTimeStamp+".png";
		File targetFile=new File(targetFilePath);
		FileUtils.copyFile(srcFile, targetFile);
		return targetFilePath; 
	}
	
	

}
