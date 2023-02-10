package com.opencart.demo.components;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@Getter
public class TopMenuComponents {

    private WebElement currency;
    private WebElement phoneNumber;
    private WebElement myAccountButton;
    private WebElement wishList;
    private WebElement shoppingCart;
    private WebElement checkout;


    public TopMenuComponents(WebElement container) {
        this.currency = container.findElement(By.xpath(".//form[@id='form-currency']"));
        this.phoneNumber = container.findElement(By.xpath(".//i[@class='fas fa-phone']/parent::a/parent::li[@class='list-inline-item']"));
        this.myAccountButton = container.findElement(By.xpath(".//i[@class='fas fa-user']/parent::a[@class='dropdown-toggle']"));
        this.wishList = container.findElement(By.xpath(".//i[@class='fas fa-heart']/parent::a[@id='wishlist-total']"));
        this.shoppingCart = container.findElement(By.xpath(".//i[@class='fas fa-shopping-cart']/parent::a[@title='Shopping Cart']"));
        this.checkout = container.findElement(By.xpath(".//a[@title='Checkout']"));
    }
}
