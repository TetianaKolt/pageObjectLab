package ui;

import com.opencart.demo.components.Products;
import com.opencart.demo.enums.CurrencyList;
import com.opencart.demo.helper.Helpers;
import com.opencart.demo.pages.MainPage;
import com.opencart.demo.pages.ProductPage;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

import java.util.List;

import static com.opencart.demo.helper.Helpers.findProductByName;

public class MainPageTests extends BaseTest {

    MainPage mainPage = new MainPage();
    SoftAssertions softAssertions;


    @Test(groups = {"Check currency and prices"})  //Test #4
    public void changeCurrencyTest() {
        softAssertions = new SoftAssertions();
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
        mainPage.checkCurrencySymbolChangeIfNot(CurrencyList.US_DOLLAR);

        // Find the iPhone and click
        List<Products> products = mainPage.getAllProducts();
        mainPage.findProductByNameClick(products, "iPhone");

        double actualPriceUSD = productPage.getPrice(CurrencyList.US_DOLLAR);
        // Check the price
        softAssertions.assertThat(actualPriceUSD)
                .as("The price in DOLLARS differs from expected")
                .isEqualTo(expectedProductPriceUSD);


        // Change currency to euro
        productPage.getTopMenu()
                .getCurrency()
                .click();


        // Check that price 106.04

        double actualPriceEUR = productPage.getPrice(CurrencyList.EURO);
        softAssertions.assertThat(actualPriceEUR)
                .as("The price in EUR is not as expected")
                .isEqualTo(expectedProductPriceEUR);

        //Change currency to Pound Sterling
        productPage.getTopMenu()
                .getCurrency()
                .click();

        //Check that price is 95.32
        double actualPricePOUNDS = productPage.getPrice(CurrencyList.POUND_STERLING);
        softAssertions.assertThat(actualPricePOUNDS)
                .as("The price in POUNDS is not as expected")
                .isEqualTo(expectedProductPricePOUNDS);

        softAssertions.assertAll();
    }

    @Test(groups = {"Check product attributes"})// Test #5
    public void checkGroupOfProductsCameras() {
        softAssertions = new SoftAssertions();

        mainPage.getNavigationBar()
                .getCameras()
                .click();

        //Check that 2 cameras exist on page
        int expectedProductQntt = 2;
        int actualProductsQntt = mainPage.getAllProducts().size();

        softAssertions.assertThat(actualProductsQntt)
                .as("Actual product quantity differs from expected")
                .isEqualTo(expectedProductQntt);

        // Check that Canon EOS 5D has old price 122.00
        double expectedOldPriceCanonEOS5D = 122.00;
        double actualOldPriceCanonEOS5D = findProductByName(mainPage.getAllProducts(), "Canon EOS 5D")
                .getProductPriceOldAsDouble();

        softAssertions.assertThat(actualOldPriceCanonEOS5D)
                .as("Old price is not the same as expected")
                .isEqualTo(expectedOldPriceCanonEOS5D);

        // Check that Canon EOS 5D has new price 98.00
        double expectedNewPriceCanonEOS5D = 98.00;
        double actualNewPriceCanonEOS5D = findProductByName(mainPage.getAllProducts(), "Canon EOS 5D")
                .getProductPriceCurrentAsDouble();

        softAssertions.assertThat(actualNewPriceCanonEOS5D)
                .as("New price is not the same as expected")
                .isEqualTo(expectedNewPriceCanonEOS5D);

        // Check that Nikon D300 has ex tax rate 80.00
        double expectedExRateNikonD300 = 80.00;
        double actualExRateNikonD300 = findProductByName(mainPage.getAllProducts(), "Nikon D300")
                .getProductTaxAsDouble();

        softAssertions.assertThat(actualExRateNikonD300)
                .as("Ex Tax Rate is not the same as expected")
                .isEqualTo(expectedExRateNikonD300);

        softAssertions.assertAll();
    }

}
