package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Draggable {

	public static void main(String[] args) {
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Handling the frame
		driver.switchTo().frame(0);	

		WebElement source = driver.findElement(By.xpath("//p[text()='Drag me to my target']"));
		WebElement dest = driver.findElement(By.xpath("//p[text()='Drop here']"));

        Actions ac1 =new Actions(driver);
        ac1.dragAndDrop(source, dest).perform();
        System.out.println(dest.getText());
		

	}

}
