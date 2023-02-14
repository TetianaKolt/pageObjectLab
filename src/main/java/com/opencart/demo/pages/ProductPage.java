package com.opencart.demo.pages;

import com.opencart.demo.components.TopMenuComponents;
import com.opencart.demo.enums.CurrencyListEnums;
import com.opencart.demo.helper.Helpers;
import org.openqa.selenium.By;

public class ProductPage extends BasePage {

    private final By mainPageTopMenuContainerLocator = By.id("top");
    private final By price = By.xpath("//h2/span[@class='price-new']");

    public TopMenuComponents getTopMenu() {
        return new TopMenuComponents(getDriver().findElement(mainPageTopMenuContainerLocator));
    }

    // Change the currency and find the product price

    public double getPrice(CurrencyListEnums currency) {
        getTopMenu().getCurrency().click();
        Helpers.chooseCurrency(getTopMenu().getCurrencyList(), currency).click();
        waitUntilPresent(price, 5);
        waitUntilPageIsLoaded();
        String priceStr = find(price).getText();
//        return Double.parseDouble((priceStr.replace(priceStr.substring(0, 1), "")));
        double price;
        if(priceStr.contains("$")){
            price = Double.parseDouble((priceStr.replace("$", "")).trim());
        } else if (priceStr.contains("€")) {
            price = Double.parseDouble((priceStr.replace("€", "")).trim());
        }else {
            price = Double.parseDouble((priceStr.replace("£", "")).trim());
        }
        return price;
    }


}
