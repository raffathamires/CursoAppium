package br.com.raffathamires.page;

import br.com.raffathamires.core.DSL;

public class MenuPage {

    private DSL dsl = new DSL();

    public void acessarFormulario(){
        dsl.clicarPorTexto("Formulário");
    }
}
