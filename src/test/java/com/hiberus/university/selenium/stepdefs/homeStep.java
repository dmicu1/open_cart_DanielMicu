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
    @Given("Me encuentro en la pagina Home")
    public void me_encuentro_en_la_pagina_home() {
        PagesFactory pagesFactory = PagesFactory.getInstance();
        HomePage homePage = pagesFactory.getHomePage();
        homePage.navigateTo(HomePage.PAGE_URL);
    }

    @When(": Abro el menu desplegable")
    public void abroElMenuDesplegable() {
        PagesFactory pagesFactory = PagesFactory.getInstance();
        HomePage homePage = pagesFactory.getHomePage();
        homePage.abrirMenuDesplegable();
    }

    @Then(": Se me redirecciona corectamente hacia la pagina de registro usuario")
    public void seMeRedireccionaCorectamenteHaciaLaPaginaDeRegistroUsuario() {
        PagesFactory pagesFactory = PagesFactory.getInstance();
        HomePage homePage = pagesFactory.getHomePage();
        homePage.pulsarParaPaginaRegistro();
        String actualURL = homePage.getURL();
        String expectedURL = "https://opencart.abstracta.us/index.php?route=account/register";
        Assert.assertEquals("No se ha podido navegar hacia la pagina", expectedURL, actualURL);
        if (actualURL.equals(expectedURL)) {
            System.out.println("Se ha navegado correctamente a la página de registro. URL actual:" + actualURL);
        } else {
            System.out.println("¡Error! No se ha navegado correctamente a la página de registro. URL actual: " + actualURL);
        }

    }

    @Then(": Se me redirecciona corectamente hacia la pagina de login")
    public void seMeRedireccionaCorectamenteHaciaLaPaginaDeLogin() {
        PagesFactory pagesFactory = PagesFactory.getInstance();
        HomePage homePage = pagesFactory.getHomePage();
        homePage.pulsarParaLogin();
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

