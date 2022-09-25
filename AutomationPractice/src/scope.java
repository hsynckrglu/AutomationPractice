import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class scope {
	
	/* burada sayfadaki link sayısını daha sonra alt başlıkta bulunan linklerin sayısını daha sonra da altbaşlıktaki ilk sütundaki
	 * linklerin sayısını konsola yazdırdım.
	 * Daha sonra for döngüsü ile bu altbaşlığın ilk sütunundaki linkleri sırasıyla yeni sekmede açılıp açılmadığını test ettim
	 * sonra while(it.hasNext()) ile tekrar döngüye soktum ve parentID childId gibi seleniumda sayfalar arasında geçiş yapıp 
	 * tittle isimlerini aldım.
	 * Normalde 4 tane linktext var diyelim bunların yollarını cssSelector ya da xpath ile tanımlayabilirdim
	 * ama geliştirici bunları ekleyebilir silebilir. bugün çalışan şey yarın çalışmaz lonumu bulamaaz
	 * ama ben bunu dinamik hale getirdim ve isimlerinin olup olmamasına bağlı olmadan kaç tane ise döngüye sokup 
	 * başlık isimlerini olsun linklerin açılmasını yaptım otomotize olarak. 
	 * sabit kodlama değerleri olmadan dinamik testler yazdım*/

	public static void main(String[] args) throws InterruptedException {
		

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\huseyin.cakiroglu\\Documents\\BrowserDriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		WebElement foodDriver = driver.findElement(By.id("gf-BIG"));
		System.out.println(foodDriver.findElements(By.tagName("a")).size());
		
		WebElement coloumnDriver=foodDriver.findElement(By.xpath("//div/table/tbody/tr/td[1]/ul"));
		System.out.println(coloumnDriver.findElements(By.tagName("a")).size());
		
		for(int i =1; i<coloumnDriver.findElements(By.tagName("a")).size();i++ ) {
			String clickonlinkTab=Keys.chord(Keys.CONTROL,Keys.ENTER);
			coloumnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinkTab);
				Thread.sleep(4000);
			
			
		}
		Set<String> windows =driver.getWindowHandles();
		Iterator<String> it =windows.iterator();
		
		while(it.hasNext()) {
			//it nesnesinin hala olup olmadığını haasNext() ile test ediyorum.Varsa true döner ve döngüye girer.
			
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
			
		}
	}

}
