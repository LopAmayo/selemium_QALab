package com.nttdata.page;

import org.openqa.selenium.By;

public class LoginPage {
    public static By buttonLogin = By.xpath("//div[@class='user-info']/a");
    public static By tittleLogin = By.xpath("//header[@class = 'page-header']/h1");
    public static By inputEmail = By.id("field-email");
    public static By inputPassword = By.id("field-password");
    public static By buttonSubmit = By.id("submit-login");
    public static By alertNotLogin = By.xpath("//li[@class = 'alert alert-danger']");

}
