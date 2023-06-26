package week4.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Selectable {

	public static void main(String[] args) {
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/selectable/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		// Handling Frame
		driver.switchTo().frame(0);

		List<WebElement> items = driver.findElements(By.xpath("//ol[@id='selectable']/li"));
		System.out.println(items.get(6).getText());
		Actions ac = new Actions(driver);
		ac.keyDown(Keys.CONTROL).click(items.get(0)).click(items.get(2)).click(items.get(6)).click(items.get(4)).click(items.get(5)).click(items.get(6)).keyUp(Keys.CONTROL).perform();


	}

}
