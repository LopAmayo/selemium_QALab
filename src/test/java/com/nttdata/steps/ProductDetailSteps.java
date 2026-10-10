package com.nttdata.steps;

import com.nttdata.page.LoginPage;
import com.nttdata.page.ProductDetailPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductDetailSteps {
    private WebDriver webDriver;

    public ProductDetailSteps (WebDriver driver){
        this.webDriver = driver;
    }
    
    public void typeQuantity(Integer quantity){
        WebElement quantityInputElement = webDriver.findElement(ProductDetailPage.inputQuantity);
        quantityInputElement.clear();
        quantityInputElement.sendKeys(String.valueOf(quantity));
    }

    public void clicButtonAddCar (){
        this.webDriver.findElement(ProductDetailPage.buttonAddCar).click();
    }

    public void addCar (Integer quantity){
        typeQuantity(quantity);
        clicButtonAddCar();
    }
}
