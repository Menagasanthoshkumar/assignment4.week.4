package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandingWindow {

	public static void main(String[] args) {
	
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/window.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		System.out.println(driver.getTitle());

		// (1)~~~~~~"OPEN" BUTTON~~~~~~~~~~
		driver.findElement(By.xpath("//span[text()='Open']")).click();

		// Handling Window

		// Switching control to child window
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> chWindow = new ArrayList<String>(windowHandles);
		driver.switchTo().window(chWindow.get(1));	
		// System.out.println(driver.getTitle());
		if (driver.getTitle().contains("Dashboard")) {
			System.out.println("New Window is opened - Window Name: Dashboard");
		}
		else 
			System.out.println("The Button doesn't work");
		driver.close();

		// Switching control back to parent
		driver.switchTo().window(chWindow.get(0));		
		System.out.println(driver.getTitle());

		// (2)~~~~~~"OPEN MULTIPLE" BUTTON~~~~~~~~~~
		driver.findElement(By.xpath("//span[text()='Open Multiple']")).click();

		//Handling Windows

		// Switching back to child window
		Set<String> windowHandles3 = driver.getWindowHandles();
		List<String> chWindow1 = new ArrayList<String>(windowHandles3);
		System.out.println(chWindow1.size());
		driver.switchTo().window(chWindow1.get(1));
		driver.close();
		driver.switchTo().window(chWindow1.get(2));
		driver.close();

		// Switching Control back to Parent window
		driver.switchTo().window(chWindow1.get(0));

		// (3)~~~~~~"CLOSE WINDOWS" BUTTON~~~~~~~~~~
		driver.findElement(By.xpath("//span[text()='Close Windows']")).click();

		// Handling Windows
		
		// Switching control to child  window
		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String> chWindow2 = new ArrayList<String>(windowHandles2);
		driver.switchTo().window(chWindow2.get(1));
		driver.close();
		driver.switchTo().window(chWindow2.get(2));
		driver.close();
		driver.switchTo().window(chWindow2.get(3));
		driver.close();
		
		// Switching Control back to Parent window
		driver.switchTo().window(chWindow2.get(0));

		// (4)~~~~~~"OPEN WITH DELAY" BUTTON~~~~~~~~~~
		driver.findElement(By.xpath("//span[text()='Open with delay']")).click();
		driver.quit();
	
		
		

	}

}
