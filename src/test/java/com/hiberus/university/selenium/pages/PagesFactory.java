package com.hiberus.university.selenium.pages;


import org.openqa.selenium.WebDriver;


public class PagesFactory {
    private static PagesFactory pagesFactories;
    private final WebDriver driver;
    private final HomePage homePage;
    private final RegistroPage registroPage;
    private final LoginPage loginPage;
    private final CestaPage cestaPage;


    private PagesFactory(WebDriver driver) {
        this.driver = driver;
        homePage = new HomePage(driver);
        registroPage = new RegistroPage(driver);
        loginPage = new LoginPage(driver);
        cestaPage = new CestaPage(driver);
    }

    public static void start (WebDriver driver) {pagesFactories = new PagesFactory(driver);}

    public static PagesFactory getInstance() {
        return pagesFactories;
    }

    public WebDriver getDriver() {return driver;}

    public HomePage getHomePage() {return homePage;}
    public RegistroPage getRegistroPage() { return registroPage; }
    public LoginPage getLoginPage() {return loginPage; }
    public CestaPage getCestaPage()  {return cestaPage;}

}
