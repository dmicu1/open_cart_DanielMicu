package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.HomePage;
import com.hiberus.university.selenium.pages.PagesFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class homeStep {
    @Given("Me encuentro en la pagina Home")
    public void me_encuentro_en_la_pagina_home() {
        PagesFactory pagesFactory= PagesFactory.getInstance();
        HomePage homePage= pagesFactory.getHomePage();
        homePage.navigateTo(HomePage.PAGE_URL);
}

    @And("Seleciono desde el menu de account la opcion de registro")
    public void selecionoDesdeElMenuDeAccountLaOpcionDeRegistro() {
        PagesFactory pagesFactory= PagesFactory.getInstance();
        HomePage homePage= pagesFactory.getHomePage();
        homePage.seleccionarOpcionRegistro();
    }

    @And("Seleciono desde el menu de account la opcion de login")
    public void selecionoDesdeElMenuDeAccountLaOpcionDeLogin() {
        PagesFactory pagesFactory= PagesFactory.getInstance();
        HomePage homePage= pagesFactory.getHomePage();
        homePage.seleccionarOpcionLogin();
    }
}

