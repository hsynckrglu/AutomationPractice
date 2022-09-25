import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class windowHandles {
//yeni sekmeye geçiş sağlıyor bunu seleniuma bildiriyor
	public static void main(String[] args) {
		
		/* diyelimki bir web sayfası var ve bu sayfadaki linke basıp ikinci bir sekmeye açılıyor.
		 * bu sekmeye geçtiğimizi seleniuma bildirmemiz gerekiyor. aksi takdirde test başarısız olur.
		 * parentID(ilk açtığım sayfa) ve childId(açılan yeni sekme) .*/
		
		


		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\huseyin.cakiroglu\\Documents\\BrowserDriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		driver.findElement(By.cssSelector(".blinkingText")).click();
		
		Set<String> windows=driver.getWindowHandles(); //[parentID , childID,] eğer 3.sayfa olsaydı subchildID
		Iterator<String> it=windows.iterator();
		String parentID = it.next();
		String childID= it.next();
		driver.switchTo().window(childID);// childID sayfasında kal demek 
		
		System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
		//driver.findElement(By.cssSelector(".im-para.red")).getText();
		
		/* childID sayfasındaki kırmızı yazılı paragraftan maili almak istedim ve parentID sayfasındaki kullanıcı adı
		 * kısmına yazdırmak istedm otomotize şekilde. bunu yapabilmem için paragrafın yolunu cssSelectorle çektim
		 *  şu şekilde --> driver.findElement(By.cssSelector(".im-para.red")).getText(); 
		 * daha sonra bu kodu IDE de yapıştırdım ve toggle breadpoint koydum(debug noktası)
		 * ardından sağ tık debug as yaptım. sonrasında seçili satırı sağ tıkla seçtim (kopyalarken seçiliyorya tamamı o şekilde)
		 * sağ tık ve watch seçeneğine bastım. Ardından add items diyip aynısını aşağı kopyaladım. 
		 * Gerisi aynen adım adım cümleyi "at" den öncesi ve sonrası ayırdım. 2. taraf gerekliydi bize onu seçtim
		 * sonra boşluk vardı trimle onu yok ettim. tekrar " " ile yine ikiye ayırdım ve 1. olanı aldım
		 * sonra emailID değişkeni olarak tanımladım bunu IDE de . Sonra tekrar parentId sayfasına dönmem gerekiyordu 
		 * bu şekilde seleniuma burada olmam gerektiğini bildirdim. --> driver.switchTo().window(parentID);
		 * sonrasıı sendkeysle yazdırdım */
		
		String emailID =driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0] ;
		
		driver.switchTo().window(parentID);
		driver.findElement(By.id("username")).sendKeys(emailID);
		
		
		
	}
}
