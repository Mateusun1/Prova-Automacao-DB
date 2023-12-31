package br.com.automacao.e2e.fuentpageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {

    WebDriver driver;
    WebDriverWait wait;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,5), this);
    }
    @FindBy(css = "form[class='styles__ContainerFormRegister-sc-7fhc7g-0 keVbpY'] input[name='email']")
    WebElement inputEmail;
    @FindBy(css = "form[class='styles__ContainerFormRegister-sc-7fhc7g-0 keVbpY'] input[name='name']")
    WebElement inputNome;
    @FindBy(css = "form[class='styles__ContainerFormRegister-sc-7fhc7g-0 keVbpY'] input[name='password']")
    WebElement inputSenha;
    @FindBy(css = "form[class='styles__ContainerFormRegister-sc-7fhc7g-0 keVbpY'] input[name='passwordConfirmation']")
    WebElement inputConfirmarSenha;
    @FindBy(css = "label.styles__Container-sc-1pngcbh-0.kIwoPV label#toggleAddBalance")
    WebElement botaoAtivarSaldo;
    @FindBy(css = "button[class='style__ContainerButton-sc-1wsixal-0 CMabB button__child']")
    WebElement botaoCadastrar;
    @FindBy(css = "a[id='btnCloseModal']")
    WebElement botaoFecharModal;


    public RegisterPage preencherDados(String email,String nome,String senha,String confirmarSenha){
        this.inputEmail.sendKeys(email);
        this.inputNome.sendKeys(nome);
        this.inputSenha.sendKeys(senha);
        this.inputConfirmarSenha.sendKeys(confirmarSenha);
        return this;
    }
    public RegisterPage ativarSaldo() {
        Actions actions = new Actions(driver);
        actions.moveToElement(botaoAtivarSaldo).moveToElement(botaoAtivarSaldo).click().build().perform();
        this.botaoAtivarSaldo.click();
        return this;
    }
    public RegisterPage cadastrarConta(){
        this.botaoCadastrar.click();
        return this;
    }
    public LoginPage fecharModal() {
        wait.until(ExpectedConditions.elementToBeClickable(botaoFecharModal));
        this.botaoFecharModal.click();
        return new LoginPage(driver);
    }

    public RegisterPage limparCampo() {
        this.inputEmail.clear();
        this.inputNome.clear();
        this.inputSenha.clear();
        this.inputConfirmarSenha.clear();
        return this;
    }
}
