package br.com.raffathamires.page;

import br.com.raffathamires.core.BasePage;
import org.openqa.selenium.By;

public class AccordionPage extends BasePage {

    public void selecionarOp1(){
        clicarPorTexto("Opção 1");
    }

    public String obterValorOp1(){
        return obterTexto(By.xpath("//*[starts-with(@text,'Esta é a descrição da opção 1')]"));
        //return obterTexto(By.xpath("//*[@text='Opção 1']/../..//following-sibling::android.view.ViewGroup//android.widget.TextView"));
    }
}
