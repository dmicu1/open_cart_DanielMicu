package com.hiberus.university.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.*;

public class CompraPage extends BasePage {
    public CompraPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getURL() {
        return getDriver().getCurrentUrl();
    }

    @FindBy(xpath = "//div[@class='button-group']//child::i[@class='fa fa-shopping-cart']")
    WebElement listaProductos;
    @FindBy(xpath ="//div[@class='alert alert-success alert-dismissible']")
    WebElement mensajeExitosoCompra;
    @FindBy(xpath = "//a[text()='MP3 Players']")
    private WebElement menuMp3;
   @FindBy(xpath = "//span[@id='cart-total']")
   WebElement cartTotalElement;

    @FindBy(xpath = "//div[@id='cart']//child::button[class='btn btn-inverse btn-block btn-lg dropdown-toggle']")
    private WebElement irAlCarito;
    @FindBy(xpath = "//a[text()='Show All MP3 Players']")
    private WebElement todosLosMP3;
    @FindBy(xpath = "//button[@title='Remove']")
    private WebElement eliminarProductos;
    public void accederListaMp3() {
        menuMp3.click();
        todosLosMP3.click();
    }

    public void capturarDosProductosAlAzar(WebDriver driver) {

            // Encontrar todos los elementos de la lista de productos
            List<WebElement> productos = driver.findElements(By.xpath("//div[@class='button-group']//child::i[@class='fa fa-shopping-cart']"));
            // Generar dos índices únicos al azar
            Random random = new Random();
            int indice1 = random.nextInt(productos.size());
            int indice2;
            do {
                indice2 = random.nextInt(productos.size());
            } while (indice2 == indice1);

            // Hacer clic en los dos productos correspondientes a los índices seleccionados
            productos.get(indice1).click();
            productos.get(indice2).click();
        }
        public void validarCompra(){
            //Validar que aparece el mensaje de error
            wait.until(ExpectedConditions.visibilityOf(mensajeExitosoCompra)).isDisplayed();
            if (mensajeExitosoCompra.isDisplayed()) {
                System.out.println("El mensaje que aparece al agregar un producto es: Success: You have added .");
            } else {
                System.out.println("¡Error! El mensaje NO esta presente");
            }
            //Obtener numero de productos de la cesta
            String cartTotalText = cartTotalElement.getText();
            System.out.println("Texto dentro del elemento cart-total: " + cartTotalText);

//            //Eliminar los productos previamente agregados
//            irAlCarito.click();
//            eliminarProductos.click();
//            eliminarProductos.click();
            }

    }
