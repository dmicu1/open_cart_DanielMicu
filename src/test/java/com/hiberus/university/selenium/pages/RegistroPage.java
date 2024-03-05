package com.hiberus.university.selenium.pages;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.net.UrlChecker;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class RegistroPage extends BasePage {
    //Constructor
    public RegistroPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }
    //Acciones
    public String getURL(){

        return getDriver().getCurrentUrl();
    }
    //Web Elements
    @FindBy(id = "input-firstname")
    private WebElement firstNameInput;

    @FindBy(id = "input-lastname")
    private WebElement lastNameInput;

    @FindBy(id = "input-email")
    private WebElement emailInput;

    @FindBy(id = "input-telephone")
    private WebElement telephoneInput;

    @FindBy(id = "input-password")
    private WebElement passwordInput;

    @FindBy(id = "input-confirm")
    private WebElement passwordConfirmInput;
    @FindBy(xpath = "//input[@name='agree']")
    private WebElement agreePrivacyPolicy;

    @FindBy(xpath = "//input[@value='Continue']")
    private WebElement continueButton;
    @FindBy(xpath = "//div[text()='First Name must be between 1 and 32 characters!']")
    private WebElement errorFirstNameMessage;
    @FindBy(xpath = "//div[text()='Last Name must be between 1 and 32 characters!']")
    private WebElement errorLastNameMessage;

    @FindBy(xpath = "//div[text()='E-Mail Address does not appear to be valid!']")
    private WebElement errorEmailMessage;

    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    private WebElement alreadyEmailMessage;

    @FindBy(xpath = "//div[text()='Password must be between 4 and 20 characters!']")
    private WebElement errorPasswordMessage;
    @FindBy(xpath =  "//div[text()='Telephone must be between 3 and 32 characters!']")
    private WebElement errorTelephoneMessage;

    @FindBy(xpath = "//div[text()='Password confirmation does not match password!']")
    private WebElement errorMatchPasswordMessage;

    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    private WebElement warningAgreePolicy;

    public void rellenoLosCamposDataValida() {
        wait.until(ExpectedConditions.visibilityOf(firstNameInput)).isDisplayed();
        firstNameInput.click();
        String firstNameRand= RandomStringUtils.randomAlphanumeric(32).toLowerCase();
        firstNameInput.sendKeys(firstNameRand);
        lastNameInput.click();
        String lastNameRand= RandomStringUtils.randomAlphanumeric(32).toLowerCase();
        lastNameInput.sendKeys(lastNameRand);
        emailInput.click();
        String emailRand = RandomStringUtils.randomAlphanumeric(10).toLowerCase() + "@gmail.com";
        emailInput.sendKeys(emailRand);
        telephoneInput.click();
        String telephoneRand= RandomStringUtils.randomNumeric(32).toLowerCase();
        telephoneInput.sendKeys(telephoneRand);
        passwordInput.click();
        String passwordRand= RandomStringUtils.randomAlphanumeric(20).toLowerCase();
        passwordInput.sendKeys(passwordRand);
        passwordConfirmInput.click();
        passwordConfirmInput.sendKeys(passwordRand);
        agreePrivacyPolicy.click();

    }
    public void pulsarContinuar(){
        wait.until(ExpectedConditions.visibilityOf(continueButton)).isDisplayed();
        continueButton.click();
    }
    public void camposLimitesInferiores() {
        wait.until(ExpectedConditions.visibilityOf(firstNameInput)).isDisplayed();
        firstNameInput.click();
        String firstNameRand= RandomStringUtils.randomAlphanumeric(0).toLowerCase();
        firstNameInput.sendKeys(firstNameRand);
        lastNameInput.click();
        String lastNameRand= RandomStringUtils.randomAlphanumeric(0).toLowerCase();
        lastNameInput.sendKeys(lastNameRand);
        emailInput.click();
        String emailRand = RandomStringUtils.randomAlphanumeric(4).toLowerCase() + "@gmail.com";
        emailInput.sendKeys(emailRand);
        telephoneInput.click();
        String telephoneRand= RandomStringUtils.randomNumeric(2).toLowerCase();
        telephoneInput.sendKeys(telephoneRand);
        passwordInput.click();
        String passwordRand= RandomStringUtils.randomAlphanumeric(3).toLowerCase();
        passwordInput.sendKeys(passwordRand);
        passwordConfirmInput.click();
        passwordConfirmInput.sendKeys(passwordRand);
        agreePrivacyPolicy.click();
    }
    public void erroresLimtesCamposInferiores() {
        wait.until(ExpectedConditions.visibilityOf(errorFirstNameMessage)).isDisplayed();
        if (errorFirstNameMessage.isDisplayed()) {
            System.out.println("El mensaje de error para el campo 'First Name' se ha mostrado correctamente.");
        } else {
            System.out.println("¡Error! El mensaje de error para el campo 'First Name' no se ha mostrado.");
        }
        // Imprime el texto del mensaje de error en la consola
        String actualErrorMessage = errorFirstNameMessage.getText();
        System.out.println("Mensaje de error actual para el campo 'First Name': " + actualErrorMessage);

        wait.until(ExpectedConditions.visibilityOf(errorLastNameMessage)).isDisplayed();
        // Verifica que el mensaje de error para el campo 'Last Name' se muestre correctamente
        if (errorLastNameMessage.isDisplayed()) {
            System.out.println("El mensaje de error para el campo 'Last Name' se ha mostrado correctamente.");
        } else {
            System.out.println("¡Error! El mensaje de error para el campo 'Last Name' no se ha mostrado.");
        }
        String actualErrorMessageLastName = errorLastNameMessage.getText();
        System.out.println("Mensaje de error actual para el campo 'Last Name': " + actualErrorMessageLastName);
        wait.until(ExpectedConditions.visibilityOf(errorLastNameMessage)).isDisplayed();

// Verifica que el mensaje de error para el campo 'Password' se muestre correctamente
        if (errorPasswordMessage.isDisplayed()) {
            System.out.println("El mensaje de error para el campo 'Password' se ha mostrado correctamente.");
        } else {
            System.out.println("¡Error! El mensaje de error para el campo 'Password' no se ha mostrado.");
        }
        String actualErrorMessagePassword = errorPasswordMessage.getText();
        System.out.println("Mensaje de error actual para el campo 'Password': " + actualErrorMessagePassword);

        wait.until(ExpectedConditions.visibilityOf(errorTelephoneMessage)).isDisplayed();
// Verifica que el mensaje de error para el campo 'Telephone' se muestre correctamente
        if (errorTelephoneMessage.isDisplayed()) {
            System.out.println("El mensaje de error para el campo 'Telephone' se ha mostrado correctamente.");
        } else {
            System.out.println("¡Error! El mensaje de error para el campo 'Telephone' no se ha mostrado.");
        }
        String actualErrorMessageTelephone = errorTelephoneMessage.getText();
        System.out.println("Mensaje de error actual para el campo 'Telephone': " + actualErrorMessageTelephone);
    }

    public void camposLimitesSuperiores() {
        wait.until(ExpectedConditions.visibilityOf(firstNameInput)).isDisplayed();
        firstNameInput.click();
        String firstNameRand= RandomStringUtils.randomAlphanumeric(33).toLowerCase();
        firstNameInput.sendKeys(firstNameRand);
        lastNameInput.click();
        String lastNameRand= RandomStringUtils.randomAlphanumeric(33).toLowerCase();
        lastNameInput.sendKeys(lastNameRand);
        emailInput.click();
        String emailRand = RandomStringUtils.randomAlphanumeric(4).toLowerCase() + "@gmail.com";
        emailInput.sendKeys(emailRand);
        telephoneInput.click();
        String telephoneRand= RandomStringUtils.randomNumeric(33).toLowerCase();
        telephoneInput.sendKeys(telephoneRand);
        passwordInput.click();
        String passwordRand= RandomStringUtils.randomAlphanumeric(33).toLowerCase();
        passwordInput.sendKeys(passwordRand);
        passwordConfirmInput.click();
        passwordConfirmInput.sendKeys(passwordRand);
        agreePrivacyPolicy.click();
    }
    public void erroresLimtesCamposSuperiores() {
        wait.until(ExpectedConditions.visibilityOf(errorFirstNameMessage)).isDisplayed();
        if (errorFirstNameMessage.isDisplayed()) {
            System.out.println("El mensaje de error para el campo 'First Name' se ha mostrado correctamente.");
        } else {
            System.out.println("¡Error! El mensaje de error para el campo 'First Name' no se ha mostrado.");
        }
        // Imprime el texto del mensaje de error en la consola
        String actualErrorMessage = errorFirstNameMessage.getText();
        System.out.println("Mensaje de error actual para el campo 'First Name': " + actualErrorMessage);

        wait.until(ExpectedConditions.visibilityOf(errorLastNameMessage)).isDisplayed();
        // Verifica que el mensaje de error para el campo 'Last Name' se muestre correctamente
        if (errorLastNameMessage.isDisplayed()) {
            System.out.println("El mensaje de error para el campo 'Last Name' se ha mostrado correctamente.");
        } else {
            System.out.println("¡Error! El mensaje de error para el campo 'Last Name' no se ha mostrado.");
        }
        String actualErrorMessageLastName = errorLastNameMessage.getText();
        System.out.println("Mensaje de error actual para el campo 'Last Name': " + actualErrorMessageLastName);

        wait.until(ExpectedConditions.visibilityOf(errorTelephoneMessage)).isDisplayed();
        // Verifica que el mensaje de error para el campo 'Telephone' se muestre correctamente
        if (errorTelephoneMessage.isDisplayed()) {
            System.out.println("El mensaje de error para el campo 'Telephone' se ha mostrado correctamente.");
        } else {
            System.out.println("¡Error! El mensaje de error para el campo 'Telephone' no se ha mostrado.");
        }
        String actualErrorMessageTelephone = errorTelephoneMessage.getText();
        System.out.println("Mensaje de error actual para el campo 'Telephone': " + actualErrorMessageTelephone);

        try {
            // Espera hasta que el mensaje de error para el campo 'Password' esté visible
            wait.until(ExpectedConditions.visibilityOf(errorPasswordMessage)).isDisplayed();

            // Si el mensaje de error está visible, imprime un mensaje de éxito
            System.out.println("El mensaje de error para el campo 'Password' se ha mostrado correctamente.");

            // Obtiene el texto del mensaje de error
            String actualErrorMessagePassword = errorPasswordMessage.getText();
            System.out.println("Mensaje de error actual para el campo 'Password': " + actualErrorMessagePassword);

        } catch (TimeoutException e) {
            // Si no se encuentra el elemento, imprime un mensaje de error
            System.out.println("¡Error! El mensaje de error para el campo 'Password' no se ha mostrado.");
        }
    }
}
