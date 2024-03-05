package com.hiberus.university.selenium.stepdefs;


import com.hiberus.university.selenium.pages.CompraPage;
import com.hiberus.university.selenium.pages.HomePage;
import com.hiberus.university.selenium.pages.PagesFactory;
import com.hiberus.university.selenium.pages.RegistroPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class compraStep {

    @When(": Accedo a la seccion Mp3 Players")
    public void accedoALaSeccionMp3Players() {
        PagesFactory pagesFactory= PagesFactory.getInstance();
        CompraPage compraPage= pagesFactory.getCompraPage();
        compraPage.accederListaMp3();
    }

    @And(": Selecciono al azar {int} productos")
    public void seleccionoAlAzarProductos(int arg0) {
        PagesFactory pagesFactory= PagesFactory.getInstance();
        CompraPage compraPage= pagesFactory.getCompraPage();
        compraPage.agregarESteProducto();
    }

    @Then(": Los productos se agregaron correctamente a la cesta")
    public void losProductosSeAgregaronCorrectamenteALaCesta() {

    }
}
