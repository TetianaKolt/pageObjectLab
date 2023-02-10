package ui;

import com.opencart.demo.enums.SortBy;
import com.opencart.demo.helper.Helpers;
import com.opencart.demo.pages.DesktopsPage;
import com.opencart.demo.pages.MainPage;
import com.opencart.demo.components.DesktopComponents;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesktopPageTests extends BaseTest {
    private MainPage mainPage = new MainPage();
    private DesktopsPage desktopsPage;

    SoftAssertions softAssertions;
    Helpers helpers;

//**********************
    @Test                                               // Check that value in Show dropdown is 10
    public void checkTheValueInDropDownDesktops() {
        desktopsPage = new DesktopsPage();
        String expectedQnttInShow = "10";

        DesktopsPage desktopsPage = mainPage.hoverOverDesktops()
                .clickOnShowAllDesktops();
        String actualQnttInShow = desktopsPage.getValueFromShowQnttOption();

        Assertions.assertThat(actualQnttInShow)
                .as("Actual quantity of elements in Show is not as expected")
                .isEqualTo(expectedQnttInShow);
    }
// ******************************************
    @Test                                               // Check that value in Sort By is Default
    public void checkTheValueInSortBy() {
        String expectedValueInSortBy = "Default";
        String actualValueInSortBy = mainPage.hoverOverDesktops()
                .clickOnShowAllDesktops()
                .getValueFromSortByOption();

        Assertions.assertThat(actualValueInSortBy)
                .as("Actual value in Sort By is not as expected")
                .isEqualTo(expectedValueInSortBy);
    }
//*************************************************
    @Test                                               // Check that 10 products display on page
    public void checkDefaultQnttOfProductsDisplayed() {
        mainPage = new MainPage();
        int expectedQunttOfProducts = 10;

        int actualQunttOfProducts = mainPage.hoverOverDesktops()
                .clickOnShowAllDesktops()
                .getAllProducts().size();

        Assertions.assertThat(actualQunttOfProducts)
                .as("Quantity of products differs from expected quantity")
                .isEqualTo(expectedQunttOfProducts);
    }

    @Test                           //Select 25 from Show dropdown. Check that 12 products are now displayed
                                    //Check that text 'Showing 1 to 12 of 12 (1 Pages)' displays on the bottom of the page
    public void checkQnttOfProductsDisplayed() {
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
                .as("The quantity differs from expected").isEqualTo(expectedQunttOfProducts);
        softAssertions.assertThat(actualQnttTextOnTheBottom)
                .as("The text on the bottom differs from expected").isEqualTo(expectedQnttTextOnTheBottom);
        softAssertions.assertAll();

    }

    @Test                           //Check that products were sorted correctly (from A to Z)
    public void checkTheProductsSortedNamesAZ() {
        helpers = new Helpers();
        List<String> actualProductsNamesList = new ArrayList<>();
        List<DesktopComponents> actualProductsList = mainPage.hoverOverDesktops()
                .clickOnShowAllDesktops()
                .chooseSortByOption(SortBy.MODEL_A_Z)
                .getAllProducts();

        helpers.sortProductList(actualProductsNamesList, actualProductsList);

        List<String> expectedNames = new ArrayList<>(actualProductsNamesList);
        Collections.sort(expectedNames);

        Assertions.assertThat(actualProductsNamesList)
                .as("Names are not sorted properly").isEqualTo(expectedNames);

    }

 ///// cut method sort from this place

    @Test                           //Check 'Price (Low > High)'
    public void checkTheProductsSortedPrice() {
        mainPage = new MainPage();
        List<Double> actualPricesList = new ArrayList<>();
        List<DesktopComponents> actualProductsList = mainPage.hoverOverDesktops()
                .clickOnShowAllDesktops()
                .chooseSortByOption(SortBy.PRICE_LOW_HIGH)
                .getAllProducts();

        for (DesktopComponents dc : actualProductsList) {
            actualPricesList.add(dc.productPriceCurrentInt());
        }

        List<Double> expectedPricesSortedList = new ArrayList<>(actualPricesList);
        Collections.sort(expectedPricesSortedList);


        Assertions.assertThat(actualPricesList)
                .as("The price of the first product is bigger than the second")
                .isEqualTo(expectedPricesSortedList);
    }


}

