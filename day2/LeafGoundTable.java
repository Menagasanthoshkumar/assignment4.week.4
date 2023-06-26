package week4.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeafGoundTable {

	public static void main(String[] args) {
	
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://leafground.com/table.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		List<WebElement> countries = driver.findElements(By.xpath("//tbody[@class='ui-datatable-data ui-widget-content']//td[1]"));
		System.out.println(countries.size());

		for(WebElement i : countries ) {
			System.out.println(i.getText());	

	}
	}

}
