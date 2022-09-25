import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class miscelleanousCerezler {
/* çerez ekleyip silebilirim. Ama öncelikle ekranı max yapmam gerekiyor.
 * ayrıyeten site açılmadan yapabileceğim gibi site de vakit geçirdikten sonra da silebilirim. */
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\huseyin.cakiroglu\\Documents\\BrowserDriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies(); // tüm çerezleri siler
//		driver.manage().deleteCookieNamed("asdfgh");//ismini verdiğim çerezi siler
//		driver.manage().addCookie("assfdsdf");//çerez ekleyebilirim
		driver.get("https://google.com");
	}

}
