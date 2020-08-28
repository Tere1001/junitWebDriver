package imdb;

import org.junit.Test;

public class ImdbRegisterUser extends ParentTest{
    @Test
    public void testRegisterUser(){
        navigateToPageNewRegister(Datos.URLNEWUSER);
        validatePageNewRegister();
        createAcount(); // revisar localizadores
        validateProfile(Datos.USERNAME);
    }
}

