package week4.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CountRc {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://html.com/tags/table/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Getting the count of number of rows
		List<WebElement> rowsCount = driver.findElements(By.xpath("//table[@class='attributes-list']//tr"));
		System.out.println("No. of Rows: "+ rowsCount.size());

		// Getting the count of number of Columns
		List<WebElement> colCount = driver.findElements(By.xpath("//table[@class='attributes-list']//tr[2]/td"));
		System.out.println("No. of Columns: "+ colCount.size());


	}

}
