import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class BrokenLink {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\huseyin.cakiroglu\\Documents\\BrowserDriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//broken URL

        //Step 1 - IS to get all urls tied up to the links using Selenium

        //  Java methods will call URL's and gets you the status code

        //if status code >400 then that url is not working-> link which tied to url is broken

        //a[href*="soapui"]'

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        

        

     List<WebElement> links=   driver.findElements(By.cssSelector("li[class='gf-li'] a"));

     SoftAssert a =new SoftAssert();

    

     for(WebElement link : links)

     {

      

         String url= link.getAttribute("href");

        

         HttpURLConnection   conn= (HttpURLConnection)new URL(url).openConnection();

         conn.setRequestMethod("HEAD");

         conn.connect();

         int responseCode = conn.getResponseCode();

         System.out.println(responseCode);

         a.assertTrue(responseCode<400, "The link with Text "+link.getText()+" is broken with code " +responseCode);

        

    

     }

    

     a.assertAll();

  

	}

}
