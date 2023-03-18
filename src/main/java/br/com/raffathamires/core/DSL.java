package br.com.raffathamires.core;

import static br.com.raffathamires.core.DriverFactory.getDriver;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class DSL {

    public void escrever(By by, String texto) {
        getDriver().findElement(by).sendKeys(texto);
    }

    public String obterTexto(By by){
        return getDriver().findElement(by).getText();
    }

    public void selecionarCombo(By by, String valor){
        //Clicar no combo
        getDriver().findElement(by).click();

        //Selecionar a opcao desejada
        clicarPorTexto(valor);
    }

    public void clicar(By by){
        getDriver().findElement(by).click();
    }

    public void clicarPorTexto(String texto) {
        //class[@att='value']
        clicar(By.xpath("//*[@text='" + texto +"']"));
    }

    public boolean isCheckMarcado(By by){
        return getDriver().findElement(by).getAttribute("checked").equals("true");
    }
}
