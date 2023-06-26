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
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Myntra {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.myntra.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		WebElement mens = driver.findElement(By.xpath("(//a[text()='Men'])[1]"));
		Actions builder = new Actions (driver);
		builder.moveToElement(mens).perform();
		driver.findElement(By.xpath("(//a[text()='Jackets'])[1]")).click();
		String text = driver.findElement(By.xpath("//span[@class='title-count']")).getText();
		System.out.println("Jackets for mens : " +text);
		String text1 = driver.findElement(By.xpath("(//span[@class='categories-num'])[1]")).getText();
		System.out.println("Jackets for mens : " +text1);
		String text2 = driver.findElement(By.xpath("(//span[@class='categories-num'])[2]")).getText();
		System.out.println("Jackets for mens : " +text2);
		if(text.equals(text1+text2)) {
			System.out.println("validation : Matches with individual count");
		}
		else {
			System.out.println("validation : Does not match with individual count");
		}
		driver.findElement(By.xpath("//label[text()='Jackets']")).click();
		driver.findElement(By.xpath("//div[@class='brand-more']")).click();
		driver.findElement(By.xpath("//input[@class='FilterDirectory-searchInput']")).sendKeys("Duke");
		driver.findElement(By.xpath("(//label[@class=' common-customCheckbox'])[1]")).click();
		driver.findElement(By.xpath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']")).click();

		List<WebElement> Duke = driver.findElements(By.xpath("//div[@class='product-productMetaInfo']/h3[text()='Duke']"));
		for (int i = 0; i <= Duke.size()-1; i++) {
			System.out.println(Duke.get(i).getText());
			if((Duke.get(i).getText()).contains("Duke")) {
				System.out.println("Verification : All are from Duke");
			}
			else {
				System.out.println("Verification : All are not from Duke");
			}
		}
		driver.findElement(By.xpath("//label[text()='50% and above']")).click();
		String text3 = driver.findElement(By.xpath("//span[@class='product-discountedPrice']")).getText();
		System.out.println("Price of first displayed item : " + text3);

		driver.findElement(By.xpath("//img[@title='Duke Men Black Self Design Padded Jacket']")).click();
		Set<String> duke = driver.getWindowHandles();
		List<String> dukewindow =new ArrayList<String>(duke);
		driver.switchTo().window(dukewindow.get(1));

		File source = driver.getScreenshotAs(OutputType.FILE);
		File destination = new File("snap/duke.png");
		FileUtils.copyFile(source,destination);

		driver.findElement(By.xpath("//span[text()='WISHLIST']")).click();
		Thread.sleep(5000);
		driver.quit();

	}

}
