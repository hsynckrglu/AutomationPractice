import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ürünEkleme {
	/* meyveSebzeEkleme.java classındaki bir şeyleri ekleme işini
	 * main metodunun dışında yaratıp daha sonro oluşturduğum metodu (addItems() ) main içinde kullanıyorum */
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\huseyin.cakiroglu\\Documents\\BrowserDriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		String[] itemsNeeded = { "Brocolli", "Cucumber", "Tomato" , "Brinjal"};
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		addItems(driver,itemsNeeded);

		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		driver.findElement(By.cssSelector("input[placeholder='Enter promo code']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		//Unable to locate element hatası verince sekronize kullanmak gerekir.
		
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
