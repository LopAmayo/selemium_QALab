package com.nttdata.steps;

import com.nttdata.page.HomePage;
import com.nttdata.page.SubCategoryPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomeSteps {
    private WebDriver webDriver;

    public HomeSteps (WebDriver driver){
        this.webDriver = driver;
    }

    public String redirectedHome (){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        String text = wait.until(ExpectedConditions.visibilityOfElementLocated(HomePage.userHome)).getText();
        return text;
    }

    public void buttonCategoryClothes (){
        this.webDriver.findElement(HomePage.categoryClotes).click();
    }
}
