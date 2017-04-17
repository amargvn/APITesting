package com.api.scripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import junit.framework.Assert;
import org.apache.http.client.ClientProtocolException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

@SuppressWarnings("deprecation")
public class WeatherApiTest {
	private WebDriver driver;
	private String baseUrl;
	private String driverPath="D:\\QAWorkspace\\APITesting\\lib\\";
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "D:\\QAWorkspace\\APITesting\\lib\\geckodriver.exe");
		driver = new FirefoxDriver();
		    baseUrl = "http://openweathermap.org/current";
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  }
	

	@After
	public void tearDown() throws Exception {
		 driver.close();;
		 driver.quit();
	}

	@Test
	public void test() throws ClientProtocolException, IOException {
		System.out.println("Launched a browser");
		driver.get("http://openweathermap.org/current");
		System.out.println("Navigating");
		driver.navigate().to("http://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b1b15e88fa797225412429c1c50c122a1");	
	 WebElement webElement=driver.findElement(By.tagName("pre"));
	 WeatherApiResponse weatherApiResponse=new WeatherApiResponse();
	 String ExpectedString=weatherApiResponse.GetResponse();
	 Assert.assertTrue(webElement.getText().equals(ExpectedString));
	}

}