package imdb;

import org.junit.Test;

public class ImdbAddWatchList extends ParentTest{
    @Test
    public void testWatchlist(){
        navigateToPage(Datos.URLIMDB);
        validatePage();
        searchMovie(Datos.MOVIENAME);
        validateMovieExists(Datos.MOVIENAME);
        selectMovie(Datos.MOVIENAME, Datos.MOVIEYEAR);
        validateCorrectMovie(Datos.MOVIENAME, Datos.MOVIEYEAR);
        validateMovieStars(Datos.CAST);
        addWatchlist(Datos.MOVIENAME, Datos.MOVIEYEAR);  //falta
        validateWatchlist(Datos.MOVIENAME, Datos.MOVIEYEAR);  //falta

    }


}
