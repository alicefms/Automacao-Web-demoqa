package steps;

import io.cucumber.java.pt.*;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.FormsPage;

public class MyStepdefs {

    private FormsPage formsPage = new FormsPage();

    @Dado("que estou na página de registro")
    public void queEstouNaPáginaDeRegistro() {
        navegador.browser = new ChromeDriver();
        formsPage.abrirFormsPage();
    }

    @E("eu preencho o formulário com informações válidas")
    public void euPreenchoOFormulárioComInformaçõesVálidas()  {
        formsPage.encontraWebElements();
        formsPage.preencherCampos();
    }

    @Então("o sistema deve exibir uma mensagem de sucesso de registro")
    public void oSistemaDeveExibirUmaMensagemDeSucessoDeRegistro() {
        formsPage.verificarMensagemSucesso();
        formsPage.fecharNavegador();
    }

}
