import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class meyveSebzeEkleme {
	/*
	 * Array boyutunu .length() ArrayListin boyutunu ise .size() metotlarıyla
	 * buluruz.
	 */
	public static void main(String[] args) throws InterruptedException  {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\huseyin.cakiroglu\\Documents\\BrowserDriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		int j = 0;
		String[] itemsNeeded = { "Brocolli", "Cucumber", "Tomato" , "Brinjal"};

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		//Thread.sleep(3000);

		List<WebElement> products = driver.findElements(By.cssSelector("h4[class='product-name']"));
	    List<String> itemsNeededList = Arrays.asList(itemsNeeded);
	    
		for (int i = 0; i < products.size(); i++) {

			String[] name = products.get(i).getText().split("-");
			String formatedName = name[0].trim();
			// name = Cauliflower - 1 Kg split ile bölücem --> split("-")
			// name[0]= cauliflower , - dan önce bir boşluk olduğu için trimle boşlukları
			// silicem.
			// name[1] = 1 Kg

			/*
			 * burada yukarda oluşturduğum arrayi (itemsNeeded) ArrayListe çevirdim.
			 * İnternetten bakıp çevirdim. Syntaxı aşağıdaki gibi
			 */
		

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
