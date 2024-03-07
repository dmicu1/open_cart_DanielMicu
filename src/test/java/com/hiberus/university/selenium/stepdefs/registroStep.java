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


    @When(": Relleno todos los campos obligatorios")
    public void rellenoTodosLosCamposObligatorios() {
        PagesFactory pagesFactory = PagesFactory.getInstance();
        RegistroPage registroPage = pagesFactory.getRegistroPage();
        registroPage.rellenoLosCamposDataValida();
    }

    @And(": Hago click en el boton Continue")
    public void hagoClickEnElBotonContinue() {
        PagesFactory pagesFactory = PagesFactory.getInstance();
        RegistroPage registroPage = pagesFactory.getRegistroPage();
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

    @When(": Relleno los campos FirstName,LastName,Telephone,Password")
    public void rellenoLosCamposFirstNameLastNameTelephonePassword() {
        PagesFactory pagesFactory = PagesFactory.getInstance();
        RegistroPage registroPage = pagesFactory.getRegistroPage();
        registroPage.camposLimitesInferiores();
    }

    @Then(": Los mensajes se disparan correctamente")
    public void losMensajesSeDisparanCorrectamente() {
        PagesFactory pagesFactory = PagesFactory.getInstance();
        RegistroPage registroPage = pagesFactory.getRegistroPage();
        registroPage.erroresLimtesCamposInferiores();
    }

    @When(": Relleno los siguentes camposFirstName,LastName,Telephone,Password")
    public void rellenoLosSiguentesCamposFirstNameLastNameTelephonePassword() {
        PagesFactory pagesFactory = PagesFactory.getInstance();
        RegistroPage registroPage = pagesFactory.getRegistroPage();
        registroPage.camposLimitesSuperiores();
    }


    @Then(": Los mensajes de error se disparan correctamenete")
    public void losMensajesDeErrorSeDisparanCorrectamenete() {
        PagesFactory pagesFactory = PagesFactory.getInstance();
        RegistroPage registroPage = pagesFactory.getRegistroPage();
        registroPage.erroresLimtesCamposSuperiores();

//        Descripción del Bug:
//
//        Ubicación: Campo de Contraseña
//
//        Descripción: Se esperaba que se activara el mensaje de error cuando se ingresaban más de 32 caracteres
//        en el campo de contraseña. Sin embargo, el mensaje de error no se activó como se esperaba.
//                Impacto Potencial: Este problema podría resultar en una experiencia de usuario confusa,
//        ya que no se proporciona retroalimentación cuando se excede el límite de caracteres
//        establecido para el campo de contraseña. Esto podría llevar a que los usuarios intenten ingresar contraseñas
//        largas sin darse cuenta de que están excediendo el límite permitido.
//                Pasos para Reproducir:
//
//        Ingresar más de 32 caracteres en el campo de contraseña.
//        Observar la falta de aparición del mensaje de error correspondiente.
//        Resultado Esperado: Se espera que aparezca un mensaje de error indicando que se han
//        excedido los límites de caracteres para el campo de contraseña.
//
//        Resultado Actual: El mensaje de error no se muestra cuando se ingresan más de
//        32 caracteres en el campo de contraseña.
    }
}
