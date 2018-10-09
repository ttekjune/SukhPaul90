package batman;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Robin {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/Users/sukhsingh/Desktop/SeleniumMaven1/Driver/chromedriver");
		System.setProperty("webdriver.firefox.driver", "geckodriver.exe");

		WebDriver driver1 = new ChromeDriver();
		driver1.get("http://newtours.demoaut.com/");
		driver1.manage().window().maximize();
		driver1.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement userName = driver1.findElement(By.name("userName"));
		userName.sendKeys("Admin");
		WebElement password = driver1.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys("12345");
		WebElement signIn = driver1.findElement(By.xpath("//*[contains(@name,'login')]"));
		signIn.click();
		Thread.sleep(5000);
		String actualUrl = driver1.getCurrentUrl();
		System.out.println("Actual URL: " + actualUrl);
		String expectedUrl = "http://newtours.demoaut.com/mercurysignon.php?osCsid=9f71e54bf8cf7862561dd8720d6078a2";
		System.out.println("Ecpected URL: " + expectedUrl);
		WebElement text = driver1.findElement(By.xpath(
				"/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p/font/b"));
		String str = text.getText();
		System.out.println(str);
		String expectedText = "Welcome back to Mercury Tours!";
		if (actualUrl.contains("http://newtours.demoaut.com/mercurysignon.php?")) {
			System.out.println("PASSED!");
		} else {
			System.out.println("FAILED!");
		}

		driver1.close();
		/*
		 * driver1 = new FirefoxDriver();
		 * driver1.get("https://www.ups.com/us/en/global.page"); Thread.sleep(3000);
		 * Thread.sleep(3000); driver1.get("https://www.google.com/"); driver1.quit();
		 * username - ttekjune
		 * pass - talentech123
		 * email- email.juel@gmail.com
		 */

	}

}