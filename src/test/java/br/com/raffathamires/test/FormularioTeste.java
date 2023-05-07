package br.com.raffathamires.test;

import br.com.raffathamires.core.BaseTest;
import br.com.raffathamires.core.DriverFactory;
import br.com.raffathamires.page.FormularioPage;
import br.com.raffathamires.page.MenuPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class FormularioTeste extends BaseTest {

    private MenuPage menuPage = new MenuPage();
    private FormularioPage formularioPage = new FormularioPage();

    @Before
    public void inicializarAppium() throws MalformedURLException {
        menuPage.acessarFormulario();
    }

    @Test
    public void devePreencherCampoTexto() throws MalformedURLException {

        //Escrever Nome
        formularioPage.escreverNome("Raffaela");

        //Checar Nome escrito
        Assert.assertEquals("Raffaela", formularioPage.obterNome());

    }

    @Test
    public void deveInteragirCombo() throws MalformedURLException {

        formularioPage.selecionarCombo("Nintendo Switch");
        Assert.assertEquals("Nintendo Switch", formularioPage.obterValorCombo());

    }

    @Test
    public void deveInteragirSwitchCheckBox() throws MalformedURLException {

        //Verificar estado dos elementos
        Assert.assertFalse(formularioPage.isCheckMarcado());
        Assert.assertTrue(formularioPage.isSwitchMarcado());

        //Clicar nos elementos
        formularioPage.clicarCheckBox();
        formularioPage.clicarSwitch();

        //Verificar estado alterados
        Assert.assertTrue(formularioPage.isCheckMarcado());
        Assert.assertFalse(formularioPage.isSwitchMarcado());

    }

    @Test
    public void deveRealizarCadastro() throws MalformedURLException {

        //PREENCHER
        formularioPage.escreverNome("Raffaela");
        formularioPage.selecionarCombo("Nintendo Switch");
        formularioPage.clicarCheckBox();
        formularioPage.clicarSwitch();
        formularioPage.salvar();

        //Assertivas
        Assert.assertEquals("Nome: Raffaela", formularioPage.obterNomeCadastrado());
        Assert.assertEquals("Console: switch", formularioPage.obterConsoleCadastrado());
        Assert.assertTrue(formularioPage.obterSwitchCadastrado().endsWith("Off"));
        Assert.assertTrue(formularioPage.obterCheckBoxCadastrado().endsWith("Marcado"));

    }

    @Test
    public void deveRealizarCadastroDemorado() throws MalformedURLException {

        formularioPage.escreverNome("Raffaela");

        DriverFactory.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

        formularioPage.salvarDemorado();

        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Nome: Raffaela']")));

        Assert.assertEquals("Nome: Raffaela", formularioPage.obterNomeCadastrado());

    }

    @Test
    public void deveAlterarData(){
        formularioPage.clicarPorTexto("01/01/2000");
        formularioPage.clicarPorTexto("20");
        formularioPage.clicarPorTexto("OK");
        Assert.assertTrue(formularioPage.existeElementoPorTexto("20/01/2000"));
    }

}
