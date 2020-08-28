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
import org.openqa.selenium.support.ui.WebDriverWait;


public class ParentTest extends Clases{
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	public static final int SHORT_WAIT = 5;
	public static final int MEDIUM_WAIT = 10;
	public static final int LONG_WAIT = 15;
	private String email =Datos.USUARIO;
	private String domain=Datos.DOMAIN;
	private String password=Datos.PASSWORD;
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
		List<WebElement> listaPeliculas = driver.findElements(By.cssSelector(Clases.MOVIELIST));
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
		WebElement campoBusqueda = driver.findElement(By.name(Clases.SEARCHLABEL));
		campoBusqueda.sendKeys(movieName);
		//encontrar el boton de busqueda id="navbar-submit-button
		WebElement botonBusqueda = driver.findElement(By.cssSelector(Clases.SEARCHBUTTON));
		botonBusqueda.click();
	}
	//Econtrar el campo busqueda

	protected void validatePage() {
		//#suggestion-search-button
		//#suggestion-search
		WebElement btnbusqueda = driver.findElement(By.cssSelector(Clases.SEARCHBUTTON));
		WebElement campoBusqueda = driver.findElement(By.name(Clases.SEARCHLABEL));
		WebElement logo = driver.findElement(By.cssSelector(Clases.LOGOHOME));


		if(btnbusqueda.isDisplayed() && campoBusqueda.isDisplayed() && logo.isDisplayed()){
			System.out.println("Logo, Campo y boton de busqueda de home se encuentran!!");
		}else{
			System.out.println("No paso en la validacion de la pagina home");
		}

	}

	protected void validatePageNewRegister() {
		WebElement btnbusqueda = driver.findElement(By.cssSelector(Clases.SEARCHBUTTON));
		WebElement campoBusqueda = driver.findElement(By.name(Clases.SEARCHLABEL));
		WebElement logo = driver.findElement(By.cssSelector(Clases.LOGOHOME));
		WebElement btnnewuser = driver.findElement(By.cssSelector(Clases.NEWUSERBUTTON));
		if(btnbusqueda.isDisplayed() && campoBusqueda.isDisplayed() && logo.isDisplayed() && btnnewuser.isDisplayed()){
			System.out.println("Pagina para nuevo usuario!!");
			btnnewuser.click();
		}else{
			System.out.println("No paso en la validacion de la pagina home");
		}

	}

	protected void navigateToPage(String url) {

	    driver.navigate().to(url);
	}
	
	protected void playTrailer() { // REvisar en clase
		//WebElement trailer = driver.findElement(By.cssSelector("div.videoPreview__videoContainer"));
		WebElement trailer = driver.findElement(By.cssSelector("iframe#videoPreviewEmbedIframe"));

		trailer.click();
		/// revisarrr
        String movieYear= "2020";
        String movieName= "The Avengers";

        String movieLinkXpath = "//td[contains(.,'"+ movieYear +"')]//a[contains(text(), '"+ movieName +"')]";
        driver.findElement(By.xpath(movieLinkXpath)).click();

    }

	protected void validateCorrectMovie(String movieName, String movieYear) {

		//wait.until(ExpectedConditions.presenceOfElementLocated(By.className(Clases.CSSTITLEYEAR)));
		WebElement year = driver.findElement(By.cssSelector(Clases.CSSTITLEYEAR));
		WebElement name = driver.findElement(By.cssSelector(Clases.CSSTITLEORIGINAME));
		if(name.getText().contains(movieName) && year.getText().contains(movieYear)){
			System.out.println("Se encontro titulo "+movieName+ " "+ movieYear);
		}

	}

	protected void selectMovie(String movieName, String movieYear) {
		// encontramos un elemento cuyo link diga 'movieName' y cuyo anio coincida con movieYear
		  //String xpathResultado = "//td[contains(., '" + movieName + " (" + movieYear+ ")')]/a";
		  //WebElement peliculaCorrecta = driver.findElement(By.xpath(xpathResultado));
		  //peliculaCorrecta.click();

		List<WebElement> listaPeliculas = driver.findElements(By.cssSelector(Clases.LISTMOVIES));
		for(WebElement element: listaPeliculas) {
			String textoElemento = element.getText();
			if(textoElemento.contains(movieName) && textoElemento.contains(movieYear)) {
				System.out.println("Ya encontre la pelicula " + movieName);
				WebElement linkpelicula = element.findElement(By.cssSelector(Clases.LINKMOVIE));
				linkpelicula.click();
				break;
			}
		}
		
	}
	
	protected void validateMovieStars(String[] elenco) { // es este div.credit_summary_item a[href*='name']
		List<WebElement> listaElenco = driver.findElements(By.cssSelector("div.credit_summary_item a[href*='name']"));

		for(WebElement element : listaElenco){
			String textoelemento = element.getText();
			System.out.println("Valor " + textoelemento);

			if(textoelemento.contains("Stars")){
				System.out.println("textoelemento " + textoelemento);
				List<WebElement> actors = element.findElements(By.tagName("a"));
				for(WebElement star : actors) {
					String elementoStars = star.getText();
					System.out.println("elementoStars " + elementoStars);
					if (elementoStars.contains(elenco[0]) && elementoStars.contains(elenco[1]) && elementoStars.contains(elenco[2])) {
						System.out.println("Contiene el elenco buscado " + elementoStars);
					} else {
						System.out.println("Algo fallo :(");
						break;
					}
				}
				break;
			}

		}
		
	}


	protected void createAcount() {
		//this.randomEmail= this.email + new Random().nextInt (1000000)+this.domain;
		//sendText(email,this.randomEmail);
	//	sendText(password,this.password);
      //  WebElement

		WebElement campouser= driver.findElement(By.className("div [name=customerName]"));
		WebElement campoemail= driver.findElement(By.className("div [name=email]"));
		WebElement pass1= driver.findElement(By.className("div [name=password]"));
		WebElement pass2= driver.findElement(By.className("div [name=passwordCheck]"));

		campouser.sendKeys(Datos.USERNAME);
		campoemail.sendKeys(email+domain);
		pass1.sendKeys(password);
		pass2.sendKeys(password);

		System.out.println("Paso creacion cuenta");

	}
	protected void validateProfile(String userName) {
		// TODO Auto-generated method stub

		WebElement usuariologgeado = driver.findElement(By.cssSelector(Clases.NAMESEARCHBAR));
		if(usuariologgeado.getText() == userName){
			System.out.println("El usuario es el correcto");
		}else{
			System.out.println("Algun valor no esta bien");
		}

	}

	protected void navigateToPageNewRegister(String urlnewuser) {
		driver.navigate().to(urlnewuser);
	}


	protected void sendText(String email, String randomEmail) {
         // TODO Auto-generated method stub
	}

	protected void addWatchlist(String movieName, String movieYear) {
		// TODO Auto-generated method stub

	}
	protected void validateWatchlist(String movieName, String movieYear) {
		// TODO Auto-generated method stub

	}


}
