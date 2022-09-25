import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class javaScriptExecutor {

	public static void main(String[] args) throws InterruptedException {
		/*sayfa içinde aşağıda kalan alanlarda herhangi bir sayfa var diyelim. o butonda işlem yapmak istiyoruz 
		ama bulamaz selenium onu hata verir testimizde ne yapıcaz sayfayı aşağı kaydırıcaz 
		 */
		
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\huseyin.cakiroglu\\Documents\\BrowserDriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//syntax
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,814)");
		
		Thread.sleep(2500);
		//syntaxı --> document.querySelector('').scrollTop=sayı  
//		burada ben sayfanın içindeki tabloyu aşağı yaptım
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=50");
		
		List<WebElement> values =driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		int sum = 0;
		for(int i=0;i<values.size();i++) {
			//Integer.parseInt() ile string ifadeyi integere çevirdim.
		sum= sum +	Integer.parseInt(values.get(i).getText());
			
		}
		System.out.println("tablodaki toplam değer: "+sum);
		int total=Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim()) ;
		Assert.assertEquals(sum, total);
	}
	
}
