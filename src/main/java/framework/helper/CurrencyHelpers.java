package framework.helper;

import framework.enums.CurrencyListEnums;
import framework.pages.BasePage;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CurrencyHelpers {

    // Choose currency
    public static void chooseCurrency(List<WebElement> currencyList, CurrencyListEnums currencyEnum) {
        for (WebElement currencyListItem : currencyList) {
            if (currencyListItem.getText().contains(currencyEnum.getCurrency())) {
                currencyListItem.click();
                return;
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
