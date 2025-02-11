package finalproject;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicSetup {
	
	public static String url="https://magento.softwaretestingboard.com/";//URL of the website
	public static ChromeDriver driver;
	
	//BeforeSuite runs automatically at the very beginning 
	@BeforeSuite
	public static void navigationtolandingpage() {
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
		driver.get(url);//Opening "url"
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//wait for 10 sec to load
		driver.manage().window().maximize();// maximizing the window
	}
	
	
	//AfterSuite automatically runs at the very end
	@AfterSuite
	public static void end() throws InterruptedException {
		Thread.sleep(10000);
		driver.close();
	}
}
