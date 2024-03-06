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
import org.openqa.selenium.WebElement;

public class compraStep {

    @When(": Accedo a la seccion Mp3 Players")
    public void accedoALaSeccionMp3Players() {
        PagesFactory pagesFactory = PagesFactory.getInstance();
        CompraPage compraPage = pagesFactory.getCompraPage();
        compraPage.accederListaMp3();
    }

    @And(": Selecciono al azar {int} productos")
    public void seleccionoAlAzarProductos(int arg0) {
        PagesFactory pagesFactory = PagesFactory.getInstance();
        CompraPage compraPage = pagesFactory.getCompraPage();
        compraPage.capturarDosProductosAlAzar(pagesFactory.getDriver());
    }

    @Then(": Los productos se agregaron correctamente a la cesta")
    public void losProductosSeAgregaronCorrectamenteALaCesta() throws InterruptedException {
        PagesFactory pagesFactory = PagesFactory.getInstance();
        CompraPage compraPage = pagesFactory.getCompraPage();
        compraPage.validarCompra();
    }

    @When(": Elimino los productos agregados previamente")
    public void eliminoLosProductosAgregadosPreviamente() {
        PagesFactory pagesFactory = PagesFactory.getInstance();
        CompraPage compraPage = pagesFactory.getCompraPage();
        compraPage.eliminarLosProductos();
    }

    @Then(": Los productos se eliminan correctamente")
    public void losProductosSeEliminanCorrectamente() {
        PagesFactory pagesFactory = PagesFactory.getInstance();
        CompraPage compraPage = pagesFactory.getCompraPage();
        compraPage.validarCestaVacia();

    }


}
