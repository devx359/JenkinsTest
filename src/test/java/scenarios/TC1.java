package scenarios;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC1 {
	
	WebDriver driver;
	
	@Test(priority=1)
	public void setup()
	{
		//System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_88.exe");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_88");
		driver = new ChromeDriver();
	}
	
	@Test(priority=2)
	public void doshit() throws InterruptedException
	{
		driver.get("https://www.google.com/");
		Thread.sleep(2000);
		System.out.println("Inside test do shit");
	}
	
	@Test(priority=3)
	public void teardown()
	{
		driver.quit();
	}

}
