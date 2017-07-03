package Soltech;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Automation {

	/**
	 * @param args
	 * @throws 
	 */
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","lib/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		 driver.manage().window().getSize().getHeight();
		 
		//New resolution
		driver.manage().window().setSize(new Dimension(1814,974));
		 
		
		driver.get("http://soltech.net/");
		driver.manage().window().maximize();
				 
		driver.findElement(By.partialLinkText("MENU")).click();
		
		Thread.sleep(5000);
				
		driver.findElement(By.linkText("Open Positions")).click();
		Thread.sleep(5000);
		 		
		// Switch to new window
	     for (String handle : driver.getWindowHandles()) {

		    driver.switchTo().window(handle);}
					  		 
		// Window scroll down
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,600)", "");
			Thread.sleep(5000);
			
		//Find job title and view job description	
			driver.switchTo().frame(driver.findElement(By.cssSelector("iframe")));
			driver.findElement(By.cssSelector("#jsb_f_keywords_i")).sendKeys("QA");
			driver.findElement(By.cssSelector("#jsb_form_submit_i")).click();
			driver.findElement(By.partialLinkText("Automation Engineer")).click();
			
		// Check Job ID displayed	
			System.out.println(driver.findElement(By.xpath("html/body/div[2]/div[2]/div[1]/div[1]/div/div/div/dl[1]/dd")).isDisplayed());
				 
		 //Print job ID on console	
			String s = driver.findElement(By.xpath("html/body/div[2]/div[2]/div[1]/div[1]/div/div/div/dl[1]/dd")).getText();
			System.out.println(s);
					
	}
	 
}
