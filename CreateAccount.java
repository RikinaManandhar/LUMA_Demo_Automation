package finalproject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class CreateAccount extends BasicSetup{
	
	@Test
	public static void navigate_to_signup(){
		driver.findElement(By.xpath("(//a[text()='Create an Account'])[1]")).click();
	}
	
	
	@Test
	public static void signup_form_fillup() throws InterruptedException{
		
		//Filling up every input field 
		driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("first");
		driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("last");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("email322@gmail.com");
		driver.findElement(By.xpath("(//input[@name='password'])[1]")).sendKeys("123#45abc@");
		driver.findElement(By.xpath("//input[@name='password_confirmation']")).sendKeys("123#45abc@");

        
		WebElement button = driver.findElement(By.xpath("//button[span[text()='Create an Account']]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);//scrolling to make the button visible 
		Thread.sleep(500);  //Small delay to ensure scrolling completes
		button.click();
	}
}
