package com.opencart.demo.components;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

@Getter
public class Products {
    private WebElement productImage;
    private WebElement productNameWE;
    private String productName;
    private String description;
    private String productPriceCurrent;
    private Double productPriceCurrentAsDouble;
    private String productPriceOld;
    private double productPriceOldAsDouble;
    private String productTax;
    private Double productTaxAsDouble;
    private WebElement addToCartButton;
    private WebElement addToWishListButton;
    private WebElement compareThisProductButton;

    public Products() {
    }

    public Products(WebElement container) {
        this.productImage = container.findElement(By.xpath(".//div[@class='image']//img[@class='img-fluid']"));
        this.productNameWE = container.findElement(By.xpath(".//div[@class='description']//a"));
        this.productName = productNameWE.getText();
        this.description = container.findElement(By.xpath(".//div[@class='description']//p")).getText();
        this.productPriceCurrent = container.findElement(By.xpath(".//div[@class='price']//span[@class='price-new']")).getText();
        this.productPriceCurrentAsDouble = Double.parseDouble(productPriceCurrent.replace(productPriceCurrent.substring(0,1), "").replace(",", ""));

        try {
            this.productPriceOld = container.findElement(By.xpath(".//div[@class='price']//span[@class='price-old']")).getText();
        } catch (NoSuchElementException e) {
            this.productPriceOld = null;
        }

        try {
            this.productPriceOldAsDouble = Double.parseDouble(productPriceOld.replace(productPriceCurrent.substring(0, 1), "").replace(",", ""));
        } catch (Exception e){
            this.productPriceOldAsDouble = 0;
        }

        this.productTax = container.findElement(By.xpath(".//div[@class='price']//span[@class='price-tax']")).getText();
        try {
            this.productTaxAsDouble = productPriceTaxDouble();
        } catch (Exception e){
            this.productTaxAsDouble = Double.valueOf(0);
        }

        this.addToCartButton = container.findElement(By.xpath(".//div[@class='button-group']//button[@data-bs-original-title='Add to Cart']"));
        this.addToWishListButton = container.findElement(By.xpath(".//div[@class='button-group']//button[@data-bs-original-title='Add to Wish List']"));
        this.compareThisProductButton = container.findElement(By.xpath(".//div[@class='button-group']//button[@data-bs-original-title='Compare this Product']"));
    }

    public double productPriceTaxDouble() {
        StringBuilder number = new StringBuilder();
        for (int i = 0; i < this.productTax.length(); i++) {
            if (Character.isDigit(this.productTax.charAt(i)) || this.productTax.charAt(i)=='.') {
                number.append(this.productTax.charAt(i));
            }
        }
        return Double.parseDouble(String.valueOf(number));
    }

}
