package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Amazon {

	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("oneplus 9 pro");
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		driver.getWindowHandle();
		String text = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
		System.out.println(text);
		driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-fixed-height'])[1]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> lstwindow=new ArrayList<String>(windowHandles);
		driver.switchTo().window(lstwindow.get(1));
		System.out.println(driver.getTitle());
		String text2 = driver.findElement(By.xpath("(//span[text()='6 ratings'])[1]")).getText();
		System.out.println(text2);
		Actions Builder=new Actions(driver);
		WebElement findElement = driver.findElement(By.xpath("(//a[@class='a-popover-trigger a-declarative'])[1]"));
		Builder.click(findElement).perform();
		Thread.sleep(2000);
		String text3 = driver.findElement(By.xpath("(//a[@class='a-size-base a-link-normal'])[4]")).getText();
		System.out.println(text3);
		WebElement findElement2 = driver.findElement(By.xpath("//img[@id='landingImage']"));
		Builder.doubleClick(findElement2).perform();
		driver.switchTo().frame(0);
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		File dest=new File("./snapshot/Onepluspro.png");
		FileUtils.copyFile(screenshotAs, dest); 
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath(" //button[@class=' a-button-close a-declarative a-button-top-right']")).click();
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		String text4 = driver.findElement(By.xpath("//span[@id='attach-accessory-cart-subtotal']")).getText();
		System.out.println(text4);
		if (text.equals(text4)) {
			System.out.println("Price are same");
		}
		else {
			System.out.println("Price are different");
		}

	}

}
