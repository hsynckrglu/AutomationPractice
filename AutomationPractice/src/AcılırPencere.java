import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AcılırPencere {

	public static void main(String[] args) {
		
		//pop-up --> açılır pencere, web sayfasındaki mesajları ifade eder.
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\huseyin.cakiroglu\\Documents\\BrowserDriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String name = "Hüseyin";
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.cssSelector("input[placeholder='Enter Your Name']")).sendKeys(name);
		driver.findElement(By.cssSelector("[id='alertbtn']")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept(); //pop-up
		driver.findElement(By.cssSelector("input[placeholder='Enter Your Name']")).sendKeys(name);
		driver.findElement(By.id("confirmbtn")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();
		
		
	}
}
