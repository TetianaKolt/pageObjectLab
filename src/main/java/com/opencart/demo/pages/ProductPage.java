package com.opencart.demo.pages;

import com.opencart.demo.components.TopMenuComponents;
import com.opencart.demo.enums.CurrencyList;
import com.opencart.demo.helper.Helpers;
import org.openqa.selenium.By;

public class ProductPage extends BasePage {

    private final By mainPageTopMenuContainerLocator = By.id("top");
    private final By price = By.xpath("//h2/span[@class='price-new']");

    public TopMenuComponents getTopMenu() {
        return new TopMenuComponents(getDriver().findElement(mainPageTopMenuContainerLocator));
    }

    // Change the currency and find the product price

    public double getPrice(Enum<CurrencyList> currency) {
        getTopMenu().getCurrency().click();
        Helpers.chooseCurrency(getTopMenu().getCurrencyList(), currency);
        waitUntilPresent(price, 5);
        ////// The price isn't changed here below:
        String priceStr = find(price).getText();
        return Double.parseDouble(priceStr.replace(priceStr.substring(0, 1), ""));
    }


}
