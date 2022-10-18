package test;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown {
	
	public static void main(String[] args) throws InterruptedException {
	
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://trytestingthis.netlify.app/");
		WebElement dropdown =  driver.findElement(By.id("option"));
		Select selectobject = new Select(dropdown);
		
		selectobject.selectByIndex(1);
		Thread.sleep(1000);
		selectobject.selectByValue("option 2");
		Thread.sleep(1000);
		selectobject.selectByVisibleText("Option 3");
		
		List<WebElement> alloption = selectobject.getOptions();
		
		for(WebElement option : alloption) {
			System.out.println(option.getText());			
		}
		
		Thread.sleep(2000);
		
		driver.quit();
		System.out.println("Done");
	}
}
