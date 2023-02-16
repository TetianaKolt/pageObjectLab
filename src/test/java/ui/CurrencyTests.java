package ui;

import com.opencart.demo.components.Products;
import com.opencart.demo.enums.CurrencyListEnums;
import com.opencart.demo.pages.MainPage;
import com.opencart.demo.pages.ProductPage;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static com.opencart.demo.helper.CurrencyHelpers.chooseCurrency;
import static com.opencart.demo.helper.Helpers.findProductByName;

public class CurrencyTests extends BaseTest {

    private final MainPage mainPage = new MainPage();

    @Test //Test #4
    public void changeCurrencyTest() {
        SoftAssertions softAssertions = new SoftAssertions();
        ProductPage productPage = new ProductPage();
        String expectedCurrencySymbolByDefault = "$";
        double expectedProductPriceUSD = 123.20;
        double expectedProductPriceEUR = 106.04;
        double expectedProductPricePOUNDS = 95.32;

        // Check the currency symbol by default
        String actualCurrencySymbol = mainPage.getTopMenu()
                .getCurrencySymbol();

        softAssertions.assertThat(actualCurrencySymbol)
                .as("The currency symbol is not as expected")
                .isEqualTo(expectedCurrencySymbolByDefault);

        // if currency symbol is not $, change it
        mainPage.checkCurrencySymbolChangeIfNot(CurrencyListEnums.US_DOLLAR);

        // Find the iPhone and click
        List<Products> products = mainPage.getAllProducts();
        mainPage.findProductByNameClick(products, "iPhone");

        double actualPriceUSD = productPage.getPrice(CurrencyListEnums.US_DOLLAR);
        // Check the price
        softAssertions.assertThat(actualPriceUSD)
                .as("The price in DOLLARS differs from expected")
                .isEqualTo(expectedProductPriceUSD);


        // Change currency to euro
        List<WebElement> currencyList = productPage.getTopMenu().getCurrencyList();
//        productPage.getTopMenu()
//                .getCurrency()
//                .click();
        chooseCurrency(currencyList, CurrencyListEnums.EURO);

        // Check that price 106.04

        double actualPriceEUR = productPage.getPrice(CurrencyListEnums.EURO);
        softAssertions.assertThat(actualPriceEUR)
                .as("The price in EUR is not as expected")
                .isEqualTo(expectedProductPriceEUR);

        //Change currency to Pound Sterling
        productPage.getTopMenu()
                .getCurrency()
                .click();
        chooseCurrency(currencyList, CurrencyListEnums.POUND_STERLING);

        //Check that price is 95.32
        double actualPricePOUNDS = productPage.getPrice(CurrencyListEnums.POUND_STERLING);
        softAssertions.assertThat(actualPricePOUNDS)
                .as("The price in POUNDS is not as expected")
                .isEqualTo(expectedProductPricePOUNDS);



        softAssertions.assertAll();
    }
}
