package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class MergeContact {

	public static void main(String[] args) {
		
	//  1. Launch URL "http://leaftaps.com/opentaps/control/login"
			ChromeDriver driver = new ChromeDriver();
			driver.get("http://leaftaps.com/opentaps/control/login");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

			//  2. Enter UserName and Password Using Id Locator
			driver.findElement(By.id("username")).sendKeys("demosalesmanager");
			driver.findElement(By.id("password")).sendKeys("crmsfa");

			//	3. Click on Login Button using Class Locator
			driver.findElement(By.className("decorativeSubmit")).click();

			//	4. Click on CRM/SFA Link
			driver.findElement(By.partialLinkText("CRM/SFA")).click();

			//	5. Click on contacts Button
			driver.findElement(By.linkText("Contacts")).click();

			//	6. Click on Merge Contacts using Xpath Locator
			driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();

			//	7. Click on Widget of From Contact
			driver.findElement(By.xpath("//input[@id='partyIdFrom']/following-sibling::a")).click();
			
			String windowHandle = driver.getWindowHandle();
			System.out.println(windowHandle);
			System.out.println(driver.getTitle());
			
			//	8. Click on First Resulting Contact
			
			// Handling Window
			// Step 1: Getting window handles
			Set<String> windowHandles = driver.getWindowHandles();
			// Step 2: Converting Set to List
			List<String> chWindow = new ArrayList<String>(windowHandles);
			// Step 3: Switch control to a particular child window
			driver.switchTo().window(chWindow.get(1));	
			System.out.println(windowHandles);
			System.out.println(driver.getTitle());
			// Step 4: Clicking First Contact
			driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();

			
			
			//	9. Click on Widget of To Contact
			// Switching Control back to parent Window
			Set<String> windowHandles2 = driver.getWindowHandles();
			List<String> pWindow = new ArrayList<String>(windowHandles2);
			driver.switchTo().window(pWindow.get(0));		
			driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
			
			//	10. Click on Second Resulting Contact
			// Handling windows
			// Step 1: Getting window handles
			Set<String> windowHandles3 = driver.getWindowHandles();
			// Step 2: Converting Set to List		
			List<String> chWindow1 = new ArrayList<String>(windowHandles3);
			// Step 3: Switch to a particular child window
			driver.switchTo().window(chWindow1.get(1));
			
			driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]")).click();
			
			//	11. Click on Merge button using Xpath Locator
			// Switching Control back to the Parent window
			// Step 1 Getting the window handle and saving as Set
			Set<String> windowHandles4 = driver.getWindowHandles();
			// Step 2: Converting Set to List
			List<String> pWindow1 = new ArrayList<String>(windowHandles4);
			// Switching Control to back parent window
			driver.switchTo().window(pWindow1.get(0));
			
			driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
			
			//	12. Accept the Alert
	 		//accept alert
			Alert alert = driver.switchTo().alert();
			alert.accept();
			
			//	13. Verify the title of the page
			System.out.println(driver.getTitle());
			if(driver.getTitle().contains("View Contact")) {
				System.out.println("Correct Page");
			}
			else 
				System.out.println("Wrong Page");

		

	}

}
