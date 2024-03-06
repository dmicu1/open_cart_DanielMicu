package com.hiberus.university.selenium.stepdefs;


import com.hiberus.university.selenium.pages.CestaPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class cestaStep {

    @When(": Accedo a la seccion Mp3 Players")
    public void accedoALaSeccionMp3Players() {
        PagesFactory pagesFactory = PagesFactory.getInstance();
        CestaPage cestaPage = pagesFactory.getCestaPage();
        cestaPage.accederListaMp3();
    }

    @And(": Selecciono al azar {int} productos")
    public void seleccionoAlAzarProductos(int arg0) {
        PagesFactory pagesFactory = PagesFactory.getInstance();
        CestaPage cestaPage = pagesFactory.getCestaPage();
        cestaPage.capturarDosProductosAlAzar(pagesFactory.getDriver());
    }

    @Then(": Los productos se agregaron correctamente a la cesta")
    public void losProductosSeAgregaronCorrectamenteALaCesta() throws InterruptedException {
        PagesFactory pagesFactory = PagesFactory.getInstance();
        CestaPage cestaPage = pagesFactory.getCestaPage();
        cestaPage.validarCesta();
    }

    @When(": Elimino los productos agregados previamente")
    public void eliminoLosProductosAgregadosPreviamente() {
        PagesFactory pagesFactory = PagesFactory.getInstance();
        CestaPage cestaPage = pagesFactory.getCestaPage();
        cestaPage.eliminarLosProductos();
    }

    @Then(": Los productos se eliminan correctamente")
    public void losProductosSeEliminanCorrectamente() {
        PagesFactory pagesFactory = PagesFactory.getInstance();
        CestaPage cestaPage = pagesFactory.getCestaPage();
        cestaPage.validarCestaVacia();

    }


}
