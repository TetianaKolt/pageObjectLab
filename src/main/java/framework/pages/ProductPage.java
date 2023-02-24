package framework.pages;

import framework.components.TopMenuComponents;
import framework.enums.CurrencyListEnums;
import framework.helper.CurrencyHelpers;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static framework.helper.CurrencyHelpers.chooseCurrency;

@Log4j2
public class ProductPage extends BasePage {
    private final By mainPageTopMenuContainerLocator = By.id("top");
    private final By price = By.xpath("//h2/span[@class='price-new']");

    public TopMenuComponents getTopMenu() {
        return new TopMenuComponents(find(mainPageTopMenuContainerLocator));
    }

    // Change the currency and find the product price
    @Step("Get product price")
    public double getPrice(CurrencyListEnums currency) {
        getTopMenu().getCurrency().click();
        try {
            CurrencyHelpers.chooseCurrency(getTopMenu().getCurrencyList(), currency);
        }catch (org.openqa.selenium.StaleElementReferenceException ex){
            CurrencyHelpers.chooseCurrency(getTopMenu().getCurrencyList(),currency);
        }
        waitUntilPresent(price, 5);
        log.info("Get [price] in [currency] {}",currency);
        String priceStr = find(price).getText();
        double price;

        if (priceStr.contains("$")) {
            price = Double.parseDouble((priceStr.replace("$", "")).trim());
        } else if (priceStr.contains("€")) {
            price = Double.parseDouble((priceStr.replace("€", "")).trim());
        } else {
            price = Double.parseDouble((priceStr.replace("£", "")).trim());
        }
        return price;
    }


}
