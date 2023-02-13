package com.opencart.demo.components;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

@Getter
public class TopMenuComponents {
    private WebElement currency;
    private String currencySymbol;
    private List<WebElement> currencyList;
    private WebElement phoneNumber;
    private WebElement myAccountButton;
    private WebElement wishList;
    private WebElement shoppingCart;
    private WebElement checkout;

    public TopMenuComponents() {
    }

    public TopMenuComponents(WebElement container) {
        this.currency = container.findElement(By.xpath(".//form[@id='form-currency']"));
        this.currencySymbol = container.findElement(By.xpath(".//*[@id='form-currency']/div/a/strong")).getText();
        this.currencyList = container.findElements(By.xpath(".//ul[@class='dropdown-menu show']//a[@class='dropdown-item']"));
        this.phoneNumber = container.findElement(By.xpath(".//i[@class='fas fa-phone']/parent::a/parent::li[@class='list-inline-item']"));
        this.myAccountButton = container.findElement(By.xpath(".//i[@class='fas fa-user']/parent::a[@class='dropdown-toggle']"));
        this.wishList = container.findElement(By.xpath(".//i[@class='fas fa-heart']/parent::a[@id='wishlist-total']"));
        this.shoppingCart = container.findElement(By.xpath(".//i[@class='fas fa-shopping-cart']/parent::a[@title='Shopping Cart']"));
        this.checkout = container.findElement(By.xpath(".//a[@title='Checkout']"));
    }
}
