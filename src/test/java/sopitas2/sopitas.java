package sopitas2;

import org.junit.Test;

public class sopitas extends parentSopitas{

    @Test
    public void testSitioSopitas() throws Exception {
        navegarPagina("https://www.sopitas.com/");
        verificarPagina();
        verificarHashtag();
        imprimitHashTag();

    }

}