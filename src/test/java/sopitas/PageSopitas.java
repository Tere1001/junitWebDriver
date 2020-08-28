package sopitas;

import org.junit.Test;

public class PageSopitas extends ParentTest {

    @Test
    public void testSitioSopitas(){
        navegarPagina(Datos.URL);
        verificarPagina();
        verificarHashtag();
        imprimitHashTag();

    }

}
