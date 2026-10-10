package com.nttdata.steps;

import com.nttdata.page.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.nttdata.core.DriverManager.esperaImplicita;

public class LoginSteps {
    private WebDriver webDriver;

    public LoginSteps (WebDriver driver){
        this.webDriver = driver;
    }

    public void viewLogin (){
        this.webDriver.findElement(LoginPage.buttonLogin).click();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.tittleLogin));
    }

    public void typeUser(String user){
        WebElement userInputElement = webDriver.findElement(LoginPage.inputEmail);
        userInputElement.clear();
        userInputElement.sendKeys(user);
    }

    public void typePassword(String password){
        WebElement passInputElement = webDriver.findElement(LoginPage.inputPassword);
        passInputElement.clear();
        passInputElement.sendKeys(password);
    }

    public void buttonLogin (){
        this.webDriver.findElement(LoginPage.buttonSubmit).click();
    }

    public void login (String user, String password){
        viewLogin ();
        typeUser(user);
        typePassword(password);
        esperaImplicita();
        buttonLogin ();
    }

    public String loginIncorret (){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(4));
        String text = wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.alertNotLogin)).getText();
        return text;
    }
}
