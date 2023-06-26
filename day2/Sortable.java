package week4.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Sortable {

	public static void main(String[] args) {
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/sortable/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		// Handling Frame
		driver.switchTo().frame(0);

		List<WebElement> items = driver.findElements(By.xpath("//ul[@id='sortable']/li"));
		System.out.println(items.get(6).getText());
		Actions ac = new Actions(driver);
		ac.dragAndDropBy(items.get(0), 0, 100).perform();

	}

}
