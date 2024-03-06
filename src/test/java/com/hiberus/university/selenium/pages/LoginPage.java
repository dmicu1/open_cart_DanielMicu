package com.hiberus.university.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getURL() {
        return getDriver().getCurrentUrl();
    }

    //Elementos
    @FindBy(id = "input-email")
    private WebElement emailInput;
    @FindBy(id = "input-password")
    private WebElement passwordInput;
    @FindBy(xpath = "//input[@value='Login']")
    private WebElement loginInput;

    public void ingresarCredencialesValidas() {
        emailInput.click();
        emailInput.sendKeys("danielmicu26@gmail.com");
        passwordInput.click();
        passwordInput.sendKeys("Hiberus2024");
        loginInput.click();
    }

    public void ingresarContraseñaInvalida() {
        emailInput.click();
        emailInput.sendKeys("danielmicu26@gmail.com");
        passwordInput.click();
        passwordInput.sendKeys("Hiberus");
        loginInput.click();
    }
}
