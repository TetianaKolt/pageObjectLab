package ui;

import static framework.helper.Helpers.findProductByName;

import framework.components.Products;
import framework.pages.MainPage;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

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
    int expectedProductQuantity = 2;
    int actualProductsQuantity = products.size();

    softAssertions.assertThat(actualProductsQuantity)
        .as("Actual product quantity differs from expected")
        .isEqualTo(expectedProductQuantity);

    // Check that Canon EOS 5D has old price 122.00
    double expectedOldPriceCanonEOS5D = 122.00;
    Products productByName = findProductByName(products, "Canon EOS 5D");

    double actualOldPriceCanonEOS5D = productByName.getProductPriceOldAsDouble();

    softAssertions.assertThat(actualOldPriceCanonEOS5D)
        .as("Old price of [Canon EOS 5D] is not the same as expected")
        .isEqualTo(expectedOldPriceCanonEOS5D);

    // Check that Canon EOS 5D has new price 98.00
    double expectedNewPriceCanonEOS5D = 98.00;

    double actualNewPriceCanonEOS5D = productByName.getProductPriceCurrentAsDouble();

    softAssertions.assertThat(actualNewPriceCanonEOS5D)
        .as("New price of [Canon EOS 5D] is not the same as expected")
        .isEqualTo(expectedNewPriceCanonEOS5D);

    // Check that Nikon D300 has ex tax rate 80.00
    double expectedExRateNikonD300 = 80.00;
    double actualExRateNikonD300 = findProductByName(products, "Nikon D300")
        .getProductTaxAsDouble();

    softAssertions.assertThat(actualExRateNikonD300)
        .as("Ex Tax Rate of [Nikon D300] is not the same as expected")
        .isEqualTo(expectedExRateNikonD300);
    softAssertions.assertAll();
  }
}
