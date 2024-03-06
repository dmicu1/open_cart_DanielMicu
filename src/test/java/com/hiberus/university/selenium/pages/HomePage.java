package com.hiberus.university.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    public static final String PAGE_URL="https://opencart.abstracta.us/";

    //Web Elementos
    @FindBy(xpath = "//span[text()='My Account']")
    private WebElement dropDownAccount;

    @FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']/*[1]")
    private WebElement registroOption;

    @FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']/*[2]")
    private WebElement loginOption;

    //Constructores
    public HomePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver ,this);
    }
    //Acciones
    public void abrirMenuDesplegable(){
        dropDownAccount.click();

    }
    public void seleccionarOpcionLogin(){
        dropDownAccount.click();
        wait.until(ExpectedConditions.visibilityOf(loginOption)).isDisplayed();
        loginOption.click();
    }
    public void pulsarParaPaginaRegistro(){

        registroOption.click();
    }
    public void pulsarParaLogin(){
        loginOption.click();
    }
    public void seleccionarOpcionRegistro(){
        dropDownAccount.click();
        wait.until(ExpectedConditions.visibilityOf(loginOption)).isDisplayed();
        registroOption.click();
    }

    public String getURL() {
        return getDriver().getCurrentUrl();
    }
}
