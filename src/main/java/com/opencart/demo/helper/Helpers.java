package com.opencart.demo.helper;

import com.opencart.demo.components.Products;
import com.opencart.demo.enums.CurrencyListEnums;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Helpers {

    // Gets a list product names
    public static List<String> getNamesFromProductList(List<Products> actualProductsList) {
        List<String> actualProductNamesList = new ArrayList<>();
        for (Products dc : actualProductsList) {
            actualProductNamesList.add(dc.getProductName().toLowerCase());
        }
        return actualProductNamesList;
    }

    // GETS LIST OF STRINGS FROM LIST OF WEB ELEMENTS
    public static List<String> getStringsFromList(List<WebElement> listOfWebElements) {
        List<String> names = new ArrayList<>();
        for (WebElement we : listOfWebElements) {
            names.add(we.getText());
        }
        return names;
    }

    // Gets Prices from List of Web Elements
    public static List<Double> getPricesFromList(List<Products> actualProductsList) {
        List<Double> actualPricesList = new ArrayList<>();
        for (Products dc : actualProductsList) {
            actualPricesList.add(dc.getProductPriceCurrentAsDouble());
        }
        return actualPricesList;
    }


    //Finds product from the list by Name
    public static Products findProductByName(List<Products> listOfProducts, String nameToFind) {
        Products foundProduct = new Products();
        for (Products product : listOfProducts) {
            if (product.getProductName().equalsIgnoreCase(nameToFind)) {
                foundProduct = product;
            }
        }
        return foundProduct;
    }

    // Choose currency
    public static WebElement chooseCurrency(List<WebElement> currencyList, CurrencyListEnums currencyEnum) {
        WebElement currencyToClickAt = currencyList.get(1);
        for (WebElement currencyListItem : currencyList) {
            if (currencyListItem.getText().equals(currencyEnum.getCurrency())) {
                currencyToClickAt = currencyListItem;
            }
        }return currencyToClickAt;
    }
}