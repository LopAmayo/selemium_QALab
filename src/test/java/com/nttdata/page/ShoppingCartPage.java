package com.nttdata.page;

import org.openqa.selenium.By;

public class ShoppingCartPage {
    public static By titleShoppingCart = By.xpath("//div[@class = 'card-block']/h1");
    public static By totalPriceShoppingCart = By.xpath("//div[@class = 'cart-summary-line cart-total']/span[2]");
}
