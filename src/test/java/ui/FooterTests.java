package ui;

import framework.pages.MainPage;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class FooterTests extends BaseTest {

  private final MainPage mainPage = new MainPage();

  @Test //Test #0
  public void testLabelsPresent() {
    List<String> expectedBrandsToSee = Arrays.asList("Apple", "Canon", "Hewlett-Packard", "HTC",
        "Palm", "Sony");

    List<String> actualNames = mainPage.goToTheFooter()
        .clickBrands()
        .findAllBrandsNames();

    Assertions.assertThat(actualNames)
        .as("List of brands differs from expected")
        .containsExactlyElementsOf(expectedBrandsToSee);
  }
}
