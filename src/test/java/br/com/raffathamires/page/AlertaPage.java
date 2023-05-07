package br.com.raffathamires.page;

import br.com.raffathamires.core.BasePage;
import org.openqa.selenium.By;

public class AlertaPage extends BasePage {
    public void clicarAlertaConfirm(){
        clicarPorTexto("ALERTA CONFIRM");
    }

    public String obterTituloAlerta(){
        return obterTexto(By.id("android:id/alertTitle"));
    }

    public String obterMensagemAlerta(){
        return obterTexto(By.id("android:id/message"));
    }

    public void confirmarAlerta(){
        clicar(By.id("android:id/button2"));
    }

    public void sair(){
        clicar(By.id("android:id/button1"));
    }
}
