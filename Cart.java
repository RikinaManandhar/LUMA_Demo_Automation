package finalproject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Cart extends BasicSetup{
	
	 @Test
     public static void add_to_cart() {
		 
		//logging in before adding into cart
	    driver.findElement(By.xpath("(//li[@class=\"authorization-link\"])[1]")).click();
		driver.findElement(By.id("email")).sendKeys("bpnmhr@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("123qweQ@");
		driver.findElement(By.name("send")).click();
		
		//clicking on womens section and top option
	    driver.findElement(By.xpath("(//span[@class='ui-menu-icon ui-icon ui-icon-carat-1-e'])[1]")).click();
	    driver.findElement(By.xpath("//a[text()='Tops']")).click();
	    
	    // Finding the element to hover over
        WebElement hoverElement = driver.findElement(By.xpath("(//li[@class='item product product-item'])[5]"));
        
        // Create Actions object to simulate mouse hover
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverElement).perform();
        
        //Select size
        WebElement size = driver.findElement(By.xpath("(//div[text()='M'])[5]"));
        size.click();
        
        //Select colour
        WebElement colour = driver.findElement(By.xpath("(//div[@id='option-label-color-93-item-57'])[3]"));
        colour.click();
        
        // Find the button that appears after hover
        WebElement buttonAfterHover = driver.findElement(By.xpath("(//button[@class='action tocart primary'])[5]"));
        
        // Click on the button
        buttonAfterHover.click();
        
        //clicking on cart
		driver.findElement(By.xpath("//a[@class='action showcart']")).click();
		driver.findElement(By.xpath("//button[@id='top-cart-btn-checkout']")).click();
     }
	 
	 @Test
	 public static void checkout() throws InterruptedException {
		 

		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 //wait until the filed is displayed
	   	WebElement inputField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@class='input-text'])[5]")));
		inputField.sendKeys("company");
		 driver.findElement(By.xpath("(//input[@class='input-text'])[6]")).sendKeys("thimi siwatole");
		 driver.findElement(By.xpath("(//input[@class='input-text'])[7]")).sendKeys("bhaktapur");
		 driver.findElement(By.xpath("(//input[@class='input-text'])[8]")).sendKeys("nepal");
		 driver.findElement(By.xpath("(//input[@class='input-text'])[9]")).sendKeys("thimi");
		 
		 //Dropdown menu 
		 WebElement regiondropdown = driver.findElement(By.xpath("(//select[@class='select'])[1]"));
		 Select select= new Select(regiondropdown);
		 select.selectByContainsVisibleText("Utah");
		 
		 driver.findElement(By.xpath("(//input[@class='input-text'])[11]")).sendKeys("12345");
         
		 //Dropdown menu
		 WebElement countrydropdown = driver.findElement(By.xpath("(//select[@class='select'])[2]"));
		 Select select1= new Select(countrydropdown);
		 select1.selectByContainsVisibleText("Thailand");
		 
		 driver.findElement(By.xpath("(//input[@class='input-text'])[12]")).sendKeys("0099876543");
		 
		 //for the radiobutton
		 WebElement radioButton = driver.findElement(By.xpath("//input[@type='radio']"));
		 radioButton.click();
		 Thread.sleep(3000);
		 
		 //reselecting the radiobutton
		 WebElement radioButton2 = driver.findElement(By.xpath("//input[@type='radio']"));
		 radioButton2.click();

		 
		 //try catch to see whether the button is clicked or not
		 try {
	            WebElement nextButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-role='opc-continue']")));
//	   		 driver.findElement(By.xpath("(//input[@class='radio'])[1]")).click();

	            
//	            Thread.sleep(10000);
	            nextButton.click();
	            System.out.println("Successfully clicked the Next button.");
	        } catch (Exception e) {
	            System.out.println("Failed to click the Next button. Error: " + e.getMessage());}
		 
		
		 WebElement placeOrderButton = driver.findElement(By.xpath("//button[@class='action primary checkout']"));
		 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", placeOrderButton);
		 Thread.sleep(1000); // Add a short delay to ensure it's in view
		 placeOrderButton.click();

	 }
}
