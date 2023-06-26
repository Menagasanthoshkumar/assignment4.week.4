package week4.day1;

import java.awt.List;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingFrame {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/frame.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		//~~~~~~~~~~~~~~~~~Click Me (Inside frame)~~~~~~~~~~~~~~~~~~~~~~
		//Handling Frame
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//button[text()='Click Me']")).click();
		String text = driver.findElement(By.xpath("//button[text()='Hurray! You Clicked Me.']")).getText();
		System.out.println(text);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");		
		// Switching control back to main window
		driver.switchTo().defaultContent();		

		
		//~~~~~~~~~~~~~~~~~How many frames in this page?~~~~~~~~~~~~~~~~~~~~~~
		List findElements = (List) driver.findElements(By.tagName("iframe"));
		System.out.println(findElements.size());
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");		
		
		
		//~~~~~~~~~~~~~~~~~Click Me (Inside Nested frame)~~~~~~~~~~~~~~~~~~~~~~
		// Handling Frame
		driver.switchTo().frame(2);
		driver.switchTo().frame("frame2");
		driver.findElement(By.xpath("//button[@id='Click']")).click();
		System.out.println(driver.findElement(By.xpath("//button[text()='Hurray! You Clicked Me.']")).getText());
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");		

	}

}
