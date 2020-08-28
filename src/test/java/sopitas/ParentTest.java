package sopitas;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ParentTest extends Datos {
    protected WebDriver driver;
    protected WebDriverWait wait;
    public static final int SHORT_WAIT = 5;
    public static final int MEDIUM_WAIT = 10;
    public static final int LONG_WAIT = 15;
    private Object ListElement;


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
    protected void navegarPagina(String url) {
        driver.navigate().to(url);

    }

    protected void verificarPagina() {
        // verificar logoSopitas: css= "h1 .text-hide.logo-sopitas"
        WebElement logo= driver.findElement(By.cssSelector(Datos.LOGO));
        // verificar campoBusqueda:css= "#s-desktop"
        WebElement campobusqueda= driver.findElement(By.cssSelector(Datos.CAMPOBUSQUEDA));
        // verificar botonBusqueda: css= "#s-desktop+.btn.btn-default"
        WebElement botonbusqueda= driver.findElement(By.cssSelector(Datos.BOTONBUSQUEDA));


        if(logo.isDisplayed() && campobusqueda.isDisplayed() && botonbusqueda.isDisplayed() ){
            System.out.println("Los elementos Logo, campo busqueda y boton busqueda de la pagina principal cargaron correctamente");
        }else{
            System.out.println("No se cargaron correctamente los elementos");
        }
    }


    protected void verificarHashtag() {
        // verificar iconoHashtag: hashtag = #trending h5
        WebElement iconohashtag= driver.findElement(By.cssSelector(Datos.HASHTAG));
        if(iconohashtag.isDisplayed()){
            System.out.println("El elemento Hash tag de la pagina principal cargo correctamente");
        }else{
            System.out.println("El elemento Hash tag No se cargo correctamente");
        }

    }

    protected void imprimitHashTag() {
        // verificarelementosHashtag: seccion = #trending ol
        WebElement seccion= driver.findElement(By.cssSelector(Datos.SECCION));
        if(seccion.isDisplayed()){
            List<WebElement> seccionesmenu =  driver.findElements(By.cssSelector(Datos.MENUSECCION));
            for(WebElement element : seccionesmenu){
                String textoelemento= element.getText();
                System.out.println("Elemento : "+ textoelemento);
            }
            System.out.println("El elemento seccion de la pagina principal cargaron correctamente");
        }else{
            System.out.println("El elemento seccion No se cargo correctamente");
        }
    }

}
