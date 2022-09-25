import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariOptions;

public class SSLCheck {

	public static void main(String[] args) {
		
		/* SSL (Secure Sockets Layer) sertifikaları, 
		 * site adreslerinin doğruluğunu kontrol eden, 
		 * iki nokta arasındaki veri iletişimini şifreli kanal üzerinden yaparak 
		 * güvenli bir şekilde iletilmesini sağlayan bir üründür. SSL sertifikaları,
		 *  hiç bir zaman yazdığınız kodun veya web sitenizin güvenliğini sağlamaz.
		 *  SSL siteye girerken site güvenilir değil hatasını veren sertifika 
		 *  siteye girmesini söylüyoruz seleniuma fakat SSL olduğu için sertifika geldiğinden
		 *  test basarısız oluyor. onu seleniuma şu şekilde tanıtacağız.
		 *  Chrome firefox edge safari gibib browserlerde action yapıcaz bu sefer */
		
/*             syntax--> 
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		sonra tanımladığım options nesnesini
		 WebDriver driver = new ChromeDriver(options); içine yapıştırıyorum .  */		
		
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		
//		FirefoxOptions options1= new FirefoxOptions();
//		options1.setAcceptInsecureCerts(true);
//		
//		EdgeOptions options2= new EdgeOptions();
//		options2.setAcceptInsecureCerts(true);
//		
//		SafariOptions options3= new SafariOptions();
//		options3.setAcceptInsecureCerts(true);
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\huseyin.cakiroglu\\Documents\\BrowserDriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
		
	}

}
