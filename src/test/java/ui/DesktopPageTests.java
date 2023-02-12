package ui;

import com.opencart.demo.components.Products;
import com.opencart.demo.enums.SortBy;
import com.opencart.demo.pages.DesktopsPage;
import com.opencart.demo.pages.MainPage;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.opencart.demo.helper.Helpers.getPricesFromList;
import static com.opencart.demo.helper.Helpers.getNamesFromProductList;

public class DesktopPageTests extends BaseTest {
    private MainPage mainPage = new MainPage();
    private DesktopsPage desktopsPage;
    SoftAssertions softAssertions;


    @Test    //Test #2
    public void checkTheValueInDropDownDesktops() {
        desktopsPage = new DesktopsPage();

        // Check that value in Show dropdown is 10
        String expectedQnttInShow = "10";
        DesktopsPage desktopsPage = mainPage.hoverOverDesktops()
                .clickOnShowAllDesktops();
        String actualQnttInShow = desktopsPage.getValueFromShowQnttOption();

        Assertions.assertThat(actualQnttInShow)
                .as("Actual quantity of elements in Show is not as expected")
                .isEqualTo(expectedQnttInShow);
    }

    @Test //Test #2
    public void checkTheValueInSortBy() {
        // Check that value in Sort By is Default
        String expectedValueInSortBy = "Default";
        String actualValueInSortBy = mainPage.hoverOverDesktops()
                .clickOnShowAllDesktops()
                .getValueFromSortByOption();

        Assertions.assertThat(actualValueInSortBy)
                .as("Actual value in Sort By is not as expected")
                .isEqualTo(expectedValueInSortBy);
    }

    @Test  //Test #2
    public void checkDefaultQnttOfProductsDisplayed() {
        // Check that 10 products display on page
        int expectedQunttOfProducts = 10;

        int actualQunttOfProducts = mainPage.hoverOverDesktops()
                .clickOnShowAllDesktops()
                .getAllProducts().size();

        Assertions.assertThat(actualQunttOfProducts)
                .as("Quantity of products differs from expected quantity")
                .isEqualTo(expectedQunttOfProducts);
    }

    @Test //Test #2
    public void checkQnttOfProductsDisplayed() {
        //Select 25 from Show dropdown. Check that 12 products are now displayed
        //Check that text 'Showing 1 to 12 of 12 (1 Pages)' displays on the bottom of the page
        desktopsPage = new DesktopsPage();
        softAssertions = new SoftAssertions();

        int expectedQunttOfProducts = 12;
        String expectedQnttTextOnTheBottom = "Showing 1 to 12 of 12 (1 Pages)";

        int actualQunttOfProducts = mainPage.hoverOverDesktops()
                .clickOnShowAllDesktops()
                .chooseShowQnttOption("25")
                .getAllProducts().size();
        String actualQnttTextOnTheBottom = desktopsPage.getTextShownOnTheBottom();

        softAssertions.assertThat(actualQunttOfProducts)
                .as("The quantity differs from expected")
                .isEqualTo(expectedQunttOfProducts);
        softAssertions.assertThat(actualQnttTextOnTheBottom)
                .as("The text on the bottom differs from expected")
                .isEqualTo(expectedQnttTextOnTheBottom);
        softAssertions.assertAll();

    }

    @Test //Test #3
    public void checkTheProductsSortedNamesAZ() {
        //Check that products were sorted correctly (from A to Z)
        List<Products> actualProductList = mainPage.hoverOverDesktops()
                .clickOnShowAllDesktops()
                .chooseSortByOption(SortBy.MODEL_A_Z)
                .getAllProducts();

        List<String> actualProductNamesList = new ArrayList<>(getNamesFromProductList(actualProductList));

        List<String> expectedNames = new ArrayList<>(actualProductNamesList);
        Collections.sort(expectedNames);

        Assertions.assertThat(actualProductNamesList)
                .as("Names are not sorted properly")
                .isEqualTo(expectedNames);

    }

    @Test //Test #3
    public void checkTheProductsSortedPrice() {
        //Check 'Price (Low > High)'
        mainPage = new MainPage();
        List<Products> actualProductsList = mainPage.hoverOverDesktops()
                .clickOnShowAllDesktops()
                .chooseSortByOption(SortBy.PRICE_LOW_HIGH)
                .getAllProducts();

        List<Double> actualPricesList = new ArrayList<>(getPricesFromList(actualProductsList));
        List<Double> expectedPricesSortedList = new ArrayList<>(actualPricesList);
        Collections.sort(expectedPricesSortedList);

        Assertions.assertThat(actualPricesList)
                .as("The price of the first product is bigger than the second")
                .isEqualTo(expectedPricesSortedList);
    }




}

