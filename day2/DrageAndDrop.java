package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DrageAndDrop {

	public static void main(String[] args) {
	
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.leafground.com/drag.xhtml");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Finding the element to drag
		WebElement drag = driver.findElement(By.xpath("//span[text()='Drag and Drop']"));
		int x = drag.getLocation().getX();
		int y = drag.getLocation().getY();
		System.out.println("x: "+x+" y: "+y);
		Actions ac = new Actions(driver);
		ac.dragAndDropBy(drag, 400,0).perform();
		System.out.println(drag.getLocation().getX());
		System.out.println(drag.getLocation().getY());

        WebElement source = driver.findElement(By.xpath("//p[text()='Drag to target']"));
        WebElement dest = driver.findElement(By.xpath("//p[text()='Drop here']"));

        Actions ac1 =new Actions(driver);
        ac1.dragAndDrop(source, dest).perform();
        System.out.println(dest.getText());

	}

}
