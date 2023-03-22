package br.com.raffathamires.page;

import br.com.raffathamires.core.BasePage;

public class MenuPage extends BasePage {

    public void acessarFormulario(){
        clicarPorTexto("Formulário");
    }

    public void acessarSplash() {
        clicarPorTexto("Splash");
    }
}
