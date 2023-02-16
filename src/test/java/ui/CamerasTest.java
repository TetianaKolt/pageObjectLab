package ui;

import com.opencart.demo.components.Products;
import com.opencart.demo.pages.MainPage;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

import java.util.List;

import static com.opencart.demo.helper.Helpers.findProductByName;

public class CamerasTest extends BaseTest {
    private final MainPage mainPage = new MainPage();

    @Test         // Test #5
    public void camerasTest() {
        SoftAssertions softAssertions = new SoftAssertions();

        mainPage.getNavigationBar()
                .getCameras()
                .click();

        List<Products> products = mainPage.getAllProducts();
        //Check that 2 cameras exist on page
        int expectedProductQntt = 2;
        int actualProductsQntt = products.size();

        softAssertions.assertThat(actualProductsQntt)
                .as("Actual product quantity differs from expected")
                .isEqualTo(expectedProductQntt);

        // Check that Canon EOS 5D has old price 122.00
        double expectedOldPriceCanonEOS5D = 122.00;
        double actualOldPriceCanonEOS5D = findProductByName(products, "Canon EOS 5D")
                .getProductPriceOldAsDouble();

        softAssertions.assertThat(actualOldPriceCanonEOS5D)
                .as("Old price is not the same as expected")
                .isEqualTo(expectedOldPriceCanonEOS5D);

        // Check that Canon EOS 5D has new price 98.00
        double expectedNewPriceCanonEOS5D = 98.00;

        double actualNewPriceCanonEOS5D = findProductByName(products, "Canon EOS 5D")
                .getProductPriceCurrentAsDouble();

        softAssertions.assertThat(actualNewPriceCanonEOS5D)
                .as("New price is not the same as expected")
                .isEqualTo(expectedNewPriceCanonEOS5D);

        // Check that Nikon D300 has ex tax rate 80.00
        double expectedExRateNikonD300 = 80.00;
        double actualExRateNikonD300 = findProductByName(products, "Nikon D300")
                .getProductTaxAsDouble();

        softAssertions.assertThat(actualExRateNikonD300)
                .as("Ex Tax Rate is not the same as expected")
                .isEqualTo(expectedExRateNikonD300);
        softAssertions.assertAll();
    }
}
