package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.HomePage;
import com.hiberus.university.selenium.pages.PagesFactory;
import com.hiberus.university.selenium.pages.RegistroPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class registroStep {

    @Given(": Me encuentro en la pagina Home")
    public void meEncuentroEnLaPaginaHome() {
        PagesFactory pagesFactory= PagesFactory.getInstance();
        HomePage homePage= pagesFactory.getHomePage();
        homePage.navigateTo(HomePage.PAGE_URL);

    }

    @And(": Seleciono desde el menu de account la opcion de registro")
    public void selecionoDesdeElMenuDeAccountLaOpcionDeRegistro() {
        PagesFactory pagesFactory= PagesFactory.getInstance();
        HomePage homePage= pagesFactory.getHomePage();
        homePage.seleccionarOpcionRegistro();

    }

    @When(": Relleno todos los campos obligatorios")
    public void rellenoTodosLosCamposObligatorios() {
        PagesFactory pagesFactory=PagesFactory.getInstance();
        RegistroPage registroPage= pagesFactory.getRegistroPage();
        registroPage.rellenoLosCamposDataValida();
    }

    @And(": Hago click en el boton Continue")
    public void hagoClickEnElBotonContinue() {
        PagesFactory pagesFactory=PagesFactory.getInstance();
        RegistroPage registroPage= pagesFactory.getRegistroPage();
        registroPage.pulsarContinuar();
    }

    @Then(": El registro se realiza correctamente")
    public void elRegistroSeRealizaCorrectamente() {
        PagesFactory pagesFactory = PagesFactory.getInstance();
        RegistroPage registroPage = pagesFactory.getRegistroPage();
        String actualURL = registroPage.getURL();
        String expectedURL = "https://opencart.abstracta.us/index.php?route=account/success";
        Assert.assertEquals("No se ha podido realizar el registro exitoso", expectedURL, actualURL);
        if (actualURL.equals(expectedURL)) {
            System.out.println("¡Registro exitoso! La URL después del registro es: " + actualURL);
        } else {
            System.out.println("El registro no se ha realizado con éxito. La URL actual es: " + actualURL);
        }
    }
    @When(": Relleno todos los campos obligatorios con valores limites inferiores")
    public void relleno_todos_los_campos_obligatorios_con_valores_limites_inferiores() {
            PagesFactory pagesFactory = PagesFactory.getInstance();
            RegistroPage registroPage = pagesFactory.getRegistroPage();
            registroPage.camposLimitesInferiores();

    }
        @Then(": El registro No se puede realizar")
        public void el_registro_no_se_puede_realizar () {
            PagesFactory pagesFactory = PagesFactory.getInstance();
            RegistroPage registroPage = pagesFactory.getRegistroPage();
            registroPage.erroresLimtesCamposInferiores();
            String actualURL = registroPage.getURL();
            System.out.println("El registro NO se ha realizado. La URL actual es: " + actualURL);

    }
     @When(": Relleno todos los campos obligatorios con valores limites superiores")
        public void relleno_todos_los_campos_obligatorios_con_valores_limites_superiores() {
        PagesFactory pagesFactory = PagesFactory.getInstance();
        RegistroPage registroPage = pagesFactory.getRegistroPage();
        registroPage.camposLimitesSuperiores();
    }
    @Then(": El registro no se puede realizar exitosamente")
    public void el_registro_no_se_puede_realizar_exitosamente() {
        PagesFactory pagesFactory = PagesFactory.getInstance();
        RegistroPage registroPage = pagesFactory.getRegistroPage();
        registroPage.erroresLimtesCamposSuperiores();
        String actualURL = registroPage.getURL();
        System.out.println("El registro NO se ha realizado. La URL actual es: " + actualURL);
    }
}
