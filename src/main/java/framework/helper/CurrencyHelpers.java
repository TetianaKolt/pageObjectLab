package framework.helper;

import framework.components.TopMenuComponents;
import framework.enums.CurrencyListEnums;
import framework.pages.BasePage;
import framework.pages.ProductPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CurrencyHelpers {

    private static final By currencyListLocator = By.xpath("//nav[@id='top']//div[@class='nav float-start']//div[@class='dropdown']/ul/li/a");

    // Get the list of currencies
//    public static List<WebElement> getAllCurrencies() {
//        return BasePage.findAll(currencyListLocator);
//    }

    // Choose currency
    public static void chooseCurrency(List<WebElement> currencyList, CurrencyListEnums currencyEnum) {
        for (WebElement currencyListItem : currencyList) {
            if (currencyListItem.getText().contains(currencyEnum.getCurrency())) {
                currencyListItem.click();
            }
        }
    }

    // Get digits from String
    public static double productPriceAsDouble(String price) {
        StringBuilder number = new StringBuilder();
        for (int i = 0; i < price.length(); i++) {
            if (Character.isDigit(price.charAt(i)) || price.charAt(i) == '.') {
                number.append(price.charAt(i));
            }
        }
        return Double.parseDouble(String.valueOf(number));
    }
}
