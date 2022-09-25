import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class calenderDinamicPractice {
	//hatalı 

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\huseyin.cakiroglu\\Documents\\BrowserDriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.path2usa.com/travel-companion/");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		
		Thread.sleep(3000);

		driver.findElement(By.id("form-field-travel_comp_date")).click();

		while (!driver.findElement(By.cssSelector("span[class='cur-month']")).getText().contains("November")) {
			driver.findElement(By.xpath("//span[@class='flatpickr-next-month']//*[name()='svg']")).click();
			if(driver.findElement(By.cssSelector("span[class='cur-month']")).getText().contains("November")) {
				break;
			}
	}
		Thread.sleep(2000);
		List<WebElement> days=driver.findElements(By.cssSelector("div[class='dayContainer']"));
System.out.println(days.size());
		for(int i=0;i<days.size();i++) {
			String daysNumber=days.get(i).getText();
			if(daysNumber.equalsIgnoreCase("28")) {
				days.get(i).click();
				break;
			}
		}
	}
}
