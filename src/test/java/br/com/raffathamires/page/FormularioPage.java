package br.com.raffathamires.page;

import br.com.raffathamires.core.DSL;
import io.appium.java_client.MobileBy;
import org.junit.Assert;
import org.openqa.selenium.By;

public class FormularioPage {
    private DSL dsl = new DSL();

    public void escreverNome(String nome){
        dsl.escrever(MobileBy.AccessibilityId("nome"), nome);
    }

    public String obterNome(){
        return dsl.obterTexto(MobileBy.AccessibilityId("nome"));
    }

    public void selecionarCombo(String valor){
        dsl.selecionarCombo(MobileBy.AccessibilityId("console"), valor);
    }

    public String obterValorCombo(){
        return dsl.obterTexto(By.xpath("//android.widget.Spinner/android.widget.TextView"));
    }

    public void clicarCheckBox(){
        dsl.clicar(By.className("android.widget.CheckBox"));
    }

    public void clicarSwitch(){
        dsl.clicar(MobileBy.AccessibilityId("switch"));
    }

    public boolean isCheckMarcado(){
        return dsl.isCheckMarcado(By.className("android.widget.CheckBox"));
    }

    public boolean isSwitchMarcado(){
        return dsl.isCheckMarcado(MobileBy.AccessibilityId("switch"));
    }

    public void salvar(){
        dsl.clicarPorTexto("SALVAR");
    }

    public String obterNomeCadastrado(){
        return dsl.obterTexto(By.xpath("//*[starts-with(@text,'Nome:')]"));
    }

    public String obterConsoleCadastrado(){
        return dsl.obterTexto(By.xpath("//*[starts-with(@text,'Console:')]"));
    }

    public String obterCheckBoxCadastrado(){
        return dsl.obterTexto(By.xpath("//*[starts-with(@text,'Checkbox:')]"));
    }

    public String obterSwitchCadastrado(){
        return dsl.obterTexto(By.xpath("//*[starts-with(@text,'Switch:')]"));
    }

}
