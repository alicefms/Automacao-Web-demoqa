package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.navegador;
import java.time.Duration;
import static org.junit.Assert.assertEquals;

public class FormsPage {
    private WebElement txtFirstName;
    private WebElement txtLastName;
    private WebElement txtEmail;
    private WebElement txtMobile;
    private Select optCountry;
    private WebElement txtCity;
    private WebElement txtMessage;
    private WebElement btnSend;
    private WebElement lblSucesso;


    public void abrirFormsPage(){
        navegador.browser.get("https://www.toolsqa.com/selenium-training/#enroll-form");
    }

    public void encontraWebElements(){
        txtFirstName = navegador.browser.findElement(By.id("first-name"));
        txtLastName = navegador.browser.findElement(By.id("last-name"));
        txtEmail = navegador.browser.findElement(By.id("email"));
        txtMobile = navegador.browser.findElement(By.id("mobile"));
        optCountry = new Select(navegador.browser.findElement(By.id("country")));
        txtCity = navegador.browser.findElement(By.id("city"));
        txtMessage = navegador.browser.findElement(By.id("message"));
        btnSend = navegador.browser.findElement(By.className("btn-primary"));
    }

    public void preencherCampos()  {
        txtFirstName.sendKeys("Alice");
        txtLastName.sendKeys("Souza");
        txtEmail.sendKeys("nada@algo.com");
        txtMobile.sendKeys("81981818181");
        optCountry.selectByVisibleText("Brazil");
        txtCity.sendKeys("Recife");
        txtMessage.sendKeys("Estudando automacao de testes WEB");
        //espera para preenchimento manual do captcha
        try {
            new Thread().sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        btnSend.click();
    }

    public void verificarMensagemSucesso(){
        lblSucesso = new WebDriverWait(navegador.browser, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert.alert-success")));
        assertEquals("Erro: texto não corresponde ao texto de sucesso", "We have received your message. We will soon get in touch.", lblSucesso.getText() );
    }

    public void fecharNavegador(){
        navegador.browser.close();
    }
}
