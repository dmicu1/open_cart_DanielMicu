package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.HomePage;
import com.hiberus.university.selenium.pages.PagesFactory;
import com.hiberus.university.selenium.pages.RegistroPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class homeStep {
    @Given(": Me encuentro en la pagina Home")
    public void meEncuentroEnLaPaginaHome() {
        PagesFactory pagesFactory = PagesFactory.getInstance();
        HomePage homePage = pagesFactory.getHomePage();
        homePage.navigateTo(homePage.PAGE_URL);
    }
    @When(": Seleciono desde el menu de account la opcion de registro")
    public void selecionoDesdeElMenuDeAccountLaOpcionDeRegistro() {
        PagesFactory pagesFactory = PagesFactory.getInstance();
        HomePage homePage = pagesFactory.getHomePage();
        homePage.seleccionarOpcionRegistro();

    }

    @Then(": Se me redirecciona corectamente hacia la pagina de registro usuario")
    public void seMeRedireccionaCorectamenteHaciaLaPaginaDeRegistroUsuario() {
        PagesFactory pagesFactory = PagesFactory.getInstance();
        HomePage homePage = pagesFactory.getHomePage();
        String actualURL = homePage.getURL();
        String expectedURL = "https://opencart.abstracta.us/index.php?route=account/register";
        Assert.assertEquals("No se ha podido navegar hacia la pagina", expectedURL, actualURL);
        if (actualURL.equals(expectedURL)) {
            System.out.println("Se ha navegado correctamente a la página de registro. URL actual:" + actualURL);
        } else {
            System.out.println("¡Error! No se ha navegado correctamente a la página de registro. URL actual: " + actualURL);
        }

    }
    @When(": Seleciono desde el menu de account la opcion de login")
    public void seleciono_desde_el_menu_de_account_la_opcion_de_login() {
        PagesFactory pagesFactory = PagesFactory.getInstance();
        HomePage homePage = pagesFactory.getHomePage();
        homePage.seleccionarOpcionLogin();
    }

    @Then(": Se me redirecciona corectamente hacia la pagina de login")
    public void seMeRedireccionaCorectamenteHaciaLaPaginaDeLogin() {
        PagesFactory pagesFactory = PagesFactory.getInstance();
        HomePage homePage = pagesFactory.getHomePage();
        String actualURL = homePage.getURL();
        String expectedURL = "https://opencart.abstracta.us/index.php?route=account/login";
        Assert.assertEquals("No se ha podido navegar hacia la pagina de Login", expectedURL, actualURL);
        if (actualURL.equals(expectedURL)) {
            System.out.println("Se ha navegado correctamente a la página de Login. URL actual:" + actualURL);
        } else {
            System.out.println("¡Error! No se ha navegado correctamente a la página de Login. URL actual: " + actualURL);
        }
    }


}

