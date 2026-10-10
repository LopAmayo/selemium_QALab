package com.nttdata.steps;

import com.nttdata.page.LoginPage;
import com.nttdata.page.ModalProductCarPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ModalProductCarSteps {
    private WebDriver webDriver;

    public ModalProductCarSteps (WebDriver driver){
        this.webDriver = driver;
    }

    public String messajeAddCheckProduct (){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(4));
        String textConfirmation = wait.until(ExpectedConditions.visibilityOfElementLocated(ModalProductCarPage.titeModal)).getText();
        return textConfirmation.substring(1).trim();
    }

    public int getQuantity() {
        String quantityText = webDriver.findElement(ModalProductCarPage.quantityProduct).getText();
        return Integer.parseInt(quantityText.trim());
    }

    public double getUnitPrice() {
        String priceText = webDriver.findElement(ModalProductCarPage.priceProduct).getText();
        String cleanPrice = priceText.replace(",", ".").replaceAll("[^0-9.]", "");
        return Double.parseDouble(cleanPrice);
    }

    public double getTotalPrice() {
        String totalText = webDriver.findElement(ModalProductCarPage.totalPriceProduct).getText();
        String cleanTotal = totalText.replace(",", ".").replaceAll("[^0-9.]", "");
        return Double.parseDouble(cleanTotal);
    }
    public void cLicButtonEndBuy (){
        this.webDriver.findElement(ModalProductCarPage.buttonEndBuy).click();
    }
}
