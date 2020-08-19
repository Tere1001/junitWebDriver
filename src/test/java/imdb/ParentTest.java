package imdb;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class ParentTest {
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	public static final int SHORT_WAIT = 5;
	public static final int MEDIUM_WAIT = 10;
	public static final int LONG_WAIT = 15;
	private String email ="tzmedel";
	private String lomain="@gmail.com";
	private String randomEmail;
	

	
	@Before
	public void setUp() {
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(SHORT_WAIT, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, LONG_WAIT);
	}
	
	@After
	public void tearDown() {
		driver.quit();
		
	}
	protected void validateMovieExists(String movieName) {
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(movieName)));
		List<WebElement> listaPeliculas = driver.findElements(By.cssSelector("td.result_text"));
		for(WebElement element: listaPeliculas) {
			String textoElemento = element.getText();
			if(textoElemento.contains(movieName)) {
				System.out.println("Ya encontre la pelicula " + movieName);
				break;
			}
		}
	}

	protected void searchMovie(String movieName) {

		//encontrar el campo de busqueda name= "q"
		WebElement campoBusqueda = driver.findElement(By.name("q"));
		campoBusqueda.sendKeys(movieName);
		//encontrar el boton de busqueda id="navbar-submit-button
		WebElement botonBusqueda = driver.findElement(By.cssSelector("#suggestion-search-button"));
		botonBusqueda.click();
	}
	//Econtrar el campo busqueda

	protected void validatePage() {
		// TODO Auto-generated method stub
		
	}

	protected void navigateToPage(String url) {
		// TODO Auto-generated method stub
		driver.navigate().to(url);
	}
	
	protected void playTrailer() {
		// TODO Auto-generated method stub
		
	}

	protected void validateCorrectMovie(String nombre, String anio) {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("#titleYear")));
		System.out.println("Se encontro titulo "+ nombre);
		
	}

	protected void selectMovie(String movieName, String movieYear) {
		// encontramos un elemento cuyo link diga 'movieName' y cuyo anio coincida con movieYear
		  //String xpathResultado = "//td[contains(., '" + movieName + " (" + movieYear+ ")')]/a";
		  //WebElement peliculaCorrecta = driver.findElement(By.xpath(xpathResultado));
		  //peliculaCorrecta.click();

		// TODO Auto-generated method stub
		List<WebElement> listaPeliculas = driver.findElements(By.cssSelector("td.result_text"));
		for(WebElement element: listaPeliculas) {
			String textoElemento = element.getText();
			if(textoElemento.contains(movieName) && textoElemento.contains(movieYear)) {
				System.out.println("Ya encontre la pelicula " + movieName);
				WebElement linkpelicula = element.findElement(By.cssSelector("a"));
				linkpelicula.click();
				break;
			}
		}
		
	}
	
	protected void validateMovieStars() {
		// TODO Auto-generated method stub
		
	}
	protected void createAcount() {
		this.randomEmail= this.email + new Random().nextInt (1000000)+this.lomain;
		sendText(email,this.randomEmail);
		// TODO Auto-generated method stub

	}

	private void sendText(String email, String randomEmail) {
	}


}
