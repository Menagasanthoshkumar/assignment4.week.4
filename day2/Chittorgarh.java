package week4.day2;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chittorgarh {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.chittorgarh.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//		2. Click on stock market
		driver.findElement(By.xpath("//a[contains(text(),'STOCK')]")).click();

		//		3. Click on NSE bulk Deals
		driver.findElement(By.xpath("//a[text()='NSE Bulk Deals']")).click();

		//		4. Get all the Security names
		Set<String> fName = new HashSet<String>();
		List<WebElement> sNames = driver.findElements(By.xpath("//div[@id=\"report_data\"]//table//tbody/tr/td[1]"));
		for(WebElement i : sNames) {
			fName.add(i.getText());
		}
		System.out.println(fName);
		System.out.println(fName.size());

		


	}

}
