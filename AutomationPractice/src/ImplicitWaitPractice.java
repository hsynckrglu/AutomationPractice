import java.time.Duration;
import java.util.Arrays;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ImplicitWaitPractice {
	/* implicit wait global çalışır. örneğin ürünleri sepete eklediğimde "procced to checkout" dediğimde
	 *  diğer sayfaya geçmesi birr kaç saniye sürüyor. seleniuma demeliyimki bekle. 
	 *  bundan dolayı testim başarılı olacak. Fakat bu implicit wait her satırdaki kodu 
	 *  tek tek bekler. Avantajlarından bir tanesi de şudur.diyelimki sayfa 3 saniyede 
	 *  açılıyor ve ben timeoutu 5 saniye belirledim 3 saniye bekliyor kalan 2 saniyeyi beklemeden teste devam ediyor.
	 *  örneğin başka bir bölümde de sayfanın 2 saniyeden başlamasını istiyorum ama 
	 *  impicit waite 5 saniye dediğim için mecbur max 5 sn bekleyecek teste basarılı olacak
	 *  fakat o işlevin 2 saniyeden fazla sürmemesi gerekiyor. 
	 *  burada performans sorunlarını gizliyor.thread.sleep gibi 5 sn boyunca sayfa açılsa da açılmasa da beklemiyor.   */
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\huseyin.cakiroglu\\Documents\\BrowserDriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//implicit wait syntax
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		

		String[] itemsNeeded = { "Brocolli", "Cucumber", "Tomato" , "Brinjal"};
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		addItems(driver,itemsNeeded);

		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		driver.findElement(By.cssSelector("input[placeholder='Enter promo code']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		//Unable to locate element hatası verince sekronize kullanmak gerekir.
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		Assert.assertEquals(driver.findElement(By.cssSelector("span.promoInfo")).getText(), "Code applied ..!");
		
	}
	
	public static void addItems(WebDriver driver,String[] itemsNeeded) {
		int j=0;
		List<WebElement> products = driver.findElements(By.cssSelector("h4[class='product-name']"));
		List itemsNeededList = Arrays.asList(itemsNeeded);
		for (int i = 0; i < products.size(); i++) {

			String[] name = products.get(i).getText().split("-");
			String formatedName = name[0].trim();
			
			
			if (itemsNeededList.contains(formatedName)) {
				j++;

				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

				if (j == itemsNeeded.length) {
					break;
				}

			}

		}

		
	}


}
