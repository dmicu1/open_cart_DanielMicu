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

    @FindBy(xpath = "//span[text()='Add to Cart']")

    private WebElement listaProductos;
    @FindBy(xpath = "//a[text()='MP3 Players']")
    private WebElement menuMp3;
    @FindBy(xpath = "//a[text()='Show All MP3 Players']")
    private WebElement todosLosMP3;
    public void accederListaMp3() {
        menuMp3.click();
        todosLosMP3.click();
    }
    public void agregarESteProducto(){
        listaProductos.click();
    }
//    public List<WebElement> capturarTresProductosAlAzar(WebDriver driver) {
//        wait.until(ExpectedConditions.visibilityOf(listaProductos)).isDisplayed();
//        // Esperar a que se carguen los productos
//
//        // Encontrar todos los elementos de la lista de productos
//        List<WebElement> elementosLista = driver.findElements(By.xpath("//button[contains(@onclick, 'cart.add')]"));
//
//        // Verificar si hay menos de tres productos en la lista
//        if (elementosLista.size() < 3) {
//            throw new IllegalStateException("La lista de productos no tiene suficientes elementos.");
//        }
//
//        // Capturar tres productos al azar de la lista
//        List<WebElement> tresProductos = new ArrayList<>();
//        Random random = new Random();
//        for (int i = 0; i < 3; i++) {
//            int indiceAleatorio = random.nextInt(elementosLista.size());
//            tresProductos.add(elementosLista.get(indiceAleatorio));
//            elementosLista.remove(indiceAleatorio); // Evitar duplicados
//        }
//
//        return tresProductos;
//    }
}