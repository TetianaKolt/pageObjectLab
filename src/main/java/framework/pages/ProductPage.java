package framework.pages;

import framework.components.TopMenuComponents;
import framework.enums.CurrencyListEnums;
import framework.helper.CurrencyHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductPage extends BasePage {
    private final By mainPageTopMenuContainerLocator = By.id("top");
    private final By price = By.xpath("//h2/span[@class='price-new']");

    public TopMenuComponents getTopMenu() {
        return new TopMenuComponents(find(mainPageTopMenuContainerLocator));
    }

    // Change the currency and find the product price

    public double getPrice(CurrencyListEnums currency) {
        WebElement currencyList = getTopMenu().getCurrency();
        currencyList.click();
        CurrencyHelpers.chooseCurrency(getTopMenu().getCurrencyList(), currency);
        waitUntilPresent(price, 5);
        waitUntilPageIsLoaded();
        String priceStr = find(price).getText();
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
