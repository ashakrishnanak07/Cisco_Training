package com.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TestNGExercise {
	
	WebDriver driver;
	@BeforeSuite
	 
	@Parameters({"browserName","url"})
	public void setup(@Optional("Firefox")String browsername,String url)
	{
		driver = new FirefoxDriver();
		driver.get(url);
	}
	
		
	  @Test
	  public void f() {
		  
	  }
}
