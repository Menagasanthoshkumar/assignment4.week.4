package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Nykaa {

	public static void main(String[] args) {
		
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.nykaa.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//	Mouseover on Brands and Search L'Oreal Paris
		// Finding the element: Brand
		WebElement tabBrands = driver.findElement(By.xpath("//a[text()='brands']"));
		Actions ac = new Actions(driver);
		ac.moveToElement(tabBrands).perform();

		//	Click L'Oreal Paris
		driver.findElement(By.xpath("(//a[contains(text(),'Oreal Paris')])[2]")).click();
		// (//a[contains(text(),\"L'Oreal Paris\")])[2]
		// (//a[contains(text(),\"L'Oreal Paris\")])[2]
		//	Check the title contains L'Oreal Paris(Hint-GetTitle)
		String title = driver.getTitle();
		System.out.println(title);

		if (title.contains("L'Oreal Paris")) {
			System.out.println("You landed on the right page");
		}
		else 
			System.out.println("You landed on the wrong page");		

		//	Click sort By and select customer top rated
		driver.findElement(By.xpath("//button[contains(@class,'css-1aucgde')]")).click();
		driver.findElement(By.xpath("//ul[@class='css-z5o5ca']/div[4]")).click();		

		//	Click Category and click Hair->Click haircare->Shampoo
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		driver.findElement(By.xpath("(//span[text()='Hair Care'])[2]")).click();
		driver.findElement(By.xpath("//span[text()='Shampoo']")).click();

		//	Click->Concern->Color Protection
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		driver.findElement(By.xpath("//span[text()='Color Protection']")).click();

		//	check whether the Filter is applied with Shampoo
		WebElement shampooChkBox = driver.findElement(By.xpath("//div[contains(@class,'control-indicator checkbox active')]"));
		String shampooConfirmation = shampooChkBox.getAttribute("class");
		if(shampooConfirmation.contains("active")) {
			System.out.println("Shampoo filter is applied");
		}
		else
			System.out.println("Shampoo filter not applied");

		//	Click on L'Oreal Paris Colour Protect Shampoo
		driver.findElement(By.xpath("(//div[@class='product-listing']//div[contains(@class,'productWrapper')])[1]")).click();

		//	GO to the new window and select size as 175ml
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> chWindow = new ArrayList<String>(windowHandles);
		driver.switchTo().window(chWindow.get(1));
		driver.findElement(By.xpath("//span[text()='180ml']")).click();

		//	Print the MRP of the product
		String price = driver.findElement(By.xpath("(//span[text()='MRP:']/following-sibling::span)[1]")).getText();
		System.out.println(price);

		//	Click on ADD to BAG
		driver.findElement(By.xpath("(//span[text()='Add to Bag'])[1]")).click();

		//	Go to Shopping Bag 
		driver.findElement(By.xpath("//button[@class='css-aesrxy']")).click();

		//	Print the Grand Total amount
		String gTot = driver.findElement(By.xpath("( //div[contains(@class,'footer-layout')]//span)[1]")).getText();
		System.out.println(gTot);

		//	Click Proceed
		driver.findElement(By.xpath("//span[text()='Proceed']")).click();

		driver.findElement(By.xpath("//button[text()='Continue as guest']")).click();

		driver.quit();

	}

}
