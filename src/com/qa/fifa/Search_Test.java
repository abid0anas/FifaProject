package com.qa.fifa;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Search_Test {
	
	
	@Test
	public void validateSearch() {
		
		//setup chrome driver
		WebDriverManager.chromedriver().setup();
		//create a webdriver object
		WebDriver driver = new ChromeDriver();
		
		//open url
		driver.get("https://www.google.com");
		//maximize window
		driver.manage().window().maximize();
		driver.findElement(By.linkText("English")).click();
		//type in search
		driver.findElement(By.name("q")).sendKeys("fifa world cup 2022");
		//click search by hitting enter
		driver .findElement(By.name("q")).sendKeys(Keys.ENTER);
		//capture webelement
		WebElement firstLink = driver.findElement(By.xpath("(//div[@class='ofy7ae'])[1]"));
		String actualText = firstLink.getText();
		String expected = "FIFA World Cup Qatar 2022™";
		//adding assertion to the test
		Assert.assertTrue(actualText.equalsIgnoreCase(expected), "Expected "+actualText+ " but found>> "+actualText);
				
				
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	

}
