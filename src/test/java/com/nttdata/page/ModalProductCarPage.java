package com.nttdata.page;

import org.openqa.selenium.By;

public class ModalProductCarPage {
    public static By titeModal = By.id("myModalLabel");
    public  static By priceProduct = By.xpath("//p[@class = 'product-price']");
    public static By quantityProduct = By.xpath("//span[@class = 'product-quantity']/strong");
    public static By totalPriceProduct = By.xpath("//p[@class = 'product-total']/span[@class = 'value']");
    public static By buttonEndBuy = By.xpath("//div[@class='cart-content-btn']//a[contains(., 'Finalizar compra')]");
}
