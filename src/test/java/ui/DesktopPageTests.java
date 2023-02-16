package ui;

import com.opencart.demo.components.Products;
import com.opencart.demo.enums.SortBy;
import com.opencart.demo.pages.DesktopsPage;
import com.opencart.demo.pages.MainPage;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.opencart.demo.helper.Helpers.getNamesFromProductList;
import static com.opencart.demo.helper.Helpers.getPricesFromList;

public class DesktopPageTests extends BaseTest {
    private MainPage mainPage = new MainPage();

    @Test
    public void checkTheValueInDropDownDesktops() {
        SoftAssertions softAssertions = new SoftAssertions();
        DesktopsPage desktopsPage;

        //Test #2
        // Check that value in Show dropdown is 10
        String expectedQnttInShow = "10";
        desktopsPage = mainPage.hoverOverDesktops()
                .clickOnShowAllDesktops();
        String actualQnttInShow = desktopsPage.getValueFromShowQnttOption();

        softAssertions.assertThat(actualQnttInShow)
                .as("Actual quantity of elements in Show is not as expected")
                .isEqualTo(expectedQnttInShow);

        // Check that value in Sort By is Default
        String expectedValueInSortBy = "Default";
        String actualValueInSortBy = mainPage.hoverOverDesktops()
                .clickOnShowAllDesktops()
                .getValueFromSortByOption();

        softAssertions.assertThat(actualValueInSortBy)
                .as("Actual value in Sort By is not as expected")
                .isEqualTo(expectedValueInSortBy);

        // Check that 10 products display on page
        int expectedQunttOfProducts = 10;
        int actualQunttOfProducts = mainPage.hoverOverDesktops()
                .clickOnShowAllDesktops()
                .getAllProducts().size();

        softAssertions.assertThat(actualQunttOfProducts)
                .as("Quantity of products differs from expected quantity")
                .isEqualTo(expectedQunttOfProducts);

        //Select 25 from Show dropdown. Check that 12 products are now displayed
        //Check that text 'Showing 1 to 12 of 12 (1 Pages)' displays on the bottom of the page

        expectedQunttOfProducts = 12;
        String expectedQnttTextOnTheBottom = "Showing 1 to 12 of 12 (1 Pages)";
        actualQunttOfProducts = desktopsPage.chooseShowQnttOption("25")
                .getAllProducts().size();
        String actualQnttTextOnTheBottom = desktopsPage.getTextShownOnTheBottom();

        softAssertions.assertThat(actualQunttOfProducts)
                .as("The quantity differs from expected")
                .isEqualTo(expectedQunttOfProducts);
        softAssertions.assertThat(actualQnttTextOnTheBottom)
                .as("The text on the bottom differs from expected")
                .isEqualTo(expectedQnttTextOnTheBottom);


        //Test #3
        //Check that products were sorted correctly (from A to Z)
        List<Products> actualProductList = desktopsPage.chooseSortByOption(SortBy.MODEL_A_Z)
                .getAllProducts();

        List<String> actualProductNamesList = new ArrayList<>(getNamesFromProductList(actualProductList));

        List<String> expectedNames = new ArrayList<>(actualProductNamesList);
        Collections.sort(expectedNames);

        softAssertions.assertThat(actualProductNamesList)
                .as("Names are not sorted properly")
                .containsExactlyElementsOf(expectedNames);

        //Check 'Price (Low > High)'
        mainPage = new MainPage();
        List<Products> actualProductsList = desktopsPage.chooseSortByOption(SortBy.PRICE_LOW_HIGH)
                .getAllProducts();

        List<Double> actualPricesList = new ArrayList<>(getPricesFromList(actualProductsList));
        List<Double> expectedPricesSortedList = new ArrayList<>(actualPricesList);
        Collections.sort(expectedPricesSortedList);

        softAssertions.assertThat(actualPricesList)
                .as("The price of the first product is bigger than the second")
                .containsExactlyElementsOf(expectedPricesSortedList);

        softAssertions.assertAll();
    }
}

