package com.nttdata.steps;

import com.nttdata.page.LoginPage;
import com.nttdata.page.ModalProductCarPage;
import com.nttdata.page.ShoppingCartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShoppingCartSteps {
    private WebDriver webDriver;

    public ShoppingCartSteps (WebDriver driver){
        this.webDriver = driver;
    }

    public String validateTitleShoppingCart (){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        String textTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(ShoppingCartPage.titleShoppingCart)).getText();
        return textTitle;
    }

    public double getTotalPriceShoppingCart() {
        String totalText = webDriver.findElement(ShoppingCartPage.totalPriceShoppingCart).getText();
        String cleanTotal = totalText.replace(",", ".").replaceAll("[^0-9.]", "");
        return Double.parseDouble(cleanTotal);
    }
}
