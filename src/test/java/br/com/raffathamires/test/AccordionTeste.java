package br.com.raffathamires.test;

import br.com.raffathamires.core.BaseTest;
import br.com.raffathamires.page.AccordionPage;
import br.com.raffathamires.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class AccordionTeste extends BaseTest {
    private MenuPage menuPage = new MenuPage();
    private AccordionPage accordionPage = new AccordionPage();

    @Test
    public void deveInteragirComAccordion(){
        menuPage.acessarAccordion();
        accordionPage.selecionarOp1();

        Assert.assertEquals("Esta é a descrição da opção 1",accordionPage.obterValorOp1());

    }
}
