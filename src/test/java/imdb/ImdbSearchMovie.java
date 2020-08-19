package imdb;

import org.junit.Test;

public class ImdbSearchMovie extends ParentTest{
	
	@Test
	public void testSearchMovie() {
		navigateToPage(Datos.URLIMDB);
		validatePage();
		searchMovie(Datos.MOVIENAME);
		validateMovieExists(Datos.MOVIENAME);
	}
	
	
	@Test
	public void testPlayTrailer() throws InterruptedException {
		navigateToPage(Datos.URLIMDB);
		validatePage();
		searchMovie(Datos.MOVIENAME);
		validateMovieExists(Datos.MOVIENAME);
		selectMovie(Datos.MOVIENAME, Datos.MOVIEYEAR);
		validateCorrectMovie(Datos.MOVIENAME, Datos.MOVIEYEAR);
		playTrailer();
	}

	@Test
	public void testValidateMovieStars() {
		navigateToPage(Datos.URLIMDB);
		validatePage();
		searchMovie(Datos.MOVIENAME);
		validateMovieExists(Datos.MOVIENAME);
		selectMovie(Datos.MOVIENAME, Datos.MOVIEYEAR);
		validateCorrectMovie(Datos.MOVIENAME, Datos.MOVIEYEAR);
		validateMovieStars();
	}

	

}
