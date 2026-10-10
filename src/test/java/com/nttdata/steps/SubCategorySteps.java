package com.nttdata.steps;

import com.nttdata.page.HomePage;
import com.nttdata.page.LoginPage;
import com.nttdata.page.SubCategoryPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SubCategorySteps {
    private WebDriver webDriver;

    public SubCategorySteps (WebDriver driver){
        this.webDriver = driver;
    }

    public void buttonSubCategoryClothes (){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        WebElement btnSubCategory = wait.until(ExpectedConditions.visibilityOfElementLocated(SubCategoryPage.titleSubCategoryMen));
        btnSubCategory.click();
    }

    public void clicCardProduct (){
        this.webDriver.findElement(SubCategoryPage.clicProducto).click();
    }

    public void SelectProduct (){
        buttonSubCategoryClothes ();
        clicCardProduct ();
    }
}
