package br.com.raffathamires.test;

import br.com.raffathamires.core.BaseTest;

import br.com.raffathamires.page.FormularioPage;
import br.com.raffathamires.page.MenuPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;

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

}
