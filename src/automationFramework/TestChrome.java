package automationFramework;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;

import java.io.IOException;

import org.apache.commons.io.FileUtils;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestChrome {

	@Test
	public void test() {

    	
    	//Define driver
    	WebDriver driver = new ChromeDriver();
    	
    	// 1. Open “omada.net”
		driver.get("https://www.omada.net/");
		
		// Maximize window
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		// Find a main image
		driver.findElement(By.xpath("//div[2]/div/div[1]/a/img"));
		
		// 2. Execute search for “gartner” (using search box in the top right corner of the front page)
		driver.findElement(By.xpath("//div[2]/div/div[3]/form/input")).sendKeys("gartner");
		driver.findElement(By.xpath("//div[2]/div/div[3]/form/input")).sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS); 
		
		// Verified if second element in search exist
		driver.findElement(By.xpath("//*[@id=\"brick-411\"]/div/div/section[2]/a"));
		
		// Verified if page contain text
		if(driver.getPageSource().contains("There is Safety in Numbers"))
			{
				System.out.println("Page Contain text Test Pass");
			}

		else
			{
				System.out.println("Page DOES NOT contain text Test Fail");
				// fail("Page DOES NOT contain text Test Fail");
			}
		
		// 3. Click on the link “Gartner IAM Summit 2016 - London”
		driver.findElement(By.xpath("//*[@id=\"brick-43\"]/div/div[2]/span")).click();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[2]/div/div/div/section[6]/a")).click();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		
		// Verified if page contain text
		if(driver.getPageSource().contains("Gartner IAM Summit 2016 - London"))
			{
				System.out.println("Page Contain text Test Pass");
			}

		else
			{
				System.out.println("Page DOES NOT contain text Test Fail");
				fail("Page DOES NOT contain text Test Fail");
			}
		
		// 4. Navigate to News
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.xpath("//*[@id=\"navigation\"]/ul/li[4]/a"));
		action.moveToElement(we).build().perform();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		
		//Click 
		driver.findElement(By.xpath("//*[@id=\"navigation\"]/ul/li[4]/a")).click();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[3]/section/a")).click();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"brick-10535\"]/div/div/div/div/div[3]/section/a/section/h1")).click();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		//driver.findElement(By.xpath("//li[4]/div/ul/div[3]/div[2]/a")).click();
		//driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		
		// Verified if page contain text
		if(driver.getPageSource().contains("Gartner IAM Summit 2016 - London"))
			{
				System.out.println("Page Contain text Test Pass");
			}

		else
			{
				System.out.println("Page DOES NOT contain text Test Fail");
				fail("Page DOES NOT contain text Test Fail");
			}
		
		// 5. Go to the home page
		
		//Click 
		driver.findElement(By.xpath("//div[2]/div/div[1]/a/img")).click();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//div[1]/div[2]/ul/li[1]/a")).click();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@id=\"brick-3475\"]/div/div/div[1]/span[3]")).click();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	
		
		// Take screenshot and store as a file format - screenshot before
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try 
		{
			FileUtils.copyFile(src, new File("C:/selenium/USWEST.png"));
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
		
		//Hover Mouse on some element
		WebElement we2 = driver.findElement(By.xpath("//*[@id=\"navigation\"]/ul/li[3]/a"));
		action.moveToElement(we2).build().perform();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		
		// Take screenshot and store as a file format - screenshot after
		File src2= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try 
			{
				FileUtils.copyFile(src2, new File("C:/selenium/After.png"));
			}
		catch (IOException e)
			{
				System.out.println(e.getMessage());
			}

		
		// Close window
		driver.close();
	}

}
