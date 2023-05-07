package br.com.raffathamires.test;

import br.com.raffathamires.core.BaseTest;
import br.com.raffathamires.page.AlertaPage;
import br.com.raffathamires.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class AlertTeste extends BaseTest {

    private MenuPage menuPage = new MenuPage();
    private AlertaPage alertaPage = new AlertaPage();

    @Test
    public void deveConfirmarAlerta(){

        menuPage.acessarAlertas();

        alertaPage.clicarAlertaConfirm();

        Assert.assertEquals("Info", alertaPage.obterTituloAlerta());
        Assert.assertEquals("Confirma a operação?", alertaPage.obterMensagemAlerta());

        alertaPage.confirmarAlerta();

        Assert.assertEquals("Confirmado", alertaPage.obterMensagemAlerta());

        alertaPage.sair();

    }
}
