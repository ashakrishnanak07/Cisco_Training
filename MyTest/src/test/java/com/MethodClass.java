package com;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MethodClass {

	WebDriver driver;

	public MethodClass(WebDriver driver) {
		this.driver = driver;
	}

	public void signIn(String un, String pwd) {
		try {
			
			System.out.println("Enter into sign in");
			driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
			driver.findElement(By.id("email")).sendKeys(un);
			driver.findElement(By.id("passwd")).sendKeys(pwd);
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[2]/form/div/p[2]/button/span"))
					.click();

			String msg = driver.findElement(By.className("info-account")).getText();

			System.out.println("MSG = " + msg);
			Assert.assertEquals(msg,
					"Welcome to your account. Here you can manage all of your personal information and orders.");

			// logout
			driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a")).click();

		} catch (Exception e) {

		}
	}


	 public void category() throws InterruptedException {
		 

	       Actions actions = new Actions(driver);
	       driver.findElement(By.linkText("Women")).click();
	       WebElement actionobj1 = driver.findElement(By.xpath("//body/div[@id='page']/div[2]/div[1]/div[3]/div[2]/ul[1]/li[4]/div[1]/div[2]/div[3]/ul[1]"));
	       Thread.sleep(3500);
	       actions.moveToElement(actionobj1).perform();
	       WebElement addtocart1 = driver.findElement(By.xpath("//body/div[@id='page']/div[2]/div[1]/div[3]/div[2]/ul[1]/li[4]/div[1]/div[2]/div[2]/a[1]/span[1]"));
	       JavascriptExecutor executor = (JavascriptExecutor)driver;
	       executor.executeScript("arguments[0].click();", addtocart1);
	       Thread.sleep(3000);
	       driver.findElement(By.xpath("//header/div[3]/div[1]/div[1]/div[4]/div[1]/div[2]/div[4]/a[1]/span[1]")).click();
	       Thread.sleep(3000);       
	        
	        
	 }

	
	
	
	
	
	
	
	
	
	
	
	/****************************************************************************************/	
	/*
	public void category() throws InterruptedException {

		// select T shirt tab

		driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[3]/a")).click();
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();

		// click on image
		driver.findElement(By.xpath("//*[@id=\"color_2\"]")).click();

		Thread.sleep(10);
		driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[1]/span")).click();
		System.out.println("Clicked on color");
		Thread.sleep(5);
		// click on add to cart
	//	driver.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button/span")).click();
		Thread.sleep(10);
		// cick on proceed to pay
		driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a/span")).click();
				

	}
	*/
	/****************************************************************************************/

}
