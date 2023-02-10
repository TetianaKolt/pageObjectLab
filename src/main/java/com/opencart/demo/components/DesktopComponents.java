package com.opencart.demo.components;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

@Getter
public class DesktopComponents {
    private WebElement productImage;
    private WebElement productNameWE;
    private String productName;
    private String description;
    private String productPriceCurrent;
    private double productPriceCurrentAsDouble;
    private String productPriceOld;
    private String productTax;
    private WebElement addToCartButton;
    private WebElement addToWishListButton;
    private WebElement compareThisProductButton;

    public DesktopComponents() {
    }

    public DesktopComponents(WebElement container) {
        this.productImage = container.findElement(By.xpath(".//div[@class='image']//img[@class='img-fluid']"));
        this.productNameWE = container.findElement(By.xpath(".//div[@class='description']//a"));
        this.productName = productNameWE.getText();
        this.description = container.findElement(By.xpath(".//div[@class='description']//p")).getText();
        this.productPriceCurrent = container.findElement(By.xpath(".//div[@class='price']//span[@class='price-new']")).getText();
        this.productPriceCurrentAsDouble = Double.parseDouble(productPriceCurrent.replace("$", "").replace(",", ""));
        try {
            this.productPriceOld = container.findElement(By.xpath(".//div[@class='price']//span[@class='price-old']")).getText();
        } catch (NoSuchElementException e) {
            this.productPriceOld = null;
        }

        this.productTax = container.findElement(By.xpath(".//div[@class='price']//span[@class='price-tax']")).getText();
        this.addToCartButton = container.findElement(By.xpath(".//div[@class='button-group']//button[@data-bs-original-title='Add to Cart']"));
        this.addToWishListButton = container.findElement(By.xpath(".//div[@class='button-group']//button[@data-bs-original-title='Add to Wish List']"));
        this.compareThisProductButton = container.findElement(By.xpath(".//div[@class='button-group']//button[@data-bs-original-title='Compare this Product']"));
    }

    public double productPriceCurrentInt() {
        StringBuilder number = new StringBuilder();
        for (int i = 0; i < this.productPriceCurrent.length(); i++) {
            if (Character.isDigit(this.productPriceCurrent.charAt(i))) {
                number.append(this.productPriceCurrent.charAt(i));
            }
        }
        return Integer.parseInt(String.valueOf(number));
    }
}
