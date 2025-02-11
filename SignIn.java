package finalproject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;


public class SignIn extends BasicSetup{
	
	@Test
	public static void login() {
		
		driver.findElement(By.xpath("(//li[@class=\"authorization-link\"])[1]")).click();//clicking on signin option

		//filling up the input fields
		driver.findElement(By.id("email")).sendKeys("email322@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("123#45abc@");
		driver.findElement(By.name("send")).click();
	}
	
	
	//method to search the items
	@Test
	public static void search() {
		driver.findElement(By.id("search")).sendKeys("hoodie");
        driver.findElement(By.id("search")).sendKeys(Keys.RETURN); //to press enter 


	}

}
