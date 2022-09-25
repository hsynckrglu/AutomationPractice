import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class actions {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\huseyin.cakiroglu\\Documents\\BrowserDriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		Thread.sleep(3000);

		driver.findElement(By.xpath("(//span[@class='a-button-inner'])[1]")).click();

		// Actions classından bir nesne oluşturuyorum 
		Actions a = new Actions(driver);
	
		/* bu şekilde tanımlarsam farenin imleci o btanımladığım şeyin üstüne gelir. */
		a.moveToElement(driver.findElement(By.id("nav-link-accountList-nav-line-1"))).build().perform();
		
		/* önce aramaya bastık sonra shifte basılı tuttuk 
		 * sonra hello yazdık iki tıklama yaptık yazdığımızı seçtik 
		 * build yap demek ve perform da aynı şekilde klasik oluyor hep */
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT)
		.sendKeys("hello").doubleClick().build().perform();
		Thread.sleep(1000);
		//contextClick ile sağ tık yapılıyor
		a.moveToElement(driver.findElement(By.id("nav-link-accountList"))).contextClick().build().perform();
		

	}
}
