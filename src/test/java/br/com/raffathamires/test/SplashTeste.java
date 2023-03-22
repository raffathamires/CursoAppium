package br.com.raffathamires.test;

import br.com.raffathamires.core.BaseTest;
import br.com.raffathamires.page.MenuPage;
import br.com.raffathamires.page.SplashPage;
import org.junit.Assert;
import org.junit.Test;

public class SplashTeste extends BaseTest {
    private MenuPage menuPage = new MenuPage();
    private SplashPage splashPage = new SplashPage();
    @Test
    public void deveAguardarSplashSumir() {
        //acessar menu splash
        menuPage.acessarSplash();

        //verificar que o splash esta sendo exibido
        splashPage.isTelaSplashVisivel();

        //aguardar saida do splash
        splashPage.aguardarSplashSumir();

        //verificar que o formulario ta aparecendo
        Assert.assertTrue(splashPage.existeElementoPorTexto("Formulário"));
    }

}
