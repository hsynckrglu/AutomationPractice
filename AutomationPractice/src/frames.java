import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class frames {
	
	public static void main(String[] args) {
		
	/* bir tane çerçevem frame var. Bu frame sürükle ve bırak yapıcam.
	 * ilk önce frame tanımlıyorum. (tagname= iframe olanlar) 
	 * syntax --> driver.switchto().frame(ister yolunu yaz ister index yaz ama index pek tavsiye edilmiyor)
	 * index neden tavsiye ediilmiyor? geliştirici frame ekleyebilir ilerleyen zamanlarda.
	 * sonra actions tanımladım çünkü sürükle ve bırak işlemi var. 
	 * syntaxı--> a.dragAndDrop(source,target).build().perform();
	 * source ve targeti tanımladım yolunu yazdım
	 * 
		driver.switchTo().defaultContent(); ile frameden çıkıp aynı sayfada işlemler yapabilirim. */	
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\huseyin.cakiroglu\\Documents\\BrowserDriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://jqueryui.com/droppable/");
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
		
		Actions a= new Actions(driver);
		//source--> kaynak  target-->hedef
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		a.dragAndDrop(source, target).build().perform(); 
		
		driver.switchTo().defaultContent(); // frameden çıkıp sayfada işlemler yapabilir.
		
	}

}
