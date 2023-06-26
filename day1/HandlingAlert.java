package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingAlert {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/alert.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
		// ~~~~~~~~~~~~(1) Alert Simple Dialog~~~~~~~~~~~~~~~~~~
		driver.findElement(By.xpath("//span[text()='Show']")).click();
		
		// Handling Alert
		Alert alert = driver.switchTo().alert();
		System.out.println("1. "+ alert.getText());
		alert.accept();

		// Verifying the Alert is Clicked
		String text = driver.findElement(By.id("simple_result")).getText();
		System.out.println(text);
		System.out.println("----------------------------");
		
		
		// ~~~~~~~~~~~~(2) Alert Conform Dialog~~~~~~~~~~~~~~~~~~
		driver.findElement(By.xpath("(//span[text()='Show'])[2]")).click();
		
		// Handling Alert
		Alert alert2 = driver.switchTo().alert();
		System.out.println("2. "+ alert2.getText());
		alert2.accept();
		String text2 = driver.findElement(By.id("result")).getText();
		System.out.println(text2);
		System.out.println("----------------------------");
		
		
		// ~~~~~~~~~~~~(3) Sweet Alert (Simple Dialog)~~~~~~~~~~~~~~~~~~
		driver.findElement(By.xpath("(//span[text()='Show'])[3]")).click();
		String text3 = driver.findElement(By.xpath("//div[contains(@class,'ui-dialog-content ')]/p")).getText();
		System.out.println("3. "+ text3);
		driver.findElement(By.xpath("//span[text()='Dismiss']")).click();
		System.out.println("----------------------------");
		
		
		// ~~~~~~~~~~~~(4) Sweet Modal Dialog~~~~~~~~~~~~~~~~
		driver.findElement(By.xpath("(//span[text()='Show'])[4]")).click();
		String text4 = driver.findElement(By.xpath("(//div[contains(@class,'ui-dialog-content ')]/p)[2]")).getText();
		System.out.println("4. "+text4);
		driver.findElement(By.xpath("(//span[@class='ui-icon ui-icon-closethick'])[2]")).click();
		driver.findElement(By.xpath("(//div[contains(@class,'ui-draggable-handle')])[2]/a")).click();
		// driver.executeScript("arguments[0].click();",clickLogo);
		System.out.println("----------------------------");

		
		// ~~~~~~~~~~~~(5) Alert (Prompt Dialog)~~~~~~~~~~~~~~~~
		driver.findElement(By.xpath("(//span[text()='Show'])[5]")).click();
		Alert alert3 = driver.switchTo().alert();
		System.out.println("5. "+ alert3.getText());
		alert3.sendKeys("Avinash P.R.");
		alert3.accept();
		String text5 = driver.findElement(By.id("confirm_result")).getText();
		System.out.println(text5);
		System.out.println("----------------------------");


		// ~~~~~~~~~~~~(6) Sweet Alert (Confirmation)~~~~~~~~~~~~~~~~
		driver.findElement(By.xpath("//span[text()='Delete']")).click();
		driver.findElement(By.xpath("//span[text()='Yes']")).click();		
//		driver.findElement(By.xpath("//span[text()='No']")).click();	
		System.out.println("6. Delete button handled");
		System.out.println("----------------------------");


		// ~~~~~~~~~~~~(7) Minimize and Maximize~~~~~~~~~~~~~~~~
		driver.findElement(By.xpath("//h5[text()='Minimize and Maximize']/following-sibling::button")).click();
		System.out.println("7. "+ driver.findElement(By.xpath("(//p[@class='m-0'])[2]")).getText());
		driver.findElement(By.xpath("(//a[@aria-label='Close'])[3]")).click();
		driver.findElement(By.xpath("(//a[@aria-label='Close'])[3]")).click();
		System.out.println("----------------------------");

	}

}
