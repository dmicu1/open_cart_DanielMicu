package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.HomePage;
import com.hiberus.university.selenium.pages.LoginPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

public class loginStep {


    @When(": Ingreso mis credenciales {string} y {string}")
    public void ingreso_mis_credenciales_y(String string, String string2) {
        PagesFactory pagesFactory = PagesFactory.getInstance();
        LoginPage loginPage = pagesFactory.getLoginPage();
        loginPage.ingresarCredencialesValidas();

    }

    @Then(": El login se realiza correctamente")
    public void el_login_se_realiza_correctamente() {
        PagesFactory pagesFactory = PagesFactory.getInstance();
        LoginPage loginPage = pagesFactory.getLoginPage();
        String actualURL = loginPage.getURL();
        String expectedURL = "https://opencart.abstracta.us/index.php?route=account/account";
        Assert.assertEquals("No se ha podido realizar el Login", expectedURL, actualURL);
        if (actualURL.equals(expectedURL)) {
            System.out.println("¡Login exitoso! La URL después del registro es: " + actualURL);
        } else {
            System.out.println("El login no se ha realizado con éxito. La URL actual es: " + actualURL);
        }
    }


    @Then(": El login NO se puede realizar")
    public void elLoginNOSePuedeRealizar() {
        PagesFactory pagesFactory = PagesFactory.getInstance();
        LoginPage loginPage = pagesFactory.getLoginPage();
        String actualURL = loginPage.getURL();
        System.out.println("El login NO se ha realizado por ingresar una contraseña invalida. La URL actual es: " + actualURL);
    }

    @When(": Ingreso  {string} valido y {string} invalido")
    public void ingresoValidoYInvalido(String arg0, String arg1) {
        PagesFactory pagesFactory = PagesFactory.getInstance();
        LoginPage loginPage = pagesFactory.getLoginPage();
        loginPage.ingresarContraseñaInvalida();
    }
}
