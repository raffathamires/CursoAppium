package br.com.raffathamires.test;

import br.com.raffathamires.core.BaseTest;
import br.com.raffathamires.page.AbasPage;
import br.com.raffathamires.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class AbasTeste extends BaseTest {
    private MenuPage menuPage = new MenuPage();

    private AbasPage abasPage = new AbasPage();

    @Test
    public void deveInteragirComAbas(){
        menuPage.acessarAbas();

        Assert.assertTrue(abasPage.isAba1());;

        abasPage.selecionarAba2();

        Assert.assertTrue(abasPage.isAba2());;

    }
}
