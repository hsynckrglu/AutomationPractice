import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class fluentWaitPractice {
	
	/* fluentwait expcilitwaitin 2 çeşitinden birisidir.wait interfacesini kullanır
	 * 30 sn max bekleme süresi var ve her 3 ya da 5 tamamen gereksinime kalmış süre veriyorsun
	 * bu sürede bir koşulu tekrar sağlıyor mu diye kontrol ediyor.
	 * her 3 saniyede bir kontrol ediyor gibi. kaç sn verdiysem
	 * syntaxını da internetten baktık.
	 *  */

/*	syntaxı -->https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/support/ui/FluentWait.html
 *  Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		       .withTimeout(Duration.ofSeconds(30L))
		       .pollingEvery(Duration.ofSeconds(5L))
		       .ignoring(NoSuchElementException.class);

		   WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
		     public WebElement apply(WebDriver driver) {
		       return driver.findElement(By.id("foo"));
		     }
		   });   */
		 
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\huseyin.cakiroglu\\Documents\\BrowserDriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		driver.findElement(By.cssSelector("[id='start'] button")).click();
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
		
		 WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
		     public WebElement apply(WebDriver driver) {
		    	 if(driver.findElement(By.cssSelector("[id='finish'] h4")).isDisplayed()) {
		    		  return driver.findElement(By.cssSelector("[id='finish'] h4"));
		    	 }
		    	 else {
		    		 return null;
		    	 }
		     }
		   });
		 
		System.out.println(driver.findElement(By.cssSelector("[id='finish'] h4")).getText()); 

	}

}
