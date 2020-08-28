package songsBySinatra;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.safari.SafariDriver;

public class SinatraSongBaseTest {
	
	protected WebDriver driver;
	public static final String WINDOWS_DRIVER_PATH = "C:\\Windows\\";
	public static final String UNIX_DRIVER_PATH = "/usr/local/bin/";
	
	public void setUp(String browser, String url) {
		driver = startBrowser(System.getProperty("os.name"), browser);
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	private WebDriver startBrowser(String osName, String browserName) {
		String basePath = "";
		String fileExt = "";
		String execName = "";
		if(osName.startsWith("Windows")) {
			basePath = WINDOWS_DRIVER_PATH;
			fileExt = ".exe";
		}
		else {
			basePath = UNIX_DRIVER_PATH;
		}

		if (BrowserType.FIREFOX.equals(browserName)) {
			execName = "geckodriver";
			System.setProperty(FirefoxDriver.SystemProperty.DRIVER_XPI_PROPERTY, basePath + execName + fileExt);
			return new FirefoxDriver();
		} else if (BrowserType.SAFARI.equals(browserName)) {
			execName = "safaridriver";
			System.setProperty("webdriver.safari.driver", basePath + execName + fileExt);
			return new SafariDriver();
		} else if (BrowserType.EDGE.equals(browserName)) {
			execName = "msedgedriver";
			System.setProperty(EdgeDriverService.EDGE_DRIVER_EXE_PROPERTY, basePath + execName + fileExt);
			return new EdgeDriver();
		} else {
			execName = "chromedriver";
			System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, basePath + execName + fileExt);
			return new ChromeDriver();
		}
	}
	
	@After
	public void tearDown() {

		driver.quit();
	}

	public void validateUserLogged(String user) {
		WebElement messageWelcome = driver.findElement(By.cssSelector("div .flash"));
		if(messageWelcome.isDisplayed() && messageWelcome.getText().contains("You are now logged in as frank")){
			//verificar que aparece la pagina de 'Songs'
			WebElement pageSong= driver.findElement(By.cssSelector("div .flash"));
			if(pageSong.isDisplayed()){
				System.out.println("Se encuentra visible el mensaje de bienvenida");
			}else{
				System.out.println("No se encuentra visble el mensaje de bienvenida");
			}
			//encontar el header
			WebElement header = driver.findElement(By.cssSelector("header"));
			//encontrar la liga de create a new song
			WebElement createSong= driver.findElement(By.cssSelector("[href=\"/songs/new\"]"));
			//preguntar si estan visibles
			if(createSong.isDisplayed()){
				System.out.println("Esta visible");
			}else{
				System.out.println("No se encuentra visible");
			}

		}





	}

	public void logIntoSinatra(String user, String password) {
		WebElement cusername = driver.findElement(By.id(user));
		WebElement cpassword = driver.findElement(By.id(password));
		WebElement botonLogin = driver.findElement(By.cssSelector("[value=\"Log In\""));
		//verificar que existen los campos de username, password, boton login
		if(cusername.isDisplayed() && cpassword.isDisplayed() && botonLogin.isDisplayed()){
			System.out.println("Se encuentran visibles el login");
		}else{
			System.out.println("No se encuentra visible el login");
			System.exit(-1);
		}
		//preguntar si estan visibles
		if(cusername.isEnabled() && cpassword.isEnabled() && botonLogin.isEnabled()){
			System.out.println("Se encuentran habilitados los campos");
		}
	}

}
