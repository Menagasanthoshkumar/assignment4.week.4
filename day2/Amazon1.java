package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Amazon1 {

	public static void main(String[] args) throws IOException {
		
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		//	2.search as oneplus 9 pro 
		// Finding the search bar and searching "oneplus 9 pro"
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("oneplus 9 pro",Keys.ENTER);
		
		//	3.Get the price of the first product
		String text = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
		System.out.println("Price of the first product: "+ text);
		
		//	4. Print the number of customer ratings for the first displayed product
		String text2 = driver.findElement(By.xpath("(//span[@class='a-size-base s-underline-text'])[1]")).getText();
		System.out.println("Number of Customer ratings: "+ text2);

		//	5. Mouse Hover on the stars
		WebElement review = driver.findElement(By.xpath("//i[@class='a-icon a-icon-popover']"));
		review.click();
		Actions ac = new Actions(driver);
		ac.moveToElement(review).perform();
		driver.findElement(By.linkText("See all customer reviews")).click();
		
		//	6. Get the percentage of ratings for the 5 star.
		
//		String text3 = driver.findElement(By.xpath("//span[contains(@aria-label,'5 stars')]")).getText();
//		System.out.println("Percentage of ratings for 5 stars: " + text3);
		driver.navigate().back();
		
		//	7. Click the first text link of the first image
		driver.findElement(By.xpath("//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']//span")).click();
		
		//	8. Take a screen shot of the product displayed
		
		// Handling Window
		// Getting the window handles
		Set<String> windowHandles = driver.getWindowHandles();
		// Converting set into List
		List<String> chWindows = new ArrayList<String>(windowHandles);
		// Switching control to the child page
		driver.switchTo().window(chWindows.get(1));		
		
		// Take a Screenshot
		File souce = driver.getScreenshotAs(OutputType.FILE);
		// Create a folder for saving the file
		File dest = new File("snaps/amazon.png");
		// Merge source and destination
		FileUtils.copyFile(souce, dest);			
		
		//	9. Click 'Add to Cart' button
		driver.findElement(By.id("add-to-cart-button")).click();
		
		//	10. Get the cart subtotal and verify if it is correct.
		String text4 = driver.findElement(By.xpath("//span[@id='attach-accessory-cart-subtotal']")).getText();
		System.out.println(text4);
		System.out.println("!!!!!!!!!!!!");

		

	}

}
